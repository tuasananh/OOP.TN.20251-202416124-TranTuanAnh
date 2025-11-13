package com.hust.kstn.models;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc {

    static private int nbCompactDiscs = 0;
    private final int id;
    private final String title;
    private final String category;
    private final double cost;
    private final List<Track> tracks;

    public CompactDisc(String title, String category, double cost, List<Track> tracks) {
        this.id = ++nbCompactDiscs; // Auto-increment ID
        this.title = title;
        this.category = category;
        this.cost = cost;
        // Defensive copy to prevent external modification
        this.tracks = new ArrayList<>(tracks);
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

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    @Override
    public String toString() {
        return "CompactDisc[" + this.id + "]["
                + this.title + "]["
                + this.cost + "]["
                + this.category + "]"
                + "\nTracks: " + this.tracks;
    }

    public int getTotalLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        // Currently remove by reference
        tracks.remove(track);
    }   
}
