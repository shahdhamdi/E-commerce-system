package com.ecom;

import java.util.ArrayList;

public class Cart {
    public ArrayList<Product> items = new ArrayList<>();
    public ArrayList<Integer> quantities = new ArrayList<>();

    public void add(Product p, int qty){
        if(qty > p.quantity){
            System.out.println("Not enough " + p.name);
        } else {
            items.add(p);
            quantities.add(qty);
        }
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }
}
