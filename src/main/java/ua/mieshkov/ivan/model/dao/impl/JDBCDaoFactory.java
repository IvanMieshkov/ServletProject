package ua.mieshkov.ivan.model.dao.impl;

import ua.mieshkov.ivan.model.dao.DaoFactory;
import ua.mieshkov.ivan.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }
}
