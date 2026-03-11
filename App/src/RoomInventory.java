import java.util.HashMap;
import java.util.Map;

/**
 * CLASS RoomInventory
 * Use Case 3: Centralized Room Inventory Management
 * @version 3.0
 */
public class RoomInventory {

    /** * Stores available room count for each room type.
     * Key -> Room type name (e.g., "Single")
     * Value -> Available room count 
     */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory.
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data.
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns the current availability map.
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability for a specific room type.
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}