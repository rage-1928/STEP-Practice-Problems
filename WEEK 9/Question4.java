import java.util.*;

abstract class Connection {
    String type;
    int units;
    Connection(String type, int units) {
        this.type = type;
        this.units = units;
    }
    String getType() {
        return type;
    }
    public abstract double bill();
}

class Home extends Connection {
    Home(String type, int units) {
        super(type, units);
    }
    @Override
    public double bill() {
        if (units <= 100) {
            return 5 * units;
        } else {
            return 5 * 100 + 7 * (units - 100);
        }
    }
}

class Shop extends Connection {
    Shop(String type, int units) {
        super(type, units);
    }
    @Override
    public double bill() {
        return 8 * units + 100;
    }
}

class Factory extends Connection {
    Factory(String type, int units) {
        super(type, units);
    }
    @Override
    public double bill() {
        return Math.max(6 * units, 1000);
    }
}

class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("HOME")) {
                connections.add(new Home(type, units));
            } else if (type.equals("SHOP")) {
                connections.add(new Shop(type, units));
            } else if (type.equals("FACTORY")) {
                connections.add(new Factory(type, units));
            }
        }
        double total = 0;
        for (Connection c : connections) {
            double amount = c.bill();
            System.out.printf("%s: %.2f%n", c.getType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}