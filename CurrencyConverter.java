package helllojava;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Exchange rates (hardcoded for simplicity)
        final double USD_TO_EUR = 0.85;
        final double USD_TO_INR = 74.50;
        final double USD_TO_GBP = 0.72;

        System.out.println("CURRENCY CONVERTER");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. INR (Indian Rupee)");
        System.out.println("4. GBP (British Pound)");

        // Input
        System.out.print("\nEnter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("From currency (1-4): ");
        int from = scanner.nextInt();

        System.out.print("To currency (1-4): ");
        int to = scanner.nextInt();

        // Convert to USD first (base currency)
        double amountInUSD;
        switch (from) {
            case 1: amountInUSD = amount; break;                 // USD
            case 2: amountInUSD = amount / USD_TO_EUR; break;   // EUR
            case 3: amountInUSD = amount / USD_TO_INR; break;    // INR
            case 4: amountInUSD = amount / USD_TO_GBP; break;   // GBP
            default:
                System.out.println("Invalid input!");
                return;
        }

        // Convert from USD to target currency
        double result;
        switch (to) {
            case 1: result = amountInUSD; break;                 // USD
            case 2: result = amountInUSD * USD_TO_EUR; break;    // EUR
            case 3: result = amountInUSD * USD_TO_INR; break;    // INR
            case 4: result = amountInUSD * USD_TO_GBP; break;    // GBP
            default:
                System.out.println("Invalid input!");
                return;
        }

        // Output
        String[] currencies = {"USD", "EUR", "INR", "GBP"};
        System.out.printf("\nResult: %.2f %s = %.2f %s\n",
            amount, currencies[from - 1],
            result, currencies[to - 1]);

        scanner.close();
    }
}