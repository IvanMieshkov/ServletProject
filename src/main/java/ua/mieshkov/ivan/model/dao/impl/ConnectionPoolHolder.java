package ua.mieshkov.ivan.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

import static ua.mieshkov.ivan.string.container.StringContainer.*;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName(MYSQL_DRIVER);
                    ds.setUrl(DATABASE);
                    ds.setUsername(DATABASE_LOGIN);
                    ds.setPassword(DATABASE_PASSWORD);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}
