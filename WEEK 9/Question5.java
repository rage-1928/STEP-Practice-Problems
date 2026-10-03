import java.util.*;

abstract class Booking {
    double distance;
    static final double BOOKING_FEE = 50;
    Booking(double distance) {
        this.distance = distance;
    }
    public double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
    public abstract String getMode();
    public abstract double baseFare();
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }
    @Override
    public double baseFare() {
        return 2 * distance;
    }
    @Override
    public String getMode() {
        return "BUS";
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }
    @Override
    public double baseFare() {
        return 1.5 * distance;
    }
    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }
    @Override
    public double baseFare() {
        return 2500 + 4 * distance;
    }
    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            if (mode.equals("BUS")) {
                bookings.add(new Bus(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new Train(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new Flight(distance));
            }
        }
        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.totalFare());
        }
        sc.close();
    }
}