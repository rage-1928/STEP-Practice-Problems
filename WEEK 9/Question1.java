import java.util.*;

abstract class Plot {
    String owner;
    String shape;
    Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }
    String getOwner() {
        return owner;
    }
    String getShape() {
        return shape;
    }
    public abstract double area();
}

class Circle extends Plot {
    double radius;
    Circle(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length;
    double width;
    Rectangle(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }
    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base;
    double height;
    Triangle(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            String shape = arr[0];
            String owner = arr[1];
            if (shape.equals("CIRCLE")) {
                double radius = Double.parseDouble(arr[2]);
                plots.add(new Circle(owner, radius));
            } else if (shape.equals("RECTANGLE")) {
                double length = Double.parseDouble(arr[2]);
                double width = Double.parseDouble(arr[3]);
                plots.add(new Rectangle(owner, length, width));
            } else if (shape.equals("TRIANGLE")) {
                double base = Double.parseDouble(arr[2]);
                double height = Double.parseDouble(arr[3]);
                plots.add(new Triangle(owner, base, height));
            }
        }
        double total = 0;
        for (Plot p : plots) {
            double amount = p.area();
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), amount);
            total += amount;
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}