/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryinternshiptask;

/**
 *
 * @author HP
 */
import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.isExpired()) {
                System.out.println("Error: Product " + product.getName() + " is expired.");
                return;
            }

            if (quantity > product.getQuantity()) {
                System.out.println("Error: Not enough quantity for " + product.getName());
                return;
            }

            subtotal += product.getPrice() * quantity;

            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add((Shippable) product);
                }
            }
        }

        double shipping = itemsToShip.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.pay(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + "    " + entry.getKey().getPrice() * entry.getValue());
            entry.getKey().reduceQuantity(entry.getValue());
        }
        System.out.println("----------------------------");
        System.out.println("Subtotal      " + subtotal);
        System.out.println("Shipping      " + shipping);
        System.out.println("Amount Paid   " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());
        cart.clear();
    }
}