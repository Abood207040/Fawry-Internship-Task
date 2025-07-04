/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryinternshiptask;

/**
 *
 * @author HP
 */
import java.util.List;

public class ShippingService {
    public static void shipItems(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            System.out.println(" - " + item.getName() + "    " + item.getWeight() * 1000 + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + "kg");
    }
}
