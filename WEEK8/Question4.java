import java.util.*;

interface Question {
    double evaluate();
    String getType();
}

class MCQ implements Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    MCQ(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    @Override 
    public double evaluate() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
    @Override 
    public String getType() {
        return "MCQ";
    }
}

class TF implements Question {
    String correctAnswer;
    String studentAnswer;
    double points;
    TF(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    @Override 
    public double evaluate() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
    @Override 
    public String getType() {
        return "TF";
    }
}

class Essay implements Question {
    String correctAnswer;
    String studentAnswer;
    double points;
    Essay(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    @Override 
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;
        String answer = studentAnswer.toLowerCase();
        for (String keyword : keywords) {
            keyword = keyword.trim().toLowerCase();
            if (answer.contains(keyword)) {
                count++;
            }
        }
        if (count >= 2) {
            return points * 0.75;
        } 
        else if (count == 1) {
            return points * 0.50;
        } 
        else {
            return 0;
        }
    }
    @Override 
    public String getType() {
        return "ESSAY";
    }
}

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim().split("\\s+")[0];
            Question question;
            if (type.equals("MCQ")) {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                double points = Double.parseDouble(parts[6].trim());
                question = new MCQ(correctAnswer, studentAnswer, points);
            } 
            else if (type.equals("TF")) {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                double points = Double.parseDouble(parts[6].trim());
                question = new TF(
                        correctAnswer,
                        studentAnswer,
                        points
                );
            } 
            else {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                double points = Double.parseDouble(parts[6].trim());
                question = new Essay(correctAnswer, studentAnswer, points);
            }
            double score = question.evaluate();
            System.out.printf("%s: %.2f%n", question.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}