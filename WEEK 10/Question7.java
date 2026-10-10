import java.util.*;
class Question7 {
    int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Question7 obj = new Question7();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        System.out.println("Factorial of " + input + " is: " + obj.fact(input));
    }
}