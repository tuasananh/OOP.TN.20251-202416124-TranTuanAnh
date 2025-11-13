package com.hust.kstn.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    static private int nbBooks = 0;
    private final int id;
    private final String title;
    private final String category;
    private final double cost;
    private final int numOfTokens;
    private final List<BookAuthor> authors;

    public Book(String title, String category, double cost, int numOfTokens, List<BookAuthor> authors) {
        this.id = ++nbBooks; // Auto-increment ID
        this.title = title;
        this.category = category;
        this.cost = cost;
        // Defensive copy to prevent external modification
        this.authors = new ArrayList<>(authors);
        this.numOfTokens = numOfTokens;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getCost() {
        return cost;
    }

    public int getNumOfTokens() {
        return numOfTokens;
    }

    public List<BookAuthor> getAuthors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String toString() {
        return "Book[" + this.id + "]["
                + this.title + "]["
                + this.cost + "]["
                + this.category + "]["
                + this.numOfTokens + "]"
                + "\nAuthors: " + this.authors;
    }
}
