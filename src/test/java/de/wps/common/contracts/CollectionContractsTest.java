package de.wps.common.contracts;

import static de.wps.common.contracts.CollectionContracts.checkNotEmpty;
import static de.wps.common.contracts.CollectionContracts.ensureNotEmpty;
import static de.wps.common.contracts.CollectionContracts.requireNotEmpty;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionContractsTest {

    @Test
    void requireNotEmpty_default() {
        List<Object> argument = List.of(new Object());
        List<Object> nonEmptyArgument = requireNotEmpty(argument, "argument");
        assertSame(argument, nonEmptyArgument);
    }

    @Test
    void requireNotEmpty_empty() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty(List.of(), "argument"));
        assertEquals("Argument argument was empty", throwable.getMessage());
    }

    @Test
    void requireNotEmpty_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty(null, "argument"));
        assertEquals("Argument argument was null", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_default() {
        List<Object> argument = List.of(new Object());
        List<Object> nonEmptyState = checkNotEmpty(argument, "state");
        assertSame(argument, nonEmptyState);
    }

    @Test
    void checkNotEmpty_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty(List.of(), "state"));
        assertEquals("State state was empty", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty(null, "state"));
        assertEquals("State state was null", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_default() {
        List<Object> argument = List.of(new Object());
        List<Object> nonEmptyResult = ensureNotEmpty(argument, "result");
        assertSame(argument, nonEmptyResult);
    }

    @Test
    void ensureNotEmpty_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty(List.of(), "result"));
        assertEquals("Result result was empty", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty(null, "result"));
        assertEquals("Result result was null", throwable.getMessage());
    }
}