import java.util.*;

class Question2 {
    String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }   

    boolean isPalindrome(String s) {
        String reversed = rev(s);
        return s.equalsIgnoreCase(reversed);
    }
    public static void main(String[] args) {
        Question2 obj = new Question2();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Reversed string: " + obj.rev(input));
        if (obj.isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}