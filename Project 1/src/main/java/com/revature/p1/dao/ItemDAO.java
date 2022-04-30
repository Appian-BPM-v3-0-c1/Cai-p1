package com.revature.p1.dao;

import com.revature.p1.connection.DatabaseConnection;
import com.revature.p1.models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements CrudDAO<Item> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Item obj) {
        return 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                item.setStore_Id(rs.getInt("store_id"));

                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return itemList;
    }

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public List<Item> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Item updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}