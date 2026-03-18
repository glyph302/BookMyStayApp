import java.util.Scanner;

/**
 * MAIN CLASS UseCase8BookingHistoryReport
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup Components
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        System.out.println("--- Booking History and Reporting ---");

        // Input simulation
        while (true) {
            System.out.print("Enter Guest Name to confirm booking (or 'report' to see history): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("report")) break;

            System.out.print("Enter Room Type: ");
            String type = scanner.nextLine();

            // In Use Case 6/7 these would be confirmed first. 
            // Here we add them directly to history to demonstrate the report.
            Reservation confirmedBooking = new Reservation(name, type);
            history.addReservation(confirmedBooking);

            System.out.println("Booking recorded for " + name + ".\n");
        }

        // Generate the final report
        reportService.generateReport(history);

        scanner.close();
    }
}