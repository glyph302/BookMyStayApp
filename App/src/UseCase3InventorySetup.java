import java.util.Map;

/**
 * MAIN CLASS UseCase3InventorySetup
 * Use Case 3: Centralized Room Inventory Management
 * @version 3.0
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status");
        System.out.println("---------------------------");

        // Initialize objects
        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Single Room
        Room single = new SingleRoom();
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Single") + "\n");

        // Double Room
        Room doubleRoom = new DoubleRoom();
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Double") + "\n");

        // Suite Room
        Room suite = new SuiteRoom();
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Suite"));
    }
}