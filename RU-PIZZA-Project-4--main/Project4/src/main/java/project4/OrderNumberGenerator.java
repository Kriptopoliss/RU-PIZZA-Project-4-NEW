package project4;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class OrderNumberGenerator {
    private static OrderNumberGenerator instance = null;
    private final Random random = new Random();
    private final Set<Integer> generatedOrderNumbers = new HashSet<>();

    // Private constructor to enforce singleton pattern
    private OrderNumberGenerator() {
        // Private constructor
    }

    /**
     * Get the instance of the OrderNumberGenerator (Singleton pattern).
     *
     * @return The singleton instance of OrderNumberGenerator.
     */
    public static synchronized OrderNumberGenerator getInstance() {
        if (instance == null) {
            instance = new OrderNumberGenerator();
        }
        return instance;
    }

    /**
     * Generate a unique order number.
     *
     * @return A unique order number.
     */
    public int generateOrderNumber() {
        int orderNumber;
        do {
            // Generate a random 5-digit order number in the range [10000, 99999]
            orderNumber = 10000 + random.nextInt(90000);
        } while (generatedOrderNumbers.contains(orderNumber));
        generatedOrderNumbers.add(orderNumber);
        return orderNumber;
    }
}
