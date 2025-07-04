package com.ecom;

public class Product {
    public String name;
    public double price;
    public int quantity;
    public boolean isExpirable;
    public boolean isShippable;
    public int weight; 
    
    public Product(String name, double price, int quantity, boolean isExpirable, boolean isShippable, int weight){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isShippable = isShippable;
        this.weight = weight;
    }
}
