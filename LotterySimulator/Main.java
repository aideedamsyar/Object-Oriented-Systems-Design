package LotterySimulator;

import java.util.Scanner;

public class Main {
    private static final int TICKET_PRICE = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int currentFund = getUserFund();
        if (currentFund == 0) {
            System.out.println(">> End of program");
            return;
        }
        LotteryGenerator lotteryGenerator = new LotteryGenerator();
        while (true) {
            int ticketAmount = getTicketAmount(currentFund);
            if (ticketAmount == 0) {
                System.out.print(">> End of program");
                return;
            }

            int[] winningNumbers = lotteryGenerator.genRandomUnique(7);
            printWinningNumbers(winningNumbers);

            int[] scoreBoard = new int[4];
            int totalPrize = processTickets(ticketAmount, currentFund, lotteryGenerator, winningNumbers, scoreBoard);
            currentFund -= ticketAmount * TICKET_PRICE;
            currentFund += totalPrize;

            printResults(scoreBoard, totalPrize, currentFund);
        }
    }

    private static int getUserFund() {
        int fund;
        do {
            System.out.println("Enter your money:");
            fund = scanner.nextInt();
            if (fund < TICKET_PRICE) {
                System.out.println(">> You don't have enough money to buy a ticket.");
                System.out.print(">> End of program");
                System.exit(0);
            }
        } while (fund < TICKET_PRICE);
        return fund;
    }

    private static int getTicketAmount(int currentFund) {
        int ticketAmount;
        while (true) {
            if (currentFund < TICKET_PRICE) {
                System.out.println(">> You don't have enough money to buy a ticket.");
                System.out.print(">> End of program");
                System.exit(0);
            }
            System.out.println(">> Enter the number of tickets to buy (0 to exit):");
            ticketAmount = scanner.nextInt();

            if (ticketAmount == 0) {
                System.out.print(">> End of program");
                System.exit(0); // Exit the program if user chooses to not buy any tickets.
            } else if (ticketAmount * TICKET_PRICE > currentFund) {
                System.out.println(">> You don't have enough money for that many tickets.");
            } else {
                break; // Exit the loop if a valid number of tickets is entered.
            }
        }
        return ticketAmount;
    }


    private static void printWinningNumbers(int[] winningNumbers) {
        System.out.print(">> Round Winning numbers: ");
        for (int i = 0; i < winningNumbers.length; i++) {
            System.out.print((i != 6 ? winningNumbers[i] + " " : "+ " + winningNumbers[i]));
        }
        System.out.println();
    }

    private static int processTickets(int ticketAmount, int currentFund, LotteryGenerator lg, int[] winningNumbers, int[] scoreBoard) {
        int totalPrize = 0;
        for (int i = 0; i < ticketAmount; i++) {
            int[] currentNumbers = lg.genRandomUnique(6);
            LotteryChecker lc = new LotteryChecker(winningNumbers, currentNumbers);
            int currentRank = lc.getRank();
            int currentPrize = lc.getPrize(currentRank);
            totalPrize += currentPrize;
            if (currentRank != -1) {
                scoreBoard[currentRank - 1]++;
            }

            printTicketResult(currentNumbers, currentRank);
        }
        return totalPrize;
    }

    private static void printTicketResult(int[] currentNumbers, int rank) {
        System.out.print(">> Lottery Winning numbers: ");
        for (int number : currentNumbers) {
            System.out.print(number + " ");
        }
        System.out.println(rank == -1 ? "Lose" : "Winner (" + rank + "th place)");
    }

    private static void printResults(int[] scoreBoard, int totalPrize, int currentFund) {
        for (int i = 0; i < scoreBoard.length; i++) {
            System.out.println(">> The number of " + (i + 1) + "st place: " + scoreBoard[i]);
        }
        System.out.println(">> Total winnings: " + totalPrize);
        System.out.println(">> Current funds: " + currentFund);
    }
}
