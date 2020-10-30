package ua.mieshkov.ivan.string.container;

public interface QueryContainer {
    String CREATE_USER = "INSERT INTO users(user_name_ukr, user_name_en, user_login," +
            " user_password, user_gender, user_email, user_role)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";
    String FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE user_login = ?";
    String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE user_login = ? AND user_password = ?";
    String FIND_ALL_USERS = "SELECT * FROM users";
    String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id = ?";
    String UPDATE_USER_PASSWORD = "UPDATE users SET user_password = ? WHERE user_id = ?";
    String FIND_USER_BY_ROLE = "SELECT * FROM users WHERE user_role = ?";

}

