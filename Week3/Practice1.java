package Week3;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients (a, b, c):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double x1 = ((-b) + (Math.sqrt((Math.pow(b , 2) - (4*a*c))))) / (2*a);
        double x2 = ((-b) - (Math.sqrt((Math.pow(b , 2) - (4*a*c))))) / (2*a);

        System.out.printf("x1: %.3f x2: %.3f", x1, x2);
    }
}
