package com.hust.kstn.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

    public static void main(String[] args) {
        String filename = "GarbageData.txt";
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();
            StringBuilder outputStringBuffer = new StringBuilder();
            for (byte b : fileBytes) {
                outputStringBuffer.append(b);
            }
            String outputString = outputStringBuffer.toString();
            long endTime = System.currentTimeMillis();
            System.out.println("Output length: " + outputString.length());
            System.out.println("Time taken to read file: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
