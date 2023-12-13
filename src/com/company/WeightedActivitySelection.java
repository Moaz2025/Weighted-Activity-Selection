package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedActivitySelection {

    public int activitySelection(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finishTime));
        int n = activities.length;
        int[] table = new int[n];
        table[0] = activities[0].weight;
        for (int i = 1; i < n; i++) {
            int latestNonConflicting = findLatestNonConflicting(activities, i);
            table[i] = Math.max(activities[i].weight + (latestNonConflicting != -1 ? table[latestNonConflicting] : 0),
                    table[i - 1]);
        }
        return table[n - 1];
    }

    public int findLatestNonConflicting(Activity[] activities, int currentIndex) {
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (activities[i].finishTime <= activities[currentIndex].startTime) {
                return i;
            }
        }
        return -1;
    }
}