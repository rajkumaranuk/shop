import java.math.BigDecimal;
import java.util.Scanner;

/**
 * shopping cart class for checkout function
 */
public class ShoppingCart {

    private final String SEPARATOR = ",";
    private final String APPLE = "APPLE";
    private final String ORANGE = "ORANGE";

    private final BigDecimal APPLE_PRICE = new BigDecimal("0.60");
    private final BigDecimal ORANGE_PRICE = new BigDecimal("0.25");

    /**
     * calculating the total price.
     * only apple and orange are considered
     * other items are omitted
     * @param input
     * @return
     */
    public BigDecimal checkout(String input) {

        input = input.toUpperCase();
        String[] items = input.split(SEPARATOR);  // split the input into items

        int appleCount = 0;
        int orangeCount = 0;
        for (String item : items) {
            item = item.trim();
            if (item.equals(APPLE)) {
                ++appleCount;
            } else if (item.equals(ORANGE)) {
                ++orangeCount;
            }
        }
        //calculate the total cost
        return APPLE_PRICE.multiply(new BigDecimal(appleCount)).add(ORANGE_PRICE.multiply(new BigDecimal(orangeCount)));
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the items separating with \",\" : ");
        String input = reader.nextLine().toUpperCase(); // get user input

        ShoppingCart cart = new ShoppingCart();
        System.out.println("Total Cost : £ "  + cart.checkout(input));
    }
}
