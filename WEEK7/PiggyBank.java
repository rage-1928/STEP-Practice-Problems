
public class PiggyBank {
    int balance;
    final int id;

    public PiggyBank(int id) {
        this.id = id;
        this.balance = 0;
    }
    void addMoney(int amount) {
        balance += amount;
    }
    void withDrawMoney(int amount) {
        if(amount <= balance)
        balance -= amount;
    }
    public static void main(String args[]) {
        PiggyBank p1 = new PiggyBank(1);
        p1.addMoney(100);
        System.out.println("Balance in Piggy Bank 1: " + p1.balance);
        p1.withDrawMoney(50);
        System.out.println("Balance in Piggy Bank 1 after withdrawal: " + p1.balance);
    }
}