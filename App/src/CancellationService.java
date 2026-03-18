import java.util.*;

/**
 * CLASS CancellationService
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * @version 10.0
 */
public class CancellationService {
    // LIFO Stack to track released IDs
    private Stack<String> releasedRoomIds;
    // Map to link Reservation ID to its Room Type for restoration
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking so it can be cancelled later.
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a booking and increments inventory.
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Error: Reservation ID " + reservationId + " not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);
        int currentAvail = inventory.getRoomAvailability().getOrDefault(roomType, 0);

        // 1. Restore Inventory
        inventory.updateAvailability(roomType, currentAvail + 1);

        // 2. Add to Rollback Stack (LIFO)
        releasedRoomIds.push(reservationId);

        // 3. Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Displays recently cancelled reservations (Most Recent First).
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations recorded.");
            return;
        }

        // We use a temporary stack or clone to print without destroying the original
        Stack<String> tempStack = (Stack<String>) releasedRoomIds.clone();
        while (!tempStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + tempStack.pop());
        }
    }
}