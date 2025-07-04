/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fawryinternshiptask;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class main {

      public static void main(String[] args) {
        Product cheese = new ExpirableProduct("Cheese", 100, 10, LocalDate.of(2025, 12, 30), 0.2);
        Product biscuits = new ExpirableProduct("Biscuits", 150, 5, LocalDate.of(2025, 11, 15), 0.7);
        Product tv = new NonExpirableProduct("TV", 5000, 2, 10.0);
        Product scratchCard = new DigitalProduct("Scratch Card", 50, 100);

        Customer customer = new Customer("Ahmed", 10000);
        Cart cart = new Cart();
 
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
