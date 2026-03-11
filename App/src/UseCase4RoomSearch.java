import java.util.Scanner;

/**
 * MAIN CLASS UseCase4RoomSearch
 * Use Case 4: Room Search & Availability Check
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup existing components
        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        // Initialize Domain Models
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Welcome to the Book My Stay Guest Portal");
        System.out.print("Press 'S' to search for available rooms or 'Q' to quit: ");

        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("S")) {
            // Perform the search
            searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);
        } else {
            System.out.println("Exiting system. Have a nice day!");
        }

        scanner.close();
    }
}