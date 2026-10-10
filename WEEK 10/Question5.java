import java.util.*;
class Question5 {
    int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Question5 obj = new Question5();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        System.out.println("Sum of digits: " + obj.sumOfDigits(input));
        System.out.println("Reversed number: " + obj.reverseNumber(input));
    }
}