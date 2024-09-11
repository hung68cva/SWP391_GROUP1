/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hung Bui
 */
public class DBContext {
//    public static Connection getConnection() throws SQLException {
//        Connection con = null;
//        String dbUser = "sa";
//        String dbPassword = "123";
//        String dbURL = "jdbc:sqlserver://DESKTOP-5EKHCDV\\HUNG:1433;databaseName=Trading2022";
//
//        try {
//            con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            throw e;
//        }
//        return con;
//    }
    
    protected Connection connection;
    public DBContext() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-5EKHCDV\\HUNG:1433;databaseName=ModernLogin";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
