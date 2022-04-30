package com.revature.p1.dao;

import com.revature.p1.connection.DatabaseConnection;
import com.revature.p1.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User> {

    Connection con = DatabaseConnection.getCon();
    @Override
    public int save(User obj) {

        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (firstname, lastname, city, state, zip, username, password, user_type) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getFirstname());
            ps.setString(2, obj.getLastname());
            ps.setString(3, obj.getCity());
            ps.setString(4, obj.getState());
            ps.setString(5, obj.getZip());
            ps.setString(6, obj.getUsername());
            ps.setString(7, obj.getPassword());
            ps.setString(8, obj.getUser_type());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<User>findAll() {
        List<User> userList= new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                userList.add(user);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  userList;


    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUsernames() {
        List<String> username_list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                username_list.add(rs.getString("username"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  username_list;
    }


}

