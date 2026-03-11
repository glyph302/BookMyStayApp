import java.util.Scanner;

/**
 * MAIN CLASS UseCase5BookingRequestQueue
 * Use Case 5: Booking Request (First-Come-First-Served)
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        System.out.println("--- Booking Request Queue System ---");

        while (true) {
            System.out.print("Enter Guest Name (or type 'done' to process queue): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            String type = scanner.nextLine();

            // Create and add request to queue
            bookingQueue.addRequest(new Reservation(name, type));
            System.out.println("Request added to queue for: " + name);
            System.out.println("------------------------------------");
        }

        System.out.println("\nProcessing Requests in FIFO Order:");
        System.out.println("====================================");

        if (!bookingQueue.hasPendingRequests()) {
            System.out.println("No requests to process.");
        }

        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Processing: " + next.getGuestName() + " for a " + next.getRoomType() + " room.");
        }

        System.out.println("\nAll pending requests have been handled.");
        scanner.close();
    }
}