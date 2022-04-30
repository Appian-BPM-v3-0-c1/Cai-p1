package com.revature.p1.ui;

import com.revature.p1.models.User;
import com.revature.p1.services.UserService;

import java.util.Scanner;

public class LoginMenu implements IMenu{
   private UserService userService;


    public LoginMenu(UserService userService) {
        this.userService = userService;
    }
    Scanner scan = new Scanner(System.in);
    User user = new User();
    @Override
    public void start() {
        char input = ' ';


      exit: {
         while (true) {
              System.out.println("\nWelcome to Fresh Fruit");
              System.out.println("[1] Log in");
             System.out.println("[2] Create Account");
              System.out.println("[x] Exit");

             input = scan.next().charAt(0);

             switch (input) {
                 case '1':
                     login();
                     break;

                 case '2':
                      createAccount();
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

   private void createAccount() {
        String firstname = "";
        String lastname = "";
        String city = "";
       String state = "";
        String zip = "";
       String username = "";
        String password = "";

       System.out.println("Begin process....");

        while (true) {

            System.out.println("\nEnter first name:");
            firstname = scan.next();
            user.setFirstname(firstname);
            System.out.println("\nEnter last name:");
            lastname = scan.next();
            user.setLastname(lastname);

            System.out.println("\nEnter city:");
            city = scan.next();
            user.setCity(city);

            System.out.println("\nEnter state");
            state = scan.next();
            user.setState(state);

            System.out.println("\nEnter zip: ");
            zip = scan.next();
            user.setZip(zip);

            while (true) {

                System.out.println("Enter username:");
                username = scan.next();

                if (!userService.isDupUsername(username)) {
                    if (userService.isValidUsername(username)) {
                        user.setUsername(username);
                       break;
                    } else {
                        System.out.println("Invalid username. Try again.");
                    }
                } else {
                   System.out.println("Duplicate username. Try again.");
                }
            }

            while (true) {
                System.out.println("Please enter a password:");
                password = scan.next();

                if (userService.isValidPassword(password)) {
                    user.setPassword(password);

                    break;
                } else {
                    System.out.println("Invalid password. Try again.");
                }
            }

            System.out.println("Please confirm your details:");
            System.out.println("Username: " + username);
            System.out.println("First name: " + firstname);
            System.out.println("Is this correct? y/n");

            if (scan.next().charAt(0) == 'y') {
                System.out.println("Account created successfully!");
               userService.getUserDAO().save(user);
               break;

            }

        }

    }

    private void login() {


        while (true) {
            System.out.println("\n Username: ");
            user.setUsername(scan.next());

            System.out.println("\n Password: ");
            user.setPassword(scan.next());

            if (userService.isValidLogin(user)) {
                new MainMenu().start();
                break;
            }

        }

    }
}


