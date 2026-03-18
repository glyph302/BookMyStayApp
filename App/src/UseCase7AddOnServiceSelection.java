import java.util.Scanner;

/**
 * MAIN CLASS UseCase7AddOnServiceSelection
 * Use Case 7: Add-On Service Selection
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddOnServiceManager manager = new AddOnServiceManager();

        // Mocking a confirmed Reservation ID from Use Case 6
        String reservationId = "Single-1";

        System.out.println("--- Add-On Service Selection ---");
        System.out.println("Customizing Reservation: " + reservationId);

        // Pre-defined Services
        Service breakfast = new Service("Breakfast", 500.0);
        Service spa = new Service("Spa", 1000.0);
        Service wifi = new Service("Premium WiFi", 200.0);

        while (true) {
            System.out.println("\nAvailable Services:");
            System.out.println("1. Breakfast (500.0)");
            System.out.println("2. Spa (1000.0)");
            System.out.println("3. Premium WiFi (200.0)");
            System.out.print("Select a service number (or 0 to finish): ");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            if (choice == 1) manager.addService(reservationId, breakfast);
            else if (choice == 2) manager.addService(reservationId, spa);
            else if (choice == 3) manager.addService(reservationId, wifi);
            else System.out.println("Invalid choice.");
        }

        double totalCost = manager.calculateTotalServiceCost(reservationId);
        System.out.println("\nFinal Summary for " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);

        scanner.close();
    }
}