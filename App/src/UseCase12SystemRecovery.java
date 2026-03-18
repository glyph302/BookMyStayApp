/**
 * MAIN CLASS UseCase12SystemRecovery
 * Use Case 12: Data Persistence & System Recovery
 * @version 12.0
 */
public class UseCase12SystemRecovery {
    public static void main(String[] args) {
        System.out.println("--- System Recovery ---");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();
        String storageFile = "inventory_data.txt";

        // 1. Attempt to Restore State
        persistence.loadInventory(inventory, storageFile);

        // 2. Display Current State
        System.out.println("Current Inventory:");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count));

        // 3. Simulate a change (decrementing Single room count)
        int currentSingle = inventory.getRoomAvailability().getOrDefault("Single", 0);
        if (currentSingle > 0) {
            System.out.println("\nSimulating a booking... updating Single room count.");
            inventory.updateAvailability("Single", currentSingle - 1);
        }

        // 4. Save State before shutdown
        persistence.saveInventory(inventory, storageFile);
    }
}