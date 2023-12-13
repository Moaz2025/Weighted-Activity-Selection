package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        String inputFile = args[0];
        Activity[] activities = new Activity[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                String[] activityData = bufferedReader.readLine().split(" ");
                int startTime = Integer.parseInt(activityData[0]);
                int finishTime = Integer.parseInt(activityData[1]);
                int weight = Integer.parseInt(activityData[2]);
                activities[i] = new Activity(startTime, finishTime, weight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path filePath = Paths.get(inputFile);
        String fileName = filePath.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');
        String newFile = fileName.substring(0, lastDotIndex);
        String newFileName = newFile + "_20011969.txt";
        Path newFilePath = filePath.getParent().resolve(newFileName);

        try {
            Files.copy(filePath, newFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Output file created successfully at: " + newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to create the new file.");
        }
        String outputFile = newFilePath.toString();
        WeightedActivitySelection weightedActivitySelection = new WeightedActivitySelection();
        String output = "The optimal profit is "
                + weightedActivitySelection.activitySelection(activities);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
