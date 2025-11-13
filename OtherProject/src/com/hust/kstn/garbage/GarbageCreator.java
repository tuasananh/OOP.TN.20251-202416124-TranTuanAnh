package com.hust.kstn.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String[] args) {
        String filename = "GarbageData.txt";
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();
            long lastCheckTime = startTime;
            String outputString = "";
            for (byte b : fileBytes) {
                outputString += b;
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastCheckTime >= 10000) {
                    System.out.println("Current output length: " + outputString.length());
                    lastCheckTime = currentTime;
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Output length: " + outputString.length());
            System.out.println("Time taken to read file: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
