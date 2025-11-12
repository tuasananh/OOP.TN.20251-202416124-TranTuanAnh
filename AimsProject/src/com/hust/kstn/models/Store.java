package com.hust.kstn.models;

public class Store {
    private static final int TEMPORARY_MAX_CAPACITY = 100;

    private final DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[TEMPORARY_MAX_CAPACITY];
    private int numberOfItems = 0;

    /**
     * Add a DVD to the store
     * @param dvd The DVD to be added
     * 
     * This function should not fail
     */
    public void addDVD(DigitalVideoDisc dvd) {
        // This is a temporary guard, may be deleted later
        // as store should be able to hold infinite number of items
        if (numberOfItems >= TEMPORARY_MAX_CAPACITY) {
            throw new IllegalStateException("Store is full. Cannot add more DVDs.");
        }
        itemsInStore[numberOfItems++] = dvd;
    }

    /**
     * Remove all DVDs from the store with the same reference as the given disc
     * @param disc The disc to be removed
     * @return The number of discs removed
     */
    public int removeDVD(DigitalVideoDisc disc) {
        int amountRemoved = 0;
        int j = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if (disc != itemsInStore[i]) {
                itemsInStore[j++] = itemsInStore[i];
            } else {
                amountRemoved++;
                // we just go next
            }
        }
        numberOfItems -= amountRemoved;
        return amountRemoved;
    }

}
