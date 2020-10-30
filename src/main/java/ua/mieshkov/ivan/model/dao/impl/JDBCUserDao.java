package ua.mieshkov.ivan.model.dao.impl;

import ua.mieshkov.ivan.model.dao.UserDao;
import ua.mieshkov.ivan.model.dao.mapper.UserMapper;
import ua.mieshkov.ivan.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.mieshkov.ivan.string.container.QueryContainer.*;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private UserMapper userMapper = new UserMapper();
    private Map<Integer, User> users = new HashMap<>();

    JDBCUserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(User entity) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, entity.getNameUkr());
            statement.setString(2, entity.getNameEn());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getGender());
            statement.setString(6, entity.getEmail());
            statement.setString(7, entity.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID)) {
            statement.setInt(1, id);

            return findUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByLogin(String login) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_LOGIN)) {
            statement.setString(1, login);

            return findUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            return findUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS)) {

            return findUsersList(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User entity) {
    }

    @Override
    public void updatePassword(Integer id, String newPassword) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PASSWORD)) {
            statement.setString(1, newPassword);
            statement.setInt(2, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findByRole(String role) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ROLE)) {
            statement.setString(1, role);

            return findUsersList(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User findUser(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        User user = null;

        if(resultSet.next()) {
            user = userMapper.extractFromResultSet(resultSet);
            userMapper.makeUnique(users, user);
        }
        resultSet.close();

        return user;
    }

    private List<User> findUsersList(PreparedStatement statement) throws SQLException{
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            User user = userMapper.extractFromResultSet(resultSet);
            userMapper.makeUnique(users, user);
        }
        resultSet.close();

        return new ArrayList<>(users.values());
    }
}
