package com.ata;

import org.jetbrains.annotations.Nullable;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ShopRunner class is the main entry point for the application.
 * It encapsulates a Menu, providing it with a Scanner configured
 * with System.in to allow the menu to read from standard in.
 * When the application starts, the menu's greet and show methods are called.
 */

public class ShopRunner {

    /**
     * Main entry point to the application.
     * Asks the menu's greeting to be printed to standard out by calling its greet method.
     * Asks the menu to be shown by calling its show method.
     *
     * @param args Command line arguments to the application
     */

    public static void main(@Nullable String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String[] names = {"Crew Neck", "V-Neck", "Polo", "Boat Neck", "Tank Top"};
        double[] prices = {20.00, 20.00, 25.50, 30.35, 15.75};

        // We know  there is 4 elements, if the shop has added products, should be 100 or dynamic array
        ArrayList<Product> products = new ArrayList<>();
        // Create product from names and prices
        for (int i = 0; i < names.length; i++) {
            products.add(new Product(i, names[i], prices[i]));
        }
        Cart cart = new Cart(10);

        Shop shop = new Shop("T-Shirt Mart", products, cart);
        //Menu menu = new Menu(scanner, shop);
        Menu menu = new Menu(scanner, shop);
        menu.greet();
        menu.executeMenu();
    }
}