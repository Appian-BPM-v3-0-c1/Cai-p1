package com.revature.p1.services;

import com.revature.p1.dao.ItemDAO;

public class ItemService  {
    private final ItemDAO itemDAO;

    public ItemService (ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }
}













//}



