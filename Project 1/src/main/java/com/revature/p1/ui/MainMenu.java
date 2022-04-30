package com.revature.p1.ui;

import com.revature.p1.dao.StoreDAO;
import com.revature.p1.services.StoreService;

import java.util.Scanner;

public class MainMenu implements IMenu {


    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        exit: {
            while (true) {
                System.out.println("\nWelcome User");
                System.out.println("[1] Browse online");
                System.out.println("[2] Locate store");
                System.out.println("[x] Exit");
                    input = scan.next().charAt(0);


                    switch (input) {
                        case '1':
                            new CartMenu();
                            break;
                        case '2':
                            new StoreMenu(user, new StoreService(new StoreDAO())).start();
                            break;
                        case 'x':
                            break exit;

                        default:
                            System.out.println("Invalid input");
                            break;

                    }



            }
        }


    }


    public void ItemMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("....loading");
            System.out.println("....loading...");
            if (scan.next().charAt(0) == 'y') {
                new CartMenu().start();
            }
        }











    }
    }



