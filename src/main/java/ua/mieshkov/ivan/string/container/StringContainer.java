package ua.mieshkov.ivan.string.container;

public interface StringContainer {

    String QUERIES_BUNDLE = "queries";
    String USER_LOGGED = "user";
    String USER_LOGGED_ROLE = "role";
    String CLIENT_ROLE = "client";
    String MASTER_ROLE = "master";
    String ADMIN_ROLE = "admin";
    String LOCALE_UKR = "uk";
    String LOCALE_EN = "en";
    String LANGUAGE = "language";

    /* MySQL connection*/
    String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    String DATABASE = "jdbc:mysql://localhost:3306/beauty_salonDB?useSSL=false&serverTimezone=UTC";
    String DATABASE_LOGIN = "root";
    String DATABASE_PASSWORD = "root";


    String USER_NAME_UKR_INCORRECT = "warn.incorrect.user.name.ukr";
    String USER_NAME_LAT_INCORRECT = "warn.incorrect.user.name.lat";
    String LOGIN_INCORRECT = "warn.incorrect.user.login";
    String PASSWORD_INCORRECT = "warn.incorrect.user.password";
    String EMAIL_INCORRECT = "warn.incorrect.user.email";
    String LOGIN_EXISTS = "warn.login.exists";
    String INCORRECT_PASSWORD_WARNING = "warn.incorrect.password";



    String INDEX_PAGE = "/view/index.jsp";
    String LOGIN_PAGE = "/view/login.jsp";
    String REGISTRATION_PAGE = "/view/registration.jsp";


}
