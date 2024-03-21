package Week3;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name of item 1:");
        String item1 = scanner.nextLine();

        System.out.println("Enter quantity of item 1:");
        int item1_quantity = scanner.nextInt();

        System.out.println("Enter price of item 1:");
        float item1_price = scanner.nextFloat();
        String dummy = scanner.nextLine();

        System.out.println("Enter name of item 2:");
        String item2 = scanner.nextLine();

        System.out.println("Enter quantity of item 2:");
        int item2_quantity = scanner.nextInt();

        System.out.println("Enter price of item 2:");
        float item2_price = scanner.nextFloat();
        dummy = scanner.nextLine();

        System.out.println("Enter name of item 3:");
        String item3 = scanner.nextLine();

        System.out.println("Enter quantity of item 3:");
        int item3_quantity = scanner.nextInt();

        System.out.println("Enter price of item 3:");
        float item3_price = scanner.nextFloat();

        // Labels
        String iteml = "ITEM";
        String quantityl = "QUANTITY";
        String pricel = "PRICE";
        String totall = "TOTAL";
        String subtotall = "SUBTOTAL";
        String taxl= "6.25% SALES TAX";

        System.out.println("Your bill:\n");
        float total1 = (float)item1_quantity*item1_price;
        float total2 = (float)item2_quantity*item2_price;
        float total3 = (float)item3_quantity*item3_price;

        float total = total1 + total2 + total3;

        System.out.printf("%-30s%-10s%-10s%-10s\n", iteml, quantityl, pricel, totall);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item1, item1_quantity, item1_price, total1);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item2, item2_quantity, item2_price, total2);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item3, item3_quantity, item3_price, total3);

        System.out.println();
        System.out.printf("%-50s%.2f\n", subtotall, total);
        System.out.printf("%-50s%.2f\n", taxl, 0.0625*total);
        System.out.printf("%-50s%.2f", totall, total + 0.0625*total);
    }
}
