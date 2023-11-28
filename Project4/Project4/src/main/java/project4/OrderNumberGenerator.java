package project4;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class OrderNumberGenerator {
    private static OrderNumberGenerator instance = null;
    private final Random random = new Random();
    private final Set<Integer> generatedOrderNumbers = new HashSet<>();

    private OrderNumberGenerator() {
        // Private constructor
    }

    public static synchronized OrderNumberGenerator getInstance() {
        if (instance == null) {
            instance = new OrderNumberGenerator();
        }
        return instance;
    }

    public int generateOrderNumber() {
        int orderNumber;
        do {
            orderNumber = 10000 + random.nextInt(90000);
        } while (generatedOrderNumbers.contains(orderNumber));
        generatedOrderNumbers.add(orderNumber);
        return orderNumber;
    }
}
