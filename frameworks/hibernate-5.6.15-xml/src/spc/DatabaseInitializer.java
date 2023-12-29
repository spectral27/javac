package spc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInitializer {

    private static final String H2DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:mem:hibernatedatabase;INIT=runscript from 'classpath:initialize.sql'";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void initialize() {
        try {
            Class.forName(H2DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            System.exit(1);
        }

        try {
            DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            System.exit(1);
        }
    }

}
