package com.nixsolution.ppp.servlet_jsp.util;

public class SqlCommand {
    public static final String RESOURCES_PATH = "src/main/resources/database.properties";

    public static final String TABLE_USERS = "USER";
    public static final String TABLE_ROLES = "ROLE";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS +
            "(id LONG AUTO_INCREMENT," +
            " login VARCHAR(50)," +
            " password VARCHAR(50)," +
            " email VARCHAR(50)," +
            "firstName VARCHAR(50)," +
            " lastName VARCHAR(50)," +
            " birthday VARCHAR(50)," +
            "roleId LONG ," +
            "FOREIGN KEY (roleID) REFERENCES role (id))";
    public static final String CREATE_TABLE_ROLES = "CREATE TABLE IF NOT EXISTS " + TABLE_ROLES +
            "(id LONG AUTO_INCREMENT, " +
            "name VARCHAR(50))";

    public static final String UPDATE_USER = "UPDATE USER SET" +
            " login=?, password=?, email=?, firstName=?, lastName=?, birthday=?, roleId=? WHERE id =?";
    public static final String INSERT_INTO_USERS = "INSERT INTO user " +
            "(login, password, email, firstName, lastName, birthday, roleId) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String FIND_ALL_USERS = "SELECT user.id AS id, login, password, email, firstName, lastName," +
            "birthday,roleId,name FROM user LEFT JOIN role ON user.roleId = role.id";
    public static final String FIND_USER_BY_EMAIL = FIND_ALL_USERS + " WHERE user.email =?";
    public static final String FIND_USER_BY_LOGIN = FIND_ALL_USERS + " WHERE user.login =?";
    public static final String FIND_USER_BY_ID = FIND_ALL_USERS + " WHERE user.id =?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id=?";

    public static final String UPDATE_ROLES = "UPDATE role SET name=?  WHERE id=?";
    public static final String DELETE_FROM_ROLES = "DELETE FROM role WHERE id=?";
    public static final String FIND_BY_NAME_IN_ROLES = "SELECT * FROM role WHERE name=?";
    public static final String INSERT_INTO_ROLES = "INSERT INTO role SET name =?";
    public static final String FIND_ALL_ROLES = "SELECT * FROM role";
    public static final String FIND_ROLE_BY_ID = "SELECT * FROM role WHERE id=?";
}
