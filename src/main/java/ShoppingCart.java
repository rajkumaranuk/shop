import java.math.BigDecimal;
import java.util.Scanner;

public class ShoppingCart {

    private final String SEPARATOR = ",";
    private final String APPLE = "APPLE";
    private final String ORANGE = "ORANGE";

    private final BigDecimal APPLE_PRICE = new BigDecimal("0.60");
    private final BigDecimal ORANGE_PRICE = new BigDecimal("0.25");

    public void checkout() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the items separating with \",\" : ");
        String itemStr = reader.nextLine().toUpperCase();
        String[] items = itemStr.split(SEPARATOR);

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

        BigDecimal totalCost = APPLE_PRICE.multiply(new BigDecimal(appleCount)).add(ORANGE_PRICE.multiply(new BigDecimal(orangeCount)));
        System.out.println("Total Cost : £ "  + totalCost);

    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout();
    }
}
