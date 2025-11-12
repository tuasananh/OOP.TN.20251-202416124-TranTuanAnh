package com.hust.kstn.test;

public class Asserts {
    /**
     * A custom error to throw when an assertion fails.
     * We extend Error (like Java's built-in AssertionError) so that
     * test authors don't have to declare 'throws AssertionFailedError'
     * in their test methods.
     */
    public static class AssertionFailedError extends Error {
        public AssertionFailedError(String message) {
            super(message);
        }
    }

    // --- Helper Methods ---

    /**
     * Fails a test with the given message.
     */
    public static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    /**
     * Asserts that a condition is true.
     * @param condition The condition to check
     */
    public static void assertTrue(boolean condition) {
        if (!condition) {
            fail("Assertion failed. Expected: true, but got: false");
        }
    }

    /**
     * Asserts that a condition is false.
     * @param condition The condition to check
     */
    public static void assertFalse(boolean condition) {
        if (condition) {
            fail("Assertion failed. Expected: false, but got: true");
        }
    }

    /**
     * Asserts that an object is null.
     */
    public static void assertNull(Object obj) {
        if (obj != null) {
            fail("Assertion failed. Expected: null, but got: " + obj);
        }
    }

    /**
     * Asserts that an object is not null.
     */
    public static void assertNotNull(Object obj) {
        if (obj == null) {
            fail("Assertion failed. Expected: non-null, but got: null");
        }
    }

    /**
     * Asserts that two objects are equal using the .equals() method.
     * Also handles nulls gracefully.
     *
     * @param expected The expected value
     * @param actual The value produced by the code under test
     */
    public static void assertEquals(Object expected, Object actual) {
        // Handle nulls
        if (expected == null) {
            if (actual != null) {
                fail("Assertion failed. Expected: null, but got: " + actual);
            }
        }
        // Use .equals()
        else if (!expected.equals(actual)) {
            fail("Assertion failed. Expected: <" + expected + ">, but got: <" + actual + ">");
        }
    }

    /**
     * Asserts that two integers are equal.
     */
    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            fail("Assertion failed. Expected: <" + expected + ">, but got: <" + actual + ">");
        }
    }

    /**
     * Asserts that two doubles are equal within a given tolerance (delta).
     * This is necessary for floating-point numbers.
     */
    public static void assertEquals(double expected, double actual, double delta) {
        if (Math.abs(expected - actual) > delta) {
            fail("Assertion failed. Expected: <" + expected + "> (within " + delta + "), but got: <" + actual + ">");
        }
    }
    
    // You could add more overloads for long, float, boolean, etc.
}