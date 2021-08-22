package ir.maktab.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {

    public static Connection connection;

    public static final String url = "jdbc:mysql://localhost:3306/";
    public static final String dbAdmin = "root";
    public static final String dbAdminPass = "MKuJNV+3W?%wE&D5";
    public static final String initDataBase = "CREATE SCHEMA IF NOT EXISTS `articles_app`;";
    public static final String useDataBase = "USE `articles_app`;";

    static {

        try {
            connection = DriverManager.getConnection(url, dbAdmin, dbAdminPass);
            connection.createStatement().executeUpdate(initDataBase);
            connection.createStatement().executeUpdate(useDataBase);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
