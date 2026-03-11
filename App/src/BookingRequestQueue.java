import java.util.LinkedList;
import java.util.Queue;

/**
 * CLASS BookingRequestQueue
 * Use Case 5: Booking Request (FIFO)
 * @version 5.0
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        // LinkedList is used here because it implements the Queue interface
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        // Note: Logic flipped from prompt to match common 'has' naming convention
        return !requestQueue.isEmpty();
    }
}