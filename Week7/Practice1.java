package Week7;

import java.util.Scanner;

public class Practice1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a matrix size n: ");
        int n = scanner.nextInt();

        System.out.println("Snail Array:");
        int[][] result = new int[n][n];
        result = drawSnail(n);

        // print matrix
        for (int[] row: result) {
            for (int element: row) {
                System.out.printf("%-2d ", element);
            }
            System.out.println();
        }
    }

    public static int[][] drawSnail(int n) {
        int[][] matrix = new int[n][n];
        int row = 0;
        int col = -1; // index starts with 0; (col + magnitude =  -1 + 1 = 0) implies the index 0 of the col
        int max = n; // will decrease
        int magnitute = 1; // will be switched to -1 depending on the direction
        int num = 0;

        for (int k = 0; k < n; k++) {
            // col changes
            for (int i = 0; i < max; i++) {
                col = col + magnitute;
                matrix[row][col] = ++num;
            }

            max--; // max decreases by one in between the row-col pair

            // row changes
            for (int j = 0; j < max; j++) {
                row = row + magnitute;
                matrix[row][col] = ++num;
            }

            // magnitude sign changes
            magnitute = magnitute * -1;
        }

        return matrix;
    }

}
