import java.util.*;
class Question8 {
    void printGrade(int mark) {
        if (mark >= 90) {
            System.out.println("Grade A");
        } else if (mark >= 80) {
            System.out.println("Grade B");
        } else if (mark >= 70) {
            System.out.println("Grade C");
        } else if (mark >= 60) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int mark = sc.nextInt();
        Question8 q = new Question8();
        q.printGrade(mark);
    }
}