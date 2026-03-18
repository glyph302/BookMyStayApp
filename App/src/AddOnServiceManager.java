import java.util.*;

/**
 * CLASS AddOnServiceManager
 * Use Case 7: Add-On Service Selection
 * @version 7.0
 */
public class AddOnServiceManager {
    // Key: Reservation/Room ID (e.g. "Single-1"), Value: List of Services
    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {
        // computeIfAbsent creates a new ArrayList if the ID isn't in the map yet
        servicesByReservation.computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        List<Service> services = servicesByReservation.get(reservationId);
        if (services == null) return 0.0;

        double total = 0;
        for (Service s : services) {
            total += s.getCost();
        }
        return total;
    }
}