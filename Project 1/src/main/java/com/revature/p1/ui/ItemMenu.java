package com.revature.p1.ui;


import com.revature.p1.models.Item;
import com.revature.p1.services.ItemService;

import java.util.List;

public class ItemMenu  {
    public ItemMenu(ItemService itemService) {
        List<Item> itemsList = itemService.getItemDAO().findAll();
        for (int i = 0; i < itemsList.size(); i++) {

        }

    }
}