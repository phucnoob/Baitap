
package com.ata;

import java.util.Scanner;


/**
 * Menu class is responsible for greeting the user, showing a menu
 * <p>
 * to the user for interaction with the application.
 * <p>
 * The class maintains a String[] array of menu options, which it
 * <p>
 * uses for printing the menu to standard out.
 * <p>
 * The class is also responsible for responding to user interaction
 * <p>
 * with respect to its menu.
 */

public class Menu {

    private boolean closed = false;

    String[] menuOptions = {

        "Exit",

        "List Products",

        "Buy Product",

        "Find Product",

        "Show Cart",

        "Checkout"

    };


    private String[] products = {

        "Crew Neck",
        "V-Neck",
        "Polo",
        "Boat Neck",
        "Tank Top"

    };


    private Scanner scanner;

    private Shop shop;


    /**
     * Class constructor, which expects a Scanner object
     * <p>
     * It allows for the user to specify how a Scanner is to
     * <p>
     * be configured outside this class and for basic inversion of control.
     *
     * @param scanner takes in a Scanner object to initialize
     */

    public Menu(Scanner scanner, Shop shop) {

        this.scanner = scanner;
        this.shop = shop;
        this.closed = false;
    }


    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * <p>
     * It accepts user input using the encapsulated Scanner instance.
     * <p>
     * All output is printed to standard out.
     * <p>
     * All input is collected from standard in.
     */

    public void executeMenu() {

        while (!isClosed()) {
            printMenu();

            int select = getNextIntFromUser();
            if (select == 0) {
                exit();
            } else if (select == 1) {
                shop.printProducts();
            } else if (select == 2) {
                System.out.println("Please enter the ID of the product you would like to purchase:");
                int id = getNextIntFromUser();
                shop.addToCart(id);
            } else if (select == 3) {
                System.out.println("Enter the item to search for:");
                String findItem = seekProduct();
                int index = shop.findProduct(findItem);
                if (index == -1) {
                    System.out.println("That product was not found.");
                } else {
                    System.out.println(findItem + " was found and its product id is " + index);
                }
            } else if (select == 4) {
                shop.showCartDetails();
            } else if (select == 5) {
                shop.checkoutCart();
                exit();
            }
        }
        //exit();

    }


    /**
     * Asks the user to enter their name.
     * <p>
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */

    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + " to " + "T-Shirt Mart");
    }


    /**
     * Prints the menu header and menu options.
     */

    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

    /*

    public void printProducts() {

        System.out.println("--Products--");

        for (int i = 0; i < products.length; i++) {

            System.out.print("ID " + i + ": ");

            System.out.println(products[i]);

        }

    }





    public int findProduct(String searchText) {

        for (int i = 0; i < products.length; i++) {

            if (searchText.equals(products[i])) {

                return i;

            }



        } return -1;

    }

      */

    private String seekProduct() {

        String itemToFind = getNextStringLineFromUser();

        return itemToFind;

    }


    /**
     * Prints an exit statement and closes the scanner object.
     */

    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
        closed = true;
    }


    /**
     * Collects next user-entered int.
     *
     * @return integer value denoting the user selection
     */

    private int getNextIntFromUser() {

        return scanner.nextInt();

    }


    /**
     * Skips a line of empty input from the scanner's input stream
     * <p>
     * and then returns the next available line.
     *
     * @return string representing the line of input typed by the user
     */

    /*public int getProducts(){

        String itemToFind = getNextStringLineFromUser();

        return Integer.valueOf(itemToFind);



    } */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public boolean isClosed() {
        return closed;
    }
}
