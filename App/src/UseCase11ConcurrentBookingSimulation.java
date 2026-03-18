/**
 * MAIN CLASS UseCase11ConcurrentBookingSimulation
 * Use Case 11: Concurrent Booking Simulation
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("--- Concurrent Booking Simulation ---");

        // Shared Resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add several requests to the queue first
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        // Create two worker threads sharing the same resources
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        // Start the threads
        t1.start();
        t2.start();

        try {
            // Wait for both threads to finish their work
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nFinal Processing Complete.");
        System.out.println("Remaining Inventory:");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count));
    }
}