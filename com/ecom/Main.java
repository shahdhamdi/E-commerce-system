package com.ecom;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, true, 200);
        Product biscuits = new Product("Biscuits", 150, 3, true, true, 700);

        User customer = new User(1000);

        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        checkout(cart, customer);
    }

    public static void checkout(Cart cart, User customer){
        if(cart.isEmpty()){
            System.out.println("cart empty");
            return;
        }

        double subtotal = 0;
        int totalWeight = 0;

        System.out.println("** Shipment notice **");

        for(int i=0;i<cart.items.size();i++){
            Product p = cart.items.get(i);
            int q = cart.quantities.get(i);

            if(p.isShippable){
                System.out.println(q+"x "+p.name+" "+(p.weight*q)+"g");
                totalWeight = totalWeight + (p.weight*q);
            }

            subtotal = subtotal + (p.price * q);
        }

        System.out.println("Total package weight "+(totalWeight/1000.0)+"kg");

        System.out.println("** Checkout receipt **");

        for(int i=0;i<cart.items.size();i++){
            Product p = cart.items.get(i);
            int q = cart.quantities.get(i);
            System.out.println(q+"x "+p.name+" "+(p.price*q));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal "+subtotal);

        int shipping = 30;
        double total = subtotal + shipping;

        System.out.println("Shipping "+shipping);
        System.out.println("Amount "+total);

        if(customer.balance < total){
            System.out.println("Not enough balance");
            return;
        }

        customer.balance = customer.balance - total;
        System.out.println("Customer balance after payment: "+customer.balance);
    }
}
