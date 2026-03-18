/**
 * CLASS ConcurrentBookingProcessor
 * Use Case 11: Concurrent Booking Simulation
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (true) {
            Reservation reservation = null;

            // Critical Section 1: Accessing the shared Queue
            synchronized (bookingQueue) {
                if (bookingQueue.hasPendingRequests()) {
                    reservation = bookingQueue.getNextRequest();
                } else {
                    // No more requests to process, exit the thread loop
                    break;
                }
            }

            // Critical Section 2: Updating the shared Inventory
            if (reservation != null) {
                synchronized (inventory) {
                    allocationService.allocateRoom(reservation, inventory);
                }
            }

            // Small sleep to simulate processing time and observe thread switching
            try { Thread.sleep(100); } catch (InterruptedException e) { break; }
        }
    }
}