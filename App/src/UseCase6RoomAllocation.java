import java.util.Scanner;

/**
 * MAIN CLASS UseCase6RoomAllocation
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.0
 */
public class UseCase6RoomAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize All Components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        System.out.println("--- Room Allocation System ---");

        // Step 1: Collect Requests (User Input)
        while (true) {
            System.out.print("Enter Guest Name (or 'process' to start allocation): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("process")) break;

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            String type = scanner.nextLine();

            queue.addRequest(new Reservation(name, type));
        }

        // Step 2: Process Queue in FIFO Order
        System.out.println("\nProcessing Room Allocations...");
        System.out.println("-------------------------------");

        while (queue.hasPendingRequests()) {
            Reservation request = queue.getNextRequest();
            allocationService.allocateRoom(request, inventory);
        }

        System.out.println("\nFinal Inventory Status:");
        System.out.println(inventory.getRoomAvailability());

        scanner.close();
    }
}