import java.util.ArrayList;
import java.util.List;

/**
 * CLASS BookingHistory
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */
public class BookingHistory {
    /** List that stores confirmed reservations in insertion order. */
    private List<Reservation> confirmedReservations;

    /** Initializes an empty booking history. */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /** Adds a confirmed reservation to the audit trail. */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /** @return list of all confirmed reservations */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}