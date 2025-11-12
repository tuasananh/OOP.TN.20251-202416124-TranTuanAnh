package com.hust.kstn.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * MicroUnit: A simple, one-file test framework.
 * * Contains:
 * 1. The @Test annotation to mark test methods.
 * 2. The run(Class<?>) method to execute all @Test methods in a class.
 */
public class MicroUnit {

    /**
     * A custom annotation to mark a method as a test.
     * @Retention(RetentionPolicy.RUNTIME) - Makes the annotation readable at runtime.
     * @Target(ElementType.METHOD) - Allows this annotation only on methods.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test { }

    /**
     * The core test runner.
     * It discovers and executes all methods marked with @Test in the given class.
     *
     * @param testClass The class containing the test methods (e.g., CalculatorTest.class)
     */
    public static void run(Class<?> testClass) {
        int passed = 0;
        int failed = 0;
        long startTime = System.nanoTime();

        System.out.println("Running tests from: " + testClass.getName());

        // Get all the declared methods of the class
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            // Check if the method has our @Test annotation
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    // Create a new instance of the test class for each test.
                    // This ensures tests are isolated.
                    // This assumes a public no-arg constructor (default is fine).
                    Object testInstance = testClass.getDeclaredConstructor().newInstance();

                    // Invoke the test method (e.g., testAdd())
                    method.invoke(testInstance);
                    
                    // If no exception was thrown, the test passed
                    passed++;
                    System.out.println("+ " + method.getName() + " - Passed");

                } catch (InvocationTargetException e) {
                    // This is thrown when the test method itself throws an exception
                    // (e.g., an AssertionError).
                    failed++;
                    Throwable cause = e.getCause(); // Get the real exception
                    System.out.println("- " + method.getName() + " - FAILED: " + cause.getMessage());
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException e) {
                    // This catches other errors (e.g., framework issues, no constructor)
                    failed++;
                    System.out.println("- " + method.getName() + " - FAILED (Framework Error): " + e);
                }
            }
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0; // Convert to seconds

        // Print the final summary
        System.out.println("\n--- Test Summary ---");
        System.out.printf("Total: %d, Passed: %d, Failed: %d\n", (passed + failed), passed, failed);
        System.out.printf("Duration: %.3f seconds\n", duration);

        // Exit with an error code if any tests failed (useful for automation)
        if (failed > 0) {
            System.exit(1);
        } else {
            System.exit(0);
        }
    }
}