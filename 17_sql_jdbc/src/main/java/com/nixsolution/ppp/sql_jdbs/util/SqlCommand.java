package com.nixsolution.ppp.sql_jdbs.util;

public class SqlCommand {

    public static String TABLE_USERS = "USER";
    public final static String TABLE_ROLES = "ROLE";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS +
            "(id LONG AUTO_INCREMENT  PRIMARY KEY NOT NULL  ," +
            " login VARCHAR(50)," +
            " password VARCHAR(50)," +
            " email VARCHAR(50)," +
            "firstName VARCHAR(50)," +
            " lastName VARCHAR(50)," +
            " birthday VARCHAR(50)," +
            "roleId LONG ," +
            "CONSTRAINT fk_user_roleId foreign key (roleId) references role(id))";
    public static final String CREATE_TABLE_ROLES = "CREATE TABLE IF NOT EXISTS " + TABLE_ROLES +
            "(id LONG AUTO_INCREMENT  PRIMARY KEY NOT NULL , " +
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
    public static final String INSERT_INTO_ROLES = "INSERT INTO role (id,name) VALUES (?,?)";
    public static final String FIND_ALL_ROLES = "SELECT * FROM role";
    public static final String FIND_ROLE_BY_ID = "SELECT * FROM role WHERE id=?";
}
