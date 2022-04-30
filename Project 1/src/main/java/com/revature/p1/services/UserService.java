package com.revature.p1.services;

import com.revature.p1.dao.UserDAO;
import com.revature.p1.models.User;
import com.revature.p1.ui.IMenu;

import java.util.List;

public class UserService implements IMenu {
    public void start() {}

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public boolean isDupUsername(String username){
        List<String> username_list = userDAO.findAllUsernames();

        for (String u : username_list) {
          if (u.equals(username)) {
              return true;
          }
        }
        return false;
    }

    public boolean isValidUsername(String username) {
        return username.matches("^[a-z0-9_-]{5,15}$");

    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    }


    public boolean isValidLoginUsername(String username) {
        List<String> username_list = userDAO.findAllUsernames();

        for (String u : username_list) {
            if (u.equals(username)) {
                return true;
            }
        }
        return false;
    }
    public boolean isValidLogin(User user){
        List<User> userList = userDAO.findAll();

        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()));
                return true;
        }
        return false;
    }

}







