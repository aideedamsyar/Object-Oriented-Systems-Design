import java.util.Scanner;
import java.util.Random;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNum = random.nextInt(200) + 1;
        int attempts = 0;
        boolean hasWon = false;


        while (attempts < 7 && !hasWon) {
            System.out.println("Try to guess a number from 1 to 200! You have " + (7 - attempts) + " attempts.");
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNum) {
                hasWon = true;
            } else if (userGuess < randomNum) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
            if (!hasWon) {
                System.out.println("Chances Left: " + (7 - attempts));
            }
        }
        if (hasWon) {
            System.out.println("Congratulations!");
        } else {
            System.out.println("You didn't guess within 7 attempts. The correct answer was " + randomNum + ".");
        }

        scanner.close();
    }
}