package com.hust.kstn.models;

public class Cart {

    private static final int MAX_NUMBER_ORDERED = 20;

    private final DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBER_ORDERED];

    private int quantity;

    /**
     * Add a DVD to the cart
     * @param disc The disc to be added
     * @return 1 if the disc was added successfully, 0 otherwise
     */
    public int addDVD(DigitalVideoDisc disc) {
        if (quantity + 1 > MAX_NUMBER_ORDERED) {
            return 0; 
        }
        itemsInCart[quantity++] = disc;
        return 1;
    }

    /**
     * Add two DVDs to the cart
     * @param disc1 The first disc to be added
     * @param disc2 The second disc to be added
     * @return 2 if both discs were added successfully, 0 otherwise
     */
    public int addDVD(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if (quantity + 2 > MAX_NUMBER_ORDERED) {
            return 0;
        }
        itemsInCart[quantity++] = disc1;
        itemsInCart[quantity++] = disc2;
        return 2;
    }

    /**
     * Add multiple DVDs to the cart
     * @param discs The discs to be added
     * @return The number of discs added successfully
     */
    public int addDVD(DigitalVideoDisc... discs) {
        if (discs == null) {
            return 0;
        }
        if (discs.length == 0) {
            return 0;
        }
        if (discs.length == 1) {
            return addDVD(discs[0]);
        }

        if (quantity + discs.length > MAX_NUMBER_ORDERED) {
            return 0;
        }

        for (DigitalVideoDisc disc : discs) {
            itemsInCart[quantity++] = disc;
        }

        return discs.length;
    }

    /**
     * Remove all DVDs from the cart with the same reference as the given disc
     * @param disc The disc to be removed
     * @return The number of discs removed
     */
    public int removeDVD(DigitalVideoDisc disc) {
        int amountRemoved = 0;
        int j = 0;
        for (int i = 0; i < quantity; i++) {
            if (disc != itemsInCart[i]) {
                itemsInCart[j++] = itemsInCart[i];
            } else {
                amountRemoved++;
                // we just go next
            }
        }

        quantity -= amountRemoved;
        return amountRemoved;
    }

    /**
     * Calculate the total cost of the items in the cart
     * @return The total cost
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (int i = 0; i < quantity; i++) {
            totalCost += itemsInCart[i].getCost();
        }
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void print() {
        if (quantity == 0) {
            System.out.println("The cart is empty");
            return;
        }
        System.out.println("======================= THE CURRENT CART =======================");
        System.out.println("Total items: " + this.quantity);
        for (int i = 0; i < quantity; i++) {
            System.out.println("- " + itemsInCart[i]);
        }
        System.out.println("Subtotal: " + this.getTotalCost() + "$");
        System.out.println("================================================================"); 
    }
}
