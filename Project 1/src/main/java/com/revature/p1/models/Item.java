package com.revature.p1.models;

public class Item  {
    public int id;
    public String name;
    public int price;
    public int store_id;

    public Item(int id, String name, int price, int store_id){
        this.id = id;
        this.name = name;
        this.price = price;
        this.store_id = store_id;

    }

    public Item() {

    }


    public void setName(String name) {
    }

    public void setId(int id) {
    }

    public void setPrice(int price) {
    }

    public void setStore_Id(int store_id) {
    }
}
