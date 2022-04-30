package com.revature.p1.ui;

import com.revature.p1.connection.DatabaseConnection;
import com.revature.p1.dao.CrudDAO;
import com.revature.p1.dao.StoreDAO;
import com.revature.p1.models.Store;
import com.revature.p1.models.User;
import com.revature.p1.services.StoreService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class StoreMenu implements IMenu {
    private final StoreService storeService;
    private final User user;

    Connection con = DatabaseConnection.getCon();
    CrudDAO<Store> crudDAO = new StoreDAO();
    Scanner scan = new Scanner(System.in);


    public StoreMenu(StoreService storeService, User user) {
        this.storeService = storeService;
        this.user = user;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("[1] Search store");
            System.out.println("[2] review store as admin");
            System.out.println("[x] exit");

            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    createSearchStore();
                    break;
                case '2':

                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
        }

    }

    private void createSearchStore() {
        int input = 0;
        while (true) {
            List<Store> store = storeService.getStoreDAO().findAll();


            System.out.println("\nSearching for store location.....");


            for (int i = 0; i < store.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + store.get(i));
            }


        }


    }
}

