import java.util.*;
class Question1 {
    String s;
    int vowel;
    int consonant;
    void count() {
        vowel = 0;
        consonant = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowel++;
            } else if (Character.isLetter(ch)) {
                consonant++;
            }
        }
        System.out.println("Number of vowels: " + vowel);
        System.out.println("Number of consonants: " + consonant);
    }
    public static void main(String[] args) {
        Question1 obj = new Question1();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        obj.s = sc.nextLine();
        obj.count();
    }
}