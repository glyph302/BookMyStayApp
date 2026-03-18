/**
 * CLASS InvalidBookingException
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */
public class InvalidBookingException extends Exception {
    /**
     * Creates a custom exception for booking errors.
     * @param message The specific reason for failure.
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}