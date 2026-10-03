import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public abstract double pay();
}

class Fulltime extends Staff {
    double salary;

    Fulltime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours;
    double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double pay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double pay() {
        return stipend;
    }
}

class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Staff> staffList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            String type = arr[0];
            String name = arr[1];
            if (type.equals("FULLTIME")) {
                double salary = Double.parseDouble(arr[2]);
                staffList.add(new Fulltime(name, salary));
            } else if (type.equals("HOURLY")) {
                double hours = Double.parseDouble(arr[2]);
                double rate = Double.parseDouble(arr[3]);
                staffList.add(new Hourly(name, hours, rate));
            } else if (type.equals("INTERN")) {
                double stipend = Double.parseDouble(arr[2]);
                staffList.add(new Intern(name, stipend));
            }
        }
        double total = 0;
        for (Staff s : staffList) {
            double amount = s.pay();
            System.out.printf("%s: %.2f%n", s.getName(), amount);
            total += amount;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}