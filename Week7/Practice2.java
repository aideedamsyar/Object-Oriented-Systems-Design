package Week7;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        ArrayStack as = new ArrayStack(5);

        while (true) {
            System.out.println("Choose operation: ");
            System.out.print("1. Push\n2. Pop\n3. Peek\n4. Display Stack\n5. Exit\n");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1: // Push
                    System.out.print("Enter element to push: ");
                    x = scanner.nextInt();
                    as.push(x);
                    System.out.println("Element pushed: " + x);
                    System.out.println();
                    break;
                case 2: // Pop
                    System.out.println("Popped element: " + as.pop());
                    System.out.println();
                    break;
                case 3: // Peek
                    System.out.println("Peeked element: " + as.peek());
                    System.out.println();
                    break;
                case 4: // Display Stack
                    as.display();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
