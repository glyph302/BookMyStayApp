import java.util.Map;

/**
 * CLASS RoomSearchService
 * Use Case 4: Room Search & Availability Check
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays only rooms that have availability > 0.
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();
        boolean found = false;

        System.out.println("\n--- Available Rooms Found ---");

        // Check Single Room
        if (availability.getOrDefault("Single", 0) > 0) {
            System.out.println("Type: Single Room");
            singleRoom.displayRoomDetails();
            System.out.println("Current Availability: " + availability.get("Single"));
            System.out.println("-------------------------");
            found = true;
        }

        // Check Double Room
        if (availability.getOrDefault("Double", 0) > 0) {
            System.out.println("Type: Double Room");
            doubleRoom.displayRoomDetails();
            System.out.println("Current Availability: " + availability.get("Double"));
            System.out.println("-------------------------");
            found = true;
        }

        // Check Suite Room
        if (availability.getOrDefault("Suite", 0) > 0) {
            System.out.println("Type: Suite Room");
            suiteRoom.displayRoomDetails();
            System.out.println("Current Availability: " + availability.get("Suite"));
            System.out.println("-------------------------");
            found = true;
        }

        if (!found) {
            System.out.println("Sorry, no rooms are currently available.");
        }
    }
}