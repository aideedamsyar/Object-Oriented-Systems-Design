package Week6.Exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter information for Person 1:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Birth year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth month: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth day: ");
        int day = scanner.nextInt();
        scanner.nextLine();

        Person p1 = new Person(name, year, month, day);

        System.out.println("Enter information for Person 2:");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Birth year: ");
        year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth month: ");
        month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth day: ");
        day = scanner.nextInt();

        Person p2 = new Person(name, year, month, day);

        AgeCalculator.isOlder(p1, p2);


    }
}
