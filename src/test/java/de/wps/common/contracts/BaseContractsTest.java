package de.wps.common.contracts;

import static org.junit.jupiter.api.Assertions.*;
import static de.wps.common.contracts.BaseContracts.*;

import org.junit.jupiter.api.Test;

class BaseContractsTest {

    @Test
    void requireNotNull_default() {
        Object argument = new Object();
        Object argumentReturned = requireNotNull(argument, "testArgument");
        assertSame(argument, argumentReturned);
    }

    @Test
    void requireNotNull_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                () -> requireNotNull(null, "testArgument"));
        assertEquals("Argument testArgument was null", throwable.getMessage());
    }

    @Test
    void require_default() {
        require(true,  "testCondition");
    }

    @Test
    void require_false() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                () -> require(false, "testCondition"));
        assertEquals("Argument did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void requireWithSupplier_default() {
        require(true,  () -> "testCondition");
    }

    @Test
    void requireWithSupplier_false() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                () -> require(false, () -> "testCondition"));
        assertEquals("Argument did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void checkNotNull_default() {
        Object argument = new Object();
        Object argumentReturned = checkNotNull(argument, "testState");
        assertSame(argument, argumentReturned);
    }

    @Test
    void checkNotNull_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> checkNotNull(null, "testState"));
        assertEquals("State object testState was null", throwable.getMessage());
    }

    @Test
    void check_default() {
        check(true,  "testCondition");
    }

    @Test
    void check_false() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> check(false, "testCondition"));
        assertEquals("State did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void checkWithSupplier_default() {
        check(true,  () -> "testCondition");
    }

    @Test
    void checkWithSupplier_false() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> check(false, () -> "testCondition"));
        assertEquals("State did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void ensureNotNull_default() {
        Object argument = new Object();
        Object argumentReturned = ensureNotNull(argument, "testResult");
        assertSame(argument, argumentReturned);
    }

    @Test
    void ensureNotNull_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> ensureNotNull(null, "testResult"));
        assertEquals("Result testResult was null", throwable.getMessage());
    }

    @Test
    void ensure_default() {
        ensure(true,  "testCondition");
    }

    @Test
    void ensure_false() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> ensure(false, "testCondition"));
        assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void ensureWithSupplier_default() {
        ensure(true,  () -> "testCondition");
    }

    @Test
    void ensureWithSupplier_false() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> ensure(false, () -> "testCondition"));
        assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void ensureWithPredicate_default() {
        Object result = new Object();
        Object ensuredResult = ensure(result, o -> true, "testCondition");
        assertSame(result, ensuredResult);
    }

    @Test
    void ensureWithPredicate_predicateFails() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> ensure(new Object(), o -> false, "testCondition"));
        assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
    }

    @Test
    void testEnsureWithPredicateAndSupplier_default() {
        Object result = new Object();
        Object ensuredResult = ensure(result, o -> true, () -> "testCondition");
        assertSame(result, ensuredResult);
    }

    @Test
    void testEnsureWithPredicateAndSupplier_false() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class,
                () -> ensure(new Object(), o -> false, () -> "testCondition"));
        assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
    }
}