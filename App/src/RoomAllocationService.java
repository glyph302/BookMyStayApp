import java.util.*;

/**
 * CLASS RoomAllocationService
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.0
 */
public class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();

        // Initialize sets for each room type
        assignedRoomsByType.put("Single", new HashSet<>());
        assignedRoomsByType.put("Double", new HashSet<>());
        assignedRoomsByType.put("Suite", new HashSet<>());
    }

    /**
     * Confirms a booking and updates inventory.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        int currentAvail = inventory.getRoomAvailability().getOrDefault(type, 0);

        if (currentAvail > 0) {
            // 1. Generate Unique ID
            String roomId = generateRoomId(type);

            // 2. Record Assignment
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.get(type).add(roomId);

            // 3. Update Inventory
            inventory.updateAvailability(type, currentAvail - 1);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking FAILED for Guest: " + reservation.getGuestName() +
                    ". No " + type + " rooms available.");
        }
    }

    private String generateRoomId(String roomType) {
        int nextNumber = assignedRoomsByType.get(roomType).size() + 1;
        return roomType + "-" + nextNumber;
    }
}