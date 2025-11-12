package com.hust.kstn.test;
import com.hust.kstn.test.MicroUnit.Test;
import static com.hust.kstn.test.Asserts.*;
import static com.hust.kstn.test.TestData.*;
import com.hust.kstn.models.Store;

public class StoreTest {
    public static void main(String[] args) {
        MicroUnit.run(StoreTest.class);
    }

    @Test 
    public void testAddAndRemoveDVD() {
        Store store = new Store();

        store.addDVD(availableDVDs[0]);
        store.addDVD(availableDVDs[1]);

        assertEquals(1, store.removeDVD(availableDVDs[0]));
        assertEquals(0, store.removeDVD(availableDVDs[0]));
    }
}
