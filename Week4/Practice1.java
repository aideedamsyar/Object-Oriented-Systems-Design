package Week4;

import java.util.Scanner;

public class Practice1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start;
        int end;
        boolean isPrime;

        do {
            System.out.print("Starting number (1 to 1000): ");
            start = scanner.nextInt();
            if (start < 1 || start > 1000) {
                System.out.println("Starting number must be between 1 and 1000.");
            }
        } while (start < 1 || start > 1000);

        do {
            System.out.print("Ending number (1 to 1000): ");
            end = scanner.nextInt();
            if (end < 1 || end > 1000) {
                System.out.println("Ending number must be between 1 and 1000.");
            }
        } while (end < 1 || end > 1000);

        System.out.println("Prime numbers between " + start + " and " + end + ": ");

        for (int i = start; i <= end; i++) {
            isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i > 1) {
                System.out.print(i + " ");
            }
        }
    }
}