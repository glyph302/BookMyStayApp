import java.util.Scanner;

/**
 * MAIN CLASS UseCase9ErrorHandlingValidation
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        System.out.println("Booking Validation System");
        Scanner scanner = new Scanner(System.in);

        // Components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // STEP: Validate before adding to Queue
            validator.validate(guestName, roomType, inventory);

            // If we reach here, validation passed!
            Reservation request = new Reservation(guestName, roomType);
            bookingQueue.addRequest(request);
            System.out.println("Success: Request added to queue for " + guestName);

        } catch (InvalidBookingException e) {
            // This catches the 'throw' from the validator
            System.out.println("Booking failed: " + e.getMessage());
        } catch (Exception e) {
            // General catch-all for unexpected errors
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // This runs NO MATTER WHAT (success or failure)
            System.out.println("Validation process completed.");
            scanner.close();
        }
    }
}