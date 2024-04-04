package Week5;

import java.util.Scanner;

public class Battle {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String userName, enemyName;
        int userAttack, userDefense, userHealth, enemyAttack, enemyDefense, enemyHealth;

        System.out.println("User's name:");
        userName = scanner.next();
        System.out.println("User's attack:");
        userAttack = scanner.nextInt();
        System.out.println("User's defense:");
        userDefense = scanner.nextInt();
        System.out.println("User's heatlh:");
        userHealth = scanner.nextInt();

        System.out.println("Enemy's name:");
        enemyName = scanner.next();
        System.out.println("Enemy's attack:");
        enemyAttack = scanner.nextInt();
        System.out.println("Enemy's defense:");
        enemyDefense = scanner.nextInt();
        System.out.println("Enemy's heatlh:");
        enemyHealth = scanner.nextInt();

        System.out.println("[" + userName + "]");
        System.out.printf("Attack: %d\nDefense: %d\nHealth: %d\n\n", userAttack, userDefense, userHealth);
        System.out.println("[" + enemyName + "]");
        System.out.printf("Attack: %d\nDefense: %d\nHealth: %d\n\n", enemyAttack, enemyDefense, enemyHealth);

        Player user = new Player(userName, userAttack, userDefense, userHealth);
        Player enemy = new Player(enemyName, enemyAttack, enemyDefense, enemyHealth);

        while (true) {
            // User's turn
            System.out.print("It's your turn.\nChoose an action:\n1. Attack\n2. Defend\n");
            int userInput = scanner.nextInt();
            if (userInput == 2) {
                user.setHealth(user.getHealth() + 10);
                System.out.println(user.getName() + " defends and restores 10 health points. (" + user.getName() + "'s hp: " + user.getHealth() + ")");
                continue;
            } else if (userInput == 1) {
                user.attack(enemy);
                System.out.println(user.getName() + " attacks " + enemy.getName() + " for " + (user.getAttack() - enemy.getDefense()) + " damage. (" + enemy.getName() + "'s hp: " + enemy.getHealth() + ")");
                if (!enemy.isALive() || !user.isALive()) break;
            }

            // CPU's turn
            System.out.println("It's enemy's turn.");
            enemy.attack(user);
            System.out.println(enemy.getName() + " attacks " + user.getName() + " for " + (enemy.getAttack() - user.getDefense()) + " damage. (" + user.getName() + "'s hp: " + user.getHealth() + ")");
            if (!enemy.isALive() || !user.isALive()) break;
        }

        if (user.isALive()) {
            System.out.println("The player " + user.getName() + " wins!");
        } else {
            System.out.println("The player " + enemy.getName() + " wins!");
        }

    }
}
