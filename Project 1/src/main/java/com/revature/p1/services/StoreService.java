package com.revature.p1.services;

import com.revature.p1.dao.StoreDAO;

public class StoreService {
    private final StoreDAO storeDAO;


    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public StoreDAO getStoreDAO() {
        return storeDAO;
    }
}
