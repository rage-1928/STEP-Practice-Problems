import java.time.*;
import java.time.format.*;
import java.util.*;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    String title;
    LocalDate currentDate;

    Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }
    @Override 
    public LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
    @Override 
    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    String title;
    LocalDate currentDate;

    DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }
    @Override 
    public LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
    @Override 
    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    String title;
    LocalDate currentDate;

    Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }
    @Override 
    public LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
    @Override 
    public String getTitle() {
        return title;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type;
            String title;
            if (line.startsWith("BOOK ")) {
                type = "BOOK";
                title = line.substring(5).replace("\"", "");
            } 
            else if (line.startsWith("DVD ")) {
                type = "DVD";
                title = line.substring(4).replace("\"", "");
            } 
            else {
                type = "MAGAZINE";
                title = line.substring(9).replace("\"", "");
            }
            LibraryItem item;
            item = switch (type) {
                case "BOOK" -> new Book(title, currentDate);
                case "DVD" -> new DVD(title, currentDate);
                default -> new Magazine(title, currentDate);
            };
            System.out.println(
                    item.getTitle() + ": " +
                    item.getDueDate().format(formatter)
            );
        }
        sc.close();
    }
}