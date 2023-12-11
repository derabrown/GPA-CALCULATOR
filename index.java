/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gpacalculator;
 import java.text.DecimalFormat;
 import java.util.Scanner;

/**
 *
 * @author USER
 */
public class GpaCalculator {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect user's name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        String[] courseCodes = new String[numCourses];
        int[] courseUnits = new int[numCourses];
        char[] grades = new char[numCourses];
        int[] gradeUnits = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nEnter details for Course " + (i + 1) + ":");

            System.out.print("Enter the course code: ");
            courseCodes[i] = scanner.next();

            System.out.print("Enter the course unit: ");
            courseUnits[i] = scanner.nextInt();

            System.out.print("Enter the score (0-100): ");
            int score = scanner.nextInt();

            grades[i] = getGrade(score);
            gradeUnits[i] = (int) getGradePoint(grades[i]);
        }
        System.out.println();
        // Print the table header
        System.out.println("The table below show the breakdown of the grade and GPA of " + userName);
        System.out.println("\n-----------------------------------------------------");
        System.out.printf("| %-15s | %-12s | %-6s | %-10s |\n", "Course & Code", "Course Unit", "Grade", "Grade Unit");
        System.out.println("-----------------------------------------------------");

        // Print the table rows
        for (int i = 0; i < numCourses; i++) {
            // Modify the format specifier for gradeUnits to display as integer
            System.out.printf("| %-15s | %-12d | %-6c | %-10d |\n", courseCodes[i], courseUnits[i], grades[i], gradeUnits[i]);
        }

    // Print the table footer
        System.out.println("-----------------------------------------------------");

        double totalQualityPoints = 0;
        double totalGradeUnits = 0;

        // To calculate total grade points and total grade units
        for (int i = 0; i < numCourses; i++) {
            totalQualityPoints += getGradePoint(grades[i]) * courseUnits[i];
            totalGradeUnits += courseUnits[i];
        }

        double gpa = totalQualityPoints / totalGradeUnits;

        // Formating GPA to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedGPA = df.format(gpa);

        System.out.println("\nYour GPA is: " + formattedGPA);

        scanner.close();
    }

    public static char getGrade(int score) {
        if (score >= 70 && score <= 100) {
            System.out.println("Remark: Excellent");
            return 'A';
        } else if (score >= 60 && score <= 69) {
            System.out.println("Remark: Very good");
            return 'B';
        } else if (score >= 50 && score <= 59) {
            System.out.println("Remark: Good");
            return 'C';
        } else if (score >= 45 && score <= 49) {
            System.out.println("Remark: Fair");
            return 'D';
        } else if (score >= 40 && score <= 44) {
            System.out.println("Remark: Pass");
            return 'E';
        } else if (score >= 0 && score <= 39) {
            System.out.println("Remark: Fail");
            return 'F';
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
            return 'X'; // Use 'X' to represent an invalid grade
        }
    }

    public static double getGradePoint(char grade) {
        switch (grade) {
            case 'A':
                return 5;
            case 'B':
                return 4;
            case 'C':
                return 3;
            case 'D':
                return 2;
            case 'E':
                return 1;
            case 'F':
                return 0;
            default:
                return -1; // Return invalid grade
        }
    }
}