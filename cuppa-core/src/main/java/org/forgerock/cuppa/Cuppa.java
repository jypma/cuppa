package org.forgerock.cuppa;

import org.forgerock.cuppa.functions.HookFunction;
import org.forgerock.cuppa.functions.TestBlockFunction;
import org.forgerock.cuppa.functions.TestFunction;
import org.forgerock.cuppa.internal.TestContainer;
import org.forgerock.cuppa.model.Behaviour;

/**
 * Use the methods of this class to define your tests.
 */
public final class Cuppa {

    private Cuppa() {
    }

    /**
     * Registers a described suite of tests to be run.
     *
     * @param description The description of the 'describe' block.
     * @param function The 'describe' block.
     */
    public static void describe(String description, TestBlockFunction function) {
        TestContainer.INSTANCE.describe(description, function);
    }

    /**
     * Registers a described suite of tests to be run.
     *
     * @param behaviour If {@link Behaviour#SKIP} then this test will be skipped.
     * @param description The description of the 'describe' block.
     * @param function The 'describe' block.
     */
    public static void describe(Behaviour behaviour, String description, TestBlockFunction function) {
        TestContainer.INSTANCE.describe(behaviour, description, function);
    }

    /**
     * Registers a 'when' block to be run.
     *
     * @param description The description of the 'when' block.
     * @param function The 'when' block.
     */
    public static void when(String description, TestBlockFunction function) {
        TestContainer.INSTANCE.when(description, function);
    }

    /**
     * Registers a 'when' block to be run.
     *
     * @param behaviour If {@link Behaviour#SKIP} then this test will be skipped.
     * @param description The description of the 'when' block.
     * @param function The 'when' block.
     */
    public static void when(Behaviour behaviour, String description, TestBlockFunction function) {
        TestContainer.INSTANCE.when(behaviour, description, function);
    }

    /**
     * Registers a 'before' block to be run.
     *
     * @param function The 'before' block.
     */
    public static void before(HookFunction function) {
        TestContainer.INSTANCE.before(function);
    }

    /**
     * Registers a 'before' block to be run.
     *
     * @param description The description of the 'before' block.
     * @param function The 'before' block.
     */
    public static void before(String description, HookFunction function) {
        TestContainer.INSTANCE.before(description, function);
    }

    /**
     * Registers a 'after' block to be run.
     *
     * @param function The 'after' block.
     */
    public static void after(HookFunction function) {
        TestContainer.INSTANCE.after(function);
    }

    /**
     * Registers a 'after' block to be run.
     *
     * @param description The description of the 'after' block.
     * @param function The 'after' block.
     */
    public static void after(String description, HookFunction function) {
        TestContainer.INSTANCE.after(description, function);
    }

    /**
     * Registers a 'beforeEach' block to be run.
     *
     * @param function The 'beforeEach' block.
     */
    public static void beforeEach(HookFunction function) {
        TestContainer.INSTANCE.beforeEach(function);
    }

    /**
     * Registers a 'beforeEach' block to be run.
     *
     * @param description The description of the 'beforeEach' block.
     * @param function The 'beforeEach' block.
     */
    public static void beforeEach(String description, HookFunction function) {
        TestContainer.INSTANCE.beforeEach(description, function);
    }

    /**
     * Registers a 'afterEach' block to be run.
     *
     * @param function The 'afterEach' block.
     */
    public static void afterEach(HookFunction function) {
        TestContainer.INSTANCE.afterEach(function);
    }

    /**
     * Registers a 'afterEach' block to be run.
     *
     * @param description The description of the 'afterEach' block.
     * @param function The 'afterEach' block.
     */
    public static void afterEach(String description, HookFunction function) {
        TestContainer.INSTANCE.afterEach(description, function);
    }

    /**
     * Registers a test function to be run.
     *
     * @param description The description of the test function.
     * @param function The test function.
     */
    public static void it(String description, TestFunction function) {
        TestContainer.INSTANCE.it(description, function);
    }

    /**
     * Registers a test function to be run.
     *
     * @param behaviour If {@link Behaviour#SKIP} then this test will be skipped.
     * @param description The description of the test function.
     * @param function The test function.
     */
    public static void it(Behaviour behaviour, String description, TestFunction function) {
        TestContainer.INSTANCE.it(behaviour, description, function);
    }

    /**
     * Registers a pending test function that has yet to be implemented.
     *
     * @param description The description of the test function.
     */
    public static void it(String description) {
        TestContainer.INSTANCE.it(description);
    }
}
