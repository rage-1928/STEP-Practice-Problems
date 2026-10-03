import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    String getTitle() {
        return title;
    }
    public abstract double fine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }
    @Override
    public double fine() {
        return 2 * daysLate;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double fine() {
        return Math.min(5 * daysLate, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }
    @Override
    public double fine() {
        return daysLate;
    }
}

class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            String type = arr[0];
            String title = arr[1];
            int daysLate = Integer.parseInt(arr[2]);

            if(type.equals("BOOK")) {
                items.add(new Book(title, daysLate));
            } else if (type.equals("DVD")) {
                items.add(new DVD(title, daysLate));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title, daysLate));
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            double amount = item.fine();
            System.out.printf("%s: %.2f%n", item.getTitle(), amount);
            total += amount;
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}