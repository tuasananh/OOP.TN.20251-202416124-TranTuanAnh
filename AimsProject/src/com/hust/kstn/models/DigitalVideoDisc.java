package com.hust.kstn.models;

public class DigitalVideoDisc {

    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    private DigitalVideoDisc() {
        this.id = ++nbDigitalVideoDiscs; // Auto-increment ID
    }

    public DigitalVideoDisc(String title) {
        this();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, double cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this(title, category, cost);
        this.director = director;
        this.length = length;
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

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "DVD" + "[" + this.id + "]"
                + "[" + this.title + "]"
                + "[" + this.cost + "]"
                + "[" + this.director + "]"
                + "[" + this.length + "]"
                + "[" + this.category + "]";
    }
}
