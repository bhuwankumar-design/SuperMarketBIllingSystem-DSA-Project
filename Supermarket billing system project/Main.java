import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] items = {
            "Rice", "Wheat", "Sugar", "Milk", "Oil",
            "Soap", "Tea", "Salt"
        };

        int[] price = {50, 40, 45, 30, 120, 35, 80, 20};

        int[] quantity = new int[8];

        int choice;
        int total = 0;

        System.out.println("================================");
        System.out.println("     SUPERMARKET BILLING SYSTEM");
        System.out.println("================================");

        do {
            System.out.println("\n--------- PRODUCT MENU ---------");

            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i]
                        + " - Rs." + price[i]);
            }

            System.out.println("0. Generate Bill");

            System.out.print("\nEnter product number: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 8) {

                System.out.print("Enter quantity: ");
                int q = sc.nextInt();

                if (q > 0) {
                    quantity[choice - 1] += q;
                    System.out.println("Item added successfully!");
                } else {
                    System.out.println("Invalid quantity!");
                }

            } else if (choice != 0) {

                System.out.println("Invalid product number!");

            }

        } while (choice != 0);

        System.out.println("\n================================");
        System.out.println("          CUSTOMER BILL");
        System.out.println("================================");

        System.out.printf("%-12s %-8s %-10s\n",
                "Item", "Qty", "Amount");

        System.out.println("--------------------------------");

        for (int i = 0; i < items.length; i++) {

            if (quantity[i] > 0) {

                int amount = price[i] * quantity[i];

                System.out.printf("%-12s %-8d Rs.%-10d\n",
                        items[i], quantity[i], amount);

                total = total + amount;
            }
        }

        double gst = total * 0.05;
        double finalAmount = total + gst;

        System.out.println("--------------------------------");
        System.out.println("Total Amount: Rs." + total);
        System.out.println("GST (5%): Rs." + gst);
        System.out.println("--------------------------------");
        System.out.println("Final Amount: Rs." + finalAmount);
        System.out.println("================================");
        System.out.println("     THANK YOU! VISIT AGAIN");
        System.out.println("================================");

        sc.close();
    }
}
