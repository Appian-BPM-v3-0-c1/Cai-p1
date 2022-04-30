package com.revature.p1.dao;

import com.revature.p1.models.Store;

import java.util.List;

public class StoreDAO implements CrudDAO<Store> {

    @Override
    public int save(Store obj) {
        return 0;
    }

    @Override
    public List<Store> findAll() {
        return null;
    }

    @Override
    public Store findById(int id) {
        return null;
    }

    @Override
    public List<Store> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Store updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}

