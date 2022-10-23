package com.ata;

import java.util.ArrayList;

public class Shop {

    // Encapsulation, products is private.
    private ArrayList<Product> products;


    // Change constructor parameters (products) to match the field 's type
    public Shop(ArrayList<Product> products) {
        this.products = products;
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
}