import java.util.Scanner;

public class CurrencyConverterOffline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Hardcoded exchange rates (relative to USD)
        double inrRate = 83.0;   // 1 USD = 83 INR
        double eurRate = 0.92;   // 1 USD = 0.92 EUR
        double gbpRate = 0.78;   // 1 USD = 0.78 GBP

        System.out.println("Available currencies: USD, INR, EUR, GBP");
        System.out.print("Enter base currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        // Convert base currency to USD first
        double amountInUSD = 0;
        switch (base) {
            case "USD": amountInUSD = amount; break;
            case "INR": amountInUSD = amount / inrRate; break;
            case "EUR": amountInUSD = amount / eurRate; break;
            case "GBP": amountInUSD = amount / gbpRate; break;
            default: 
                System.out.println("Invalid base currency!");
                return;
        }

        // Convert USD to target
        double converted = 0;
        switch (target) {
            case "USD": converted = amountInUSD; break;
            case "INR": converted = amountInUSD * inrRate; break;
            case "EUR": converted = amountInUSD * eurRate; break;
            case "GBP": converted = amountInUSD * gbpRate; break;
            default: 
                System.out.println("Invalid target currency!");
                return;
        }

        System.out.println("\n===== Conversion Result =====");
        System.out.println(amount + " " + base + " = " + converted + " " + target);

        sc.close();
    }
}
