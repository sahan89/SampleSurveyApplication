/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*

package com.gr.survey.login;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.gr.survey.dao.UserDAO;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean implements Serializable {

    private int id;
    private String username;
    private String password;
    private String message;
    private int status;
    private int privilege;
    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String userLogin() throws SQLException, IOException {
        boolean result = UserDAO.login(username, password);
        if (result) {
            HttpSession session = Util.getSession();
            session.setAttribute("username", username);
            String username = (String) session.getAttribute("username");
            return "/home.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));
            return "/login.xhtml";
        }
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "/login.xhtml";
    }

    public String home() {
        return "insert";
    }
}*/
