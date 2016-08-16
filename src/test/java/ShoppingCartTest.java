import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @Before
    public void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void checkout() {
        String input = "apple, ORANGE, orange, Apple, APPLE, Orange, orange, mango";
        BigDecimal cost = shoppingCart.checkout(input);
        Assert.assertEquals("Total cost doesn't match", new BigDecimal("1.95"), cost);
    }

    /**
     * no remainder when dividing for offer
     * even number of apples
     * and oranges as multiple of 3
     */
    @Test
    public void checkoutWithMaxOffer() {
        String input = "apple, ORANGE, orange, Apple, Orange";
        BigDecimal cost = shoppingCart.checkout(input);
        Assert.assertEquals("Total cost doesn't match", new BigDecimal("1.10"), cost);
    }
    @Test
    public void checkoutEmptyItems() {
        String input = "";
        BigDecimal cost = shoppingCart.checkout(input);
        Assert.assertEquals("Total cost doesn't match", new BigDecimal("0.00"), cost);
    }
}
