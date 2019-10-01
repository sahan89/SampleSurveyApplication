/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr.survey.dao;

import java.io.IOException;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@ManagedBean(name = "dbConnection")
public class DBConnection {

    public static Connection getConnection() throws IOException {
        Connection conMy = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conMy = DriverManager.getConnection("jdbc:mysql://localhost:3306/survey2020?useUnicode=true&characterEncoding=UTF-8", "root", "root");
//            conMy = DriverManager.getConnection("jdbc:mysql://localhost:3306/addmonitor?useUnicode=true&characterEncoding=UTF-8", "socweb", "socweb@2014");

        } catch (ClassNotFoundException ex) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        } catch (IllegalAccessException ex) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        } catch (InstantiationException ex) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        } catch (SQLException ex) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        }
        return conMy;
    }

    public static void main(String args[]) throws SQLException, IOException {
        DBConnection db = new DBConnection();
        if (db.getConnection() != null) {
            System.out.println("Connected.!! :)");
        } else {
            System.out.println("Not Connected.!! :(");
        }
    }
}
