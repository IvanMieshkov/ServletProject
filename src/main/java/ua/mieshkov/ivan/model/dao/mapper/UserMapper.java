package ua.mieshkov.ivan.model.dao.mapper;

import ua.mieshkov.ivan.model.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("user_id");
        String nameUkr = rs.getString("user_name_ukr");
        String nameEn = rs.getString("user_name_en");
        String login = rs.getString("user_login");
        String password = rs.getString("user_password");
        String gender = rs.getString("user_gender");
        String email = rs.getString("user_email");
        String role = rs.getString("user_role");
        Boolean active = rs.getBoolean("user_active");

        return new User(id, nameUkr, nameEn, login,
                password, gender, email, role, active);
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
}