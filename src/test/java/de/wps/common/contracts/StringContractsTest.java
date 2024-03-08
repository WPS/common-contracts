package de.wps.common.contracts;

import static de.wps.common.contracts.StringContracts.checkHasLength;
import static de.wps.common.contracts.StringContracts.checkHasText;
import static de.wps.common.contracts.StringContracts.ensureHasLength;
import static de.wps.common.contracts.StringContracts.ensureHasText;
import static de.wps.common.contracts.StringContracts.requireHasLength;
import static de.wps.common.contracts.StringContracts.requireHasText;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringContractsTest {

    @Test
    void requireHasLength_default() {
        String testString = "testString";
        String checkedArgument = requireHasLength(testString, "argument");
        assertSame(testString, checkedArgument);
    }

    @Test
    void requireHasLength_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasLength(null, "argument"));
        assertEquals("Argument argument was null", throwable.getMessage());
    }

    @Test
    void requireHasLength_empty() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasLength("", "argument"));
        assertEquals("Argument argument was empty", throwable.getMessage());
    }

    @Test
    void requireHasText_default() {
        String testString = "testString";
        String checkedArgument = requireHasText(testString, "argument");
        assertSame(testString, checkedArgument);
    }

    @Test
    void requireHasText_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText(null, "argument"));
        assertEquals("Argument argument was null", throwable.getMessage());
    }

    @Test
    void requireHasText_empty() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText("", "argument"));
        assertEquals("Argument argument was blank", throwable.getMessage());
    }

    @Test
    void requireHasText_blank() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText(" \t", "argument"));
        assertEquals("Argument argument was blank", throwable.getMessage());
    }

    @Test
    void checkHasLength_default() {
        String testString = "testString";
        String checkedArgument = checkHasLength(testString, "state");
        assertSame(testString, checkedArgument);
    }

    @Test
    void checkHasLength_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasLength(null, "state"));
        assertEquals("State state was null", throwable.getMessage());
    }

    @Test
    void checkHasLength_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasLength("", "state"));
        assertEquals("State state was empty", throwable.getMessage());
    }

    @Test
    void checkHasText_default() {
        String testString = "testString";
        String checkedArgument = checkHasText(testString, "state");
        assertSame(testString, checkedArgument);
    }

    @Test
    void checkHasText_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText(null, "state"));
        assertEquals("State state was null", throwable.getMessage());
    }

    @Test
    void checkHasText_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText("", "state"));
        assertEquals("State state was blank", throwable.getMessage());
    }

    @Test
    void checkHasText_blank() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText(" \t", "state"));
        assertEquals("State state was blank", throwable.getMessage());
    }



    @Test
    void ensureHasLength_default() {
        String testString = "testString";
        String checkedArgument = ensureHasLength(testString, "result");
        assertSame(testString, checkedArgument);
    }

    @Test
    void ensureHasLength_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasLength(null, "result"));
        assertEquals("Result result was null", throwable.getMessage());
    }

    @Test
    void ensureHasLength_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasLength("", "result"));
        assertEquals("Result result was empty", throwable.getMessage());
    }

    @Test
    void ensureHasText_default() {
        String testString = "testString";
        String checkedArgument = ensureHasText(testString, "result");
        assertSame(testString, checkedArgument);
    }

    @Test
    void ensureHasText_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText(null, "result"));
        assertEquals("Result result was null", throwable.getMessage());
    }

    @Test
    void ensureHasText_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText("", "result"));
        assertEquals("Result result was blank", throwable.getMessage());
    }

    @Test
    void ensureHasText_blank() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText(" \t", "result"));
        assertEquals("Result result was blank", throwable.getMessage());
    }
}