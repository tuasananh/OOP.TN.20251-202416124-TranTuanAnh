package com.hust.kstn.models;

public class Media {
    private final int id;
    private final String title;
    private final double cost;
    private final String category;
    private static int nextMediaId = 1;

    public Media(String title, double cost, String category) {
        this.id = nextMediaId++;
        this.title = title;
        this.cost = cost;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Media" + "[" + this.id + "]"
                + "[" + this.title + "]"
                + "[" + this.cost + "]"
                + "[" + this.category + "]";
    }
}
