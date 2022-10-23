package com.ata;

public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        // String.format -> ability to build string from template.
        // There are some format specifications
        // %d -> int , %s -> string check the java docs for details
        String format = "ID %d: %s - $%.2f";
        return String.format(format, id, name, price);
    }
}
