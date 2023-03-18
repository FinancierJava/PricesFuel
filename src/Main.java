import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println('\n'+"Please check the prices\n");

        double cost95 = 5.4;
        double cost97 = 7.2;
        double cost100 = 9.7;

        // Print header row
        System.out.printf("%-10s | %10s\n", "Type Fuel ", "Price ($)");

        // Print separator row
        System.out.println("-----------|-----------");

        // Print data rows
        System.out.printf("%-10s | %10.2f\n", "95", cost95);
        System.out.printf("%-10s | %10.2f\n", "97", cost97);
        System.out.printf("%-10s | %10.2f\n", "100", cost100);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int fuelType = 0;
        while (fuelType != 95 && fuelType != 97 && fuelType != 100) {
            System.out.print("Enter the fuel you use (95, 97, or 100): ");
            try {
                fuelType = sc.nextInt();

                if (fuelType != 95 && fuelType != 97 && fuelType != 100) {
                    System.out.println('\n' + "Invalid fuel type entered. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println('\n' + "Invalid input format. Please enter an integer value.");
                sc.next(); // consume the invalid input
            }
        }

        System.out.println('\n');
        int tankVolume = 0;

        while (tankVolume <= 0) {
            System.out.print("Enter the tank volume: ");
            try {
                tankVolume = sc.nextInt();
                if (tankVolume <= 0)
                    System.out.println('\n' + "Invalid tank volume entered. Please enter a positive integer value.");

            } catch (InputMismatchException e) {
                System.out.println('\n' + "Invalid input format. Please enter an integer value.");
                sc.next(); // consume the invalid input
            }
        }

        double finalCost;
        if (fuelType == 95)
            finalCost = cost95 * tankVolume;
        else if (fuelType == 97)
            finalCost = cost97 * tankVolume;
        else
            finalCost = cost100 * tankVolume;

        if (finalCost % 2 == 0) {
            // finalCost is an integer
            int rounded = (int) finalCost;
            System.out.println('\n' + "Final cost of full tank: " + rounded + "$");
        } else {
            // finalCost is a double
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println('\n' + "Final cost of full tank: " + df.format(finalCost) + "$");
            sc.close();
        }

    }
}