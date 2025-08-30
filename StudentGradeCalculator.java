import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter the number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int totalMarks = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            // Validation (ensure within 0-100)
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // retry same subject
                continue;
            }
            totalMarks += marks[i];
        }

        // Step 2: Calculate total and average
        double averagePercentage = (double) totalMarks / n;

        // Step 3: Grade calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Step 4: Display results
        System.out.println("\n===== RESULTS =====");
        System.out.println("Total Marks = " + totalMarks + " out of " + (n * 100));
        System.out.println("Average Percentage = " + averagePercentage + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
