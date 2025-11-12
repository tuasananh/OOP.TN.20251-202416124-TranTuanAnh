package com.hust.kstn.test;
import com.hust.kstn.models.Cart;
import com.hust.kstn.test.MicroUnit.Test;
import static com.hust.kstn.test.TestData.availableDVDs;
import static com.hust.kstn.test.Asserts.*;

public class CartTest {
    // Should be run with assertions enabled (-ea flag)
    public static void main(String[] args) {
        MicroUnit.run(CartTest.class);
    } 

    @Test 
    public void testAddAndRemoveDVD() {
        Cart cart = new Cart();

        // Test adding DVDs
        assertEquals(1, cart.addDVD(availableDVDs[0]));
        assertEquals(2, cart.addDVD(availableDVDs[1], availableDVDs[2]));
        assertEquals(3, cart.addDVD(availableDVDs[3], availableDVDs[4], availableDVDs[5]));

        // Test removing DVDs
        assertEquals(1, cart.removeDVD(availableDVDs[0]));

        // Test removing a DVD not in the cart
        assertEquals(0, cart.removeDVD(availableDVDs[6]));
    }

    @Test 
    public void testFullCart() {
        Cart cart = new Cart();

        // Fill the cart to its maximum capacity
        for (int i = 0; i < 20; i++) {
            cart.addDVD(availableDVDs[i]);
        }

        // Attempt to add one more DVD beyond capacity
        assertEquals(0, cart.addDVD(availableDVDs[0]));
    }
}
