/*
 * Licensed to the WPS - Workplace Solutions GmbH (WPS) under
 * one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information
 * regarding copyright ownership. The WPS licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.wps.common.contracts;

import static de.wps.common.contracts.BaseContracts.check;
import static de.wps.common.contracts.BaseContracts.checkNotNull;
import static de.wps.common.contracts.BaseContracts.checkPresent;
import static de.wps.common.contracts.BaseContracts.ensure;
import static de.wps.common.contracts.BaseContracts.ensureNotNull;
import static de.wps.common.contracts.BaseContracts.ensurePresent;
import static de.wps.common.contracts.BaseContracts.require;
import static de.wps.common.contracts.BaseContracts.requireNotNull;
import static de.wps.common.contracts.BaseContracts.requirePresent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class BaseContractsTest {

    @Nested
    class BooleanTest {
        @Nested
        class Require {
            @Test
            void trueTest() {
                require(true, "testCondition");
            }

            @Test
            void falseTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                        () -> require(false, "testCondition"));
                assertEquals("Argument did not meet condition: testCondition", throwable.getMessage());
            }

            @Test
            void trueWithSupplier() {
                require(true, () -> "testCondition");
            }

            @Test
            void falseWithSupplier() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                        () -> require(false, () -> "testCondition"));
                assertEquals("Argument did not meet condition: testCondition", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void trueTest() {
                check(true, "testCondition");
            }

            @Test
            void falseTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> check(false, "testCondition"));
                assertEquals("State did not meet condition: testCondition", throwable.getMessage());
            }

            @Test
            void trueWithSupplier() {
                check(true, () -> "testCondition");
            }

            @Test
            void testWithSupplier() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> check(false, () -> "testCondition"));
                assertEquals("State did not meet condition: testCondition", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void trueTest() {
                ensure(true, "testCondition");
            }

            @Test
            void falseTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(false, "testCondition"));
                assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
            }

            @Test
            void trueWithSupplier() {
                ensure(true, () -> "testCondition");
            }

            @Test
            void falseWithSupplier() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(false, () -> "testCondition"));
                assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
            }
        }

        @Nested
        class EnsureWithPredicate {
            @Test
            void truePredicate() {
                Object result = new Object();
                Object ensuredResult = ensure(result, o -> true, "testCondition");
                assertSame(result, ensuredResult);
            }

            @Test
            void falsePredicate() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(new Object(), o -> false, "testCondition"));
                assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
            }

            @Test
            void predicateTargetNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(null, o -> true, "testCondition"));
                assertEquals("Result did not meet condition: testCondition, it was null instead", throwable.getMessage());
            }

            @Test
            void trueWithSupplier() {
                Object result = new Object();
                Object ensuredResult = ensure(result, o -> true, () -> "testCondition");
                assertSame(result, ensuredResult);
            }

            @Test
            void falseWithSupplier() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(new Object(), o -> false, () -> "testCondition"));
                assertEquals("Result did not meet condition: testCondition", throwable.getMessage());
            }

            @Test
            void predicateTargetNullWithSupplier() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensure(null, o -> true, () -> "testCondition"));
                assertEquals("Result did not meet condition: testCondition, it was null instead", throwable.getMessage());
            }
        }
    }

    @Nested
    class NotNull {
        @Nested
        class Require {
            @Test
            void notNull() {
                Object argument = new Object();
                Object argumentReturned = requireNotNull(argument, "testArgument");
                assertSame(argument, argumentReturned);
            }

            @Test
            void nullTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                        () -> requireNotNull(null, "testArgument"));
                assertEquals("Argument testArgument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void notNull() {
                Object argument = new Object();
                Object argumentReturned = checkNotNull(argument, "testState");
                assertSame(argument, argumentReturned);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> checkNotNull(null, "testState"));
                assertEquals("State object testState was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void notNull() {
                Object argument = new Object();
                Object argumentReturned = ensureNotNull(argument, "testResult");
                assertSame(argument, argumentReturned);
            }

            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensureNotNull(null, "testResult"));
                assertEquals("Result testResult was null", throwable.getMessage());
            }
        }
    }

    @Nested
    class Present {
        @Nested
        class Require {
            @Test
            void present() {
                Object argument = new Object();
                Object argumentReturned = requirePresent(Optional.of(argument), "testArgument");
                assertSame(argument, argumentReturned);
            }

            @Test
            void notPresent() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                        () -> requirePresent(Optional.empty(), "testArgument"));
                assertEquals("Argument testArgument was empty", throwable.getMessage());
            }

            @SuppressWarnings("nullness")
            @Test
            void nullTest() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                        () -> requirePresent(null, "testArgument"));
                assertEquals("Argument testArgument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void present() {
                Object state = new Object();
                Object stateReturned = checkPresent(Optional.of(state), "testState");
                assertSame(state, stateReturned);
            }

            @Test
            void notPresent() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> checkPresent(Optional.empty(), "testState"));
                assertEquals("State object testState was empty", throwable.getMessage());
            }

            @SuppressWarnings("nullness")
            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> checkPresent(null, "testState"));
                assertEquals("State object testState was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void present() {
                Object result = new Object();
                Object resultReturned = ensurePresent(Optional.of(result), "testResult");
                assertSame(result, resultReturned);
            }

            @Test
            void notPresent() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensurePresent(Optional.empty(), "testResult"));
                assertEquals("Result testResult was empty", throwable.getMessage());
            }

            @SuppressWarnings("nullness")
            @Test
            void nullTest() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class,
                        () -> ensurePresent(null, "testResult"));
                assertEquals("Result testResult was null", throwable.getMessage());
            }
        }
    }
}