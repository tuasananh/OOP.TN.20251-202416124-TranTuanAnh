package com.hust.kstn.test;

import com.hust.kstn.models.CompactDisc;
import com.hust.kstn.models.Track;
import com.hust.kstn.test.MicroUnit.Test;
import static com.hust.kstn.test.Asserts.*;
import java.util.ArrayList;
import java.util.List;

public class CompactDiscTest {

    public static void main(String[] args) {
        MicroUnit.run(CompactDiscTest.class);
    }

    @Test
    public void testCompactDiscCreation() {
        // Create tracks
        Track track1 = new Track("Song One", 180);
        Track track2 = new Track("Song Two", 210);
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", 15.99, tracks);
        
        // Add another track to the original list
        tracks.add(track2);
        
        // The CD's tracks should not be modified (defensive copy)
        assertEquals(2, tracks.size());
        assertEquals(1, cd.getTracks().size());
    }
}
