import java.util.List;

/**
 * CLASS BookingReportService
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */
public class BookingReportService {
    /**
     * Displays a summary report of all confirmed bookings.
     * This is a read-only operation on the history data.
     */
    public void generateReport(BookingHistory history) {
        List<Reservation> reservations = history.getConfirmedReservations();

        System.out.println("\n--- Booking History Report ---");
        if (reservations.isEmpty()) {
            System.out.println("No confirmed bookings found.");
            return;
        }

        for (Reservation res : reservations) {
            System.out.println("Guest: " + res.getGuestName() +
                    ", Room Type: " + res.getRoomType());
        }
        System.out.println("------------------------------");
    }
}