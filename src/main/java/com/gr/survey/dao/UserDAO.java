package com.gr.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static boolean login(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("select username, password from users where username= ? and password= ?  and status= 1");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Username--->>> " + rs.getString("username"));
                System.out.println("Password--->>> " + rs.getString("password"));
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            con.close();
        }
    }
}