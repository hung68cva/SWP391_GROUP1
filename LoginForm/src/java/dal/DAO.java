/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author Hung Bui
 */
public class DAO extends DBContext {

    public User check(String username, String password) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[User]\n"
                + "  WHERE Username=? and Password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User a = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public boolean register(String username, String password) {
        String sql = "INSERT INTO "
                + "[dbo].[User] "
                + "(Username, Password, role) "
                + "VALUES (?, ?, 1)"; 
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isEmailExists(String email) {
        String sql = "SELECT 1 FROM [dbo].[User] WHERE Username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
