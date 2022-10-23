package com.ata;

import java.util.ArrayList;

public class Shop {

    // Encapsulation, products is private.
    private ArrayList<Product> products;
    private String name;
    private Cart cart;

    public Shop() {
    }

    // Change constructor parameters (products) to match the field 's type
    public Shop(String name, ArrayList<Product> products, Cart cart) {
        this.name = name;
        this.products = products;
        this.cart = cart;
    };

    // Update print product to print the price.
    public void printProducts() {
        System.out.println("--Products--");
        for (Product product: products) {
            // print...the product?, what the magic here...
            // System.out.println will implicit call product.toString()
            System.out.println(product);
        }
    }

    public int findProduct(String searchText) {
        for (int i = 0; i < products.size(); i++) {
            if (searchText.equals(products.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void addToCart(int id) {
        if (id < 0 || id >= products.size()) {
            System.out.println("That item ID is invalid and could not be added to the cart.");
            return;
        }
        cart.addItem(products.get(id));
        System.out.println(products.get(id).getName() + " has been added to your cart.");
    }

    public String getName() {
        return name;
    }

    public void showCartDetails() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
        } else {
            cart.showDetails();
        }
    }

    public void checkoutCart() {
        cart.checkout();
        System.out.printf("Your total is $%.2f.%n", cart.totalAfterTax());
        System.out.printf("Thank you for shopping at %s%n.", getName()); // %n = newline
    }
}