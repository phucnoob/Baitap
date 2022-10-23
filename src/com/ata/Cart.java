package com.ata;


import java.util.ArrayList;

/**
 * You will see i haven't done any error checking in this class (e.g product is null, taxRate > 100)
 * Because that's the shop class job (or any upper layer dealing with user input)
 */
public class Cart {
    private ArrayList<Product> items;
    private double total;
    private double taxRate;

    public Cart(double taxRate) {
        this.items = new ArrayList<>();
        this.taxRate = taxRate;
    }

    public void addItem(Product product) {
        items.add(product);
        updateTotal();
    }

    public double getTaxRate() {
        return taxRate;
    }

    private void updateTotal() {
        total = 0;
        for (Product product: items) {
            total += product.getPrice();
        }
    }

    public double totalBeforeTax() {
        return total;
    }


    public double totalAfterTax() {
        return totalBeforeTax() * ( 1 + taxRate / 100.0);
    }


    public void showDetails() {
        System.out.println("--Cart--");
        System.out.println("Item Count: 1");
        System.out.println("Item:");
        for (Product product: items) {
            System.out.printf("%s: $%.2f%n", product.getName(), product.getPrice());
        }
        System.out.println();
        System.out.printf("Pre-Tax Total: $%.2f%n", totalBeforeTax());
        System.out.printf("Post-Tax Total (%.2f%% Tax): $%.2f%n", getTaxRate(), totalAfterTax());
        // so why need totalBeforeTax() and totalAfterTax()?
        // Ans: decouple the tax calculation from display.
    }

    public boolean checkout() {
        empty();
        return false;
    }

    private void empty() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
