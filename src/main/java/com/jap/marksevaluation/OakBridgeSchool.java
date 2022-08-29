package com.jap.marksevaluation;

import java.util.Arrays;

public class OakBridgeSchool {

    public static void main(String[] args) {

        // Initialize the OakBridgeSchool class object
        OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();
        int[] math = {88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        int[] science = {80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        int[] english = {90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        int len = math.length;
        // Call the appropriate methods and display the output
        int[] totalMark = oakBridgeSchool.calculateTotalMarks(math, science, english);
        System.out.println(Arrays.toString(totalMark));
        int topScore = oakBridgeSchool.findTopScore(totalMark, len);
        System.out.println("Top Score = " + topScore);
        System.out.println("Average Math Marks    = " + oakBridgeSchool.calculateAverageMathMarks(math, len));
        System.out.println("Average Science Marks = " + oakBridgeSchool.calculateAverageScienceMarks(science, len));
        System.out.println("Average English Marks = " + oakBridgeSchool.calculateAverageEnglishMarks(english, len));
    }

    public int[] calculateTotalMarks(int[] math, int[] science, int[] english) {
        if (math.length == 0 || science.length == 0 || english.length == 0) {
            return null;
        }
        int[] totalMarks = new int[math.length];
        for (int i = 0; i < math.length; i++) {
            totalMarks[i] = math[i] + science[i] + english[i];
        }
        return totalMarks;
    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageScienceMarks(int[] science, int len) {
        if (len == 1) return science[len - 1];

        double avgTillLast = calculateAverageEnglishMarks(science, len - 1);
        double total = (avgTillLast * (len - 1)) + science[len - 1];
        // Returning the average of the marks.
        return total / len;
    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageEnglishMarks(int[] english, int len) {
        if (len == 1) return english[len - 1];

        double avgTillLast = calculateAverageEnglishMarks(english, len - 1);
        double total = (avgTillLast * (len - 1)) + english[len - 1];
        // Returning the average of the marks.
        return total / len;

    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageMathMarks(int[] math, int len) {
        if (len == 1) return math[len - 1];

        double avgTillLast = calculateAverageMathMarks(math, len - 1);
        // Returning the average of the marks.
        double total = (avgTillLast * (len - 1)) + math[len - 1];
        return total / len;
    }

    //Write the logic to find the top score in the class using recursion
    public int findTopScore(int[] totalMarks, int len) {
        if (len == 1)
            return totalMarks[len - 1];


        if (findTopScore(totalMarks, len - 1) > totalMarks[len - 1])
            return findTopScore(totalMarks, len - 1);

        else {
            return totalMarks[len - 1];
        }
    }
}