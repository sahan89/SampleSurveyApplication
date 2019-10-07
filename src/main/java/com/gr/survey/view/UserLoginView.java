package com.gr.survey.view;

import com.gr.survey.login.Util;
import com.gr.survey.model.Users;
import com.gr.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@ViewScoped
@ManagedBean(name = "userLoginView")
@SessionScoped
public class UserLoginView {

    @Autowired
    private UserRepository userRepository;

    private String username;
    private String password;
    private HttpSession session = Util.getSession();

    public String userLogin() {
        FacesContext message = FacesContext.getCurrentInstance();
        System.out.println("username ---> " + username);
        System.out.println("password ---> " + password);

        Users user = userRepository.findUsersByUsernameAndPasswordAndStatus(username, password, 1);

        if (user != null && user.getUsername() != null && user.getPassword() != null) {
            session.setAttribute("username", username);
            String xxx = (String) session.getAttribute("username");
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

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
