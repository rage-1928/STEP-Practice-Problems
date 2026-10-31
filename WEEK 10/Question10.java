import java.util.*;
class Question10 {
    char getGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    double getAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
        }
        Question10 q = new Question10();
        System.out.println(name.toUpperCase() + " Average " + q.getAverage(marks) + " Grade " + q.getGrade((int) q.getAverage(marks)));
    }
}