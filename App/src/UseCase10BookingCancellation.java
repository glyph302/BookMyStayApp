import java.util.Scanner;

/**
 * MAIN CLASS UseCase10BookingCancellation
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * @version 10.0
 */
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        System.out.println("--- Booking Cancellation System ---");
        Scanner scanner = new Scanner(System.in);

        // Setup Components
        RoomInventory inventory = new RoomInventory();
        CancellationService cancelService = new CancellationService();

        // 1. Pre-register some mock bookings (Normally done in UC6)
        cancelService.registerBooking("Single-1", "Single");
        cancelService.registerBooking("Double-1", "Double");
        cancelService.registerBooking("Suite-1", "Suite");

        System.out.println("Current Availability: " + inventory.getRoomAvailability());
        System.out.print("\nEnter Reservation ID to cancel (e.g., Single-1): ");
        String idToCancel = scanner.nextLine();

        // 2. Execute Cancellation
        cancelService.cancelBooking(idToCancel, inventory);

        // 3. Show History and New State
        cancelService.showRollbackHistory();

        String type = idToCancel.split("-")[0]; // Get "Single" from "Single-1"
        System.out.println("Updated " + type + " Room Availability: " +
                inventory.getRoomAvailability().get(type));

        scanner.close();
    }
}