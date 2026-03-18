/**
 * CLASS ReservationValidator
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */
public class ReservationValidator {
    /**
     * Checks if the input is valid.
     * @throws InvalidBookingException if rules are broken.
     */
    public void validate(String guestName, String roomType, RoomInventory inventory)
            throws InvalidBookingException {

        // Rule 1: Name cannot be empty
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Rule 2: Room type must exist (Case Sensitive check)
        if (!inventory.getRoomAvailability().containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected. (Note: It is case-sensitive)");
        }

        // Rule 3: Must have at least one room available
        if (inventory.getRoomAvailability().get(roomType) <= 0) {
            throw new InvalidBookingException("No " + roomType + " rooms are currently available.");
        }
    }
}