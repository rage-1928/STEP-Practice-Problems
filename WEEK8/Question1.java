import java.util.*;
interface Payment {
    public double totalAmount(double amount);
}
class CardPayment implements Payment {
    @Override
    public double totalAmount(double amount) {
        return amount + amount * 0.02;
    }
}
class WalletPayment implements Payment {
    @Override
    public double totalAmount(double amount) {
        return amount + amount * 0.01;
    }
}
class BankTransfer implements  Payment {
    @Override
    public double totalAmount(double amount) {
        return amount;
    }
}
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardPayment card = new CardPayment();
        WalletPayment wallet = new WalletPayment();
        BankTransfer bank = new BankTransfer();
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0.0;
        while (n > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            if (type.equalsIgnoreCase("CARD")) {
                double result = card.totalAmount(amount);
                System.out.printf("CARD: %.2f%n", result);
                total += result;
            }
            else if (type.equalsIgnoreCase("WALLET")) {
                double result = wallet.totalAmount(amount);
                System.out.printf("WALLET: %.2f%n", result);
                total += result;
            }
            else if (type.equalsIgnoreCase("BANKTRANSFER")) {
                double result = bank.totalAmount(amount);
                System.out.printf("BANKTRANSFER: %.2f%n", result);
                total += result;
            }
            n--;
        }
        System.out.printf("Total: %.2f", total);
    }
}