package com.hust.kstn.models;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
    private final List<Track> tracks;

    public CompactDisc(String title, String category, double cost, List<Track> tracks) {
        super(title, cost, category);
        // Defensive copy to prevent external modification
        this.tracks = new ArrayList<>(tracks);
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    @Override
    public String toString() {
        return super.toString() + "\nTracks: " + this.tracks;
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
