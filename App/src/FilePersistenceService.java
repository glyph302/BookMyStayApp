import java.io.*;
import java.util.Map;

/**
 * CLASS FilePersistenceService
 * Use Case 12: Data Persistence & System Recovery
 * @version 12.0
 */
public class FilePersistenceService {

    /**
     * Saves room inventory state to a file.
     * Format: roomType availableCount
     */
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            Map<String, Integer> data = inventory.getRoomAvailability();
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Loads room inventory state from a file.
     */
    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String type = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    inventory.updateAvailability(type, count);
                }
            }
            System.out.println("Inventory restored from file.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}