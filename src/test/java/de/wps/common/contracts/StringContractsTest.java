package de.wps.common.contracts;

import static de.wps.common.contracts.StringContracts.checkHasLength;
import static de.wps.common.contracts.StringContracts.checkHasText;
import static de.wps.common.contracts.StringContracts.checkMaxLength;
import static de.wps.common.contracts.StringContracts.ensureHasLength;
import static de.wps.common.contracts.StringContracts.ensureHasText;
import static de.wps.common.contracts.StringContracts.ensureMaxLength;
import static de.wps.common.contracts.StringContracts.requireHasLength;
import static de.wps.common.contracts.StringContracts.requireHasText;
import static de.wps.common.contracts.StringContracts.requireMaxLength;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringContractsTest {

    @Nested
    class HasLength {
        @Nested
        class Require {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = requireHasLength(testString, "argument");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasLength(null, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasLength("", "argument"));
                assertEquals("Argument argument was empty", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = checkHasLength(testString, "state");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasLength(null, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasLength("", "state"));
                assertEquals("State state was empty", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = ensureHasLength(testString, "result");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasLength(null, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasLength("", "result"));
                assertEquals("Result result was empty", throwable.getMessage());
            }
        }
    }

    @Nested
    class HasText {
        @Nested
        class Require {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = requireHasText(testString, "argument");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText(null, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText("", "argument"));
                assertEquals("Argument argument was blank", throwable.getMessage());
            }

            @Test
            void blank() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireHasText(" \t", "argument"));
                assertEquals("Argument argument was blank", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = checkHasText(testString, "state");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText(null, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText("", "state"));
                assertEquals("State state was blank", throwable.getMessage());
            }

            @Test
            void blank() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkHasText(" \t", "state"));
                assertEquals("State state was blank", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = ensureHasText(testString, "result");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText(null, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void empty() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText("", "result"));
                assertEquals("Result result was blank", throwable.getMessage());
            }

            @Test
            void blank() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureHasText(" \t", "result"));
                assertEquals("Result result was blank", throwable.getMessage());
            }
        }
    }

    @Nested
    class MaxLength {
        @Nested
        class Require {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = requireMaxLength(testString, 10, "argument");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireMaxLength(null, 10, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void empty() {
                String testString = "";
                String checkedArgument = requireMaxLength(testString, 10, "argument");
                assertSame(testString, checkedArgument);
            }

            @Test
            void toLong() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireMaxLength("abcde", 4, "argument"));
                assertEquals("Length of argument was > 4", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = checkMaxLength(testString, 10, "state");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkMaxLength(null, 10, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void empty() {
                String testString = "";
                String checkedArgument = checkMaxLength(testString, 10, "state");
                assertSame(testString, checkedArgument);
            }

            @Test
            void toLong() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkMaxLength("abcde", 4, "state"));
                assertEquals("Length of state was > 4", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void defaultTest() {
                String testString = "testString";
                String checkedArgument = ensureMaxLength(testString, 10, "result");
                assertSame(testString, checkedArgument);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureMaxLength(null, 10, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void empty() {
                String testString = "";
                String checkedArgument = ensureMaxLength(testString, 10, "result");
                assertSame(testString, checkedArgument);
            }

            @Test
            void toLong() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureMaxLength("abcde", 4, "result"));
                assertEquals("Length of result was > 4", throwable.getMessage());
            }
        }
    }
}