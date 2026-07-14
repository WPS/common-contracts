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

import static de.wps.common.contracts.NumberContracts.checkGreaterThan;
import static de.wps.common.contracts.NumberContracts.checkGreaterThanOrEqual;
import static de.wps.common.contracts.NumberContracts.checkLessThan;
import static de.wps.common.contracts.NumberContracts.checkLessThanOrEqual;
import static de.wps.common.contracts.NumberContracts.ensureGreaterThan;
import static de.wps.common.contracts.NumberContracts.ensureGreaterThanOrEqual;
import static de.wps.common.contracts.NumberContracts.ensureLessThan;
import static de.wps.common.contracts.NumberContracts.ensureLessThanOrEqual;
import static de.wps.common.contracts.NumberContracts.requireGreaterThan;
import static de.wps.common.contracts.NumberContracts.requireGreaterThanOrEqual;
import static de.wps.common.contracts.NumberContracts.requireLessThan;
import static de.wps.common.contracts.NumberContracts.requireLessThanOrEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumberContractsTest {

    @Nested
    class LessThan {
        @Nested
        class Require {
            @Test
            void intOk() {
                int checked = requireLessThan(4, 5, "argument");
                assertEquals(4, checked);
            }

            @Test
            void intFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(5, 5, "argument"));
                assertEquals("Argument argument (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = requireLessThan(4L, 5L, "argument");
                assertEquals(4L, checked);
            }

            @Test
            void longFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(5L, 5L, "argument"));
                assertEquals("Argument argument (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = requireLessThan(4.0f, 5.0f, "argument");
                assertEquals(4.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(5.0f, 5.0f, "argument"));
                assertEquals("Argument argument (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = requireLessThan(4.0, 5.0, "argument");
                assertEquals(4.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(5.0, 5.0, "argument"));
                assertEquals("Argument argument (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 4;
                Integer checked = requireLessThan(value, 5, "argument");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(value, 5, "argument"));
                assertEquals("Argument argument (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan((Integer) null, 5, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 4L;
                Long checked = requireLessThan(value, 5L, "argument");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(value, 5L, "argument"));
                assertEquals("Argument argument (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan((Long) null, 5L, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 4.0f;
                Float checked = requireLessThan(value, 5.0f, "argument");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(value, 5.0f, "argument"));
                assertEquals("Argument argument (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan((Float) null, 5.0f, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 4.0;
                Double checked = requireLessThan(value, 5.0, "argument");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(value, 5.0, "argument"));
                assertEquals("Argument argument (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThan(null, 5.0, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void intOk() {
                int checked = checkLessThan(4, 5, "state");
                assertEquals(4, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(5, 5, "state"));
                assertEquals("State state (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = checkLessThan(4L, 5L, "state");
                assertEquals(4L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(5L, 5L, "state"));
                assertEquals("State state (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = checkLessThan(4.0f, 5.0f, "state");
                assertEquals(4.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(5.0f, 5.0f, "state"));
                assertEquals("State state (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = checkLessThan(4.0, 5.0, "state");
                assertEquals(4.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(5.0, 5.0, "state"));
                assertEquals("State state (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 4;
                Integer checked = checkLessThan(value, 5, "state");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(value, 5, "state"));
                assertEquals("State state (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan((Integer) null, 5, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 4L;
                Long checked = checkLessThan(value, 5L, "state");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(value, 5L, "state"));
                assertEquals("State state (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan((Long) null, 5L, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 4.0f;
                Float checked = checkLessThan(value, 5.0f, "state");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(value, 5.0f, "state"));
                assertEquals("State state (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan((Float) null, 5.0f, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 4.0;
                Double checked = checkLessThan(value, 5.0, "state");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(value, 5.0, "state"));
                assertEquals("State state (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThan(null, 5.0, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void intOk() {
                int checked = ensureLessThan(4, 5, "result");
                assertEquals(4, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(5, 5, "result"));
                assertEquals("Result result (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = ensureLessThan(4L, 5L, "result");
                assertEquals(4L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(5L, 5L, "result"));
                assertEquals("Result result (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = ensureLessThan(4.0f, 5.0f, "result");
                assertEquals(4.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(5.0f, 5.0f, "result"));
                assertEquals("Result result (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = ensureLessThan(4.0, 5.0, "result");
                assertEquals(4.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(5.0, 5.0, "result"));
                assertEquals("Result result (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 4;
                Integer checked = ensureLessThan(value, 5, "result");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(value, 5, "result"));
                assertEquals("Result result (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan((Integer) null, 5, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 4L;
                Long checked = ensureLessThan(value, 5L, "result");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(value, 5L, "result"));
                assertEquals("Result result (5) was not less than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan((Long) null, 5L, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 4.0f;
                Float checked = ensureLessThan(value, 5.0f, "result");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(value, 5.0f, "result"));
                assertEquals("Result result (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan((Float) null, 5.0f, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 4.0;
                Double checked = ensureLessThan(value, 5.0, "result");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(value, 5.0, "result"));
                assertEquals("Result result (5.0) was not less than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThan(null, 5.0, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }
        }
    }

    @Nested
    class LessThanOrEqual {
        @Nested
        class Require {
            @Test
            void intOk() {
                int checked = requireLessThanOrEqual(5, 5, "argument");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(6, 5, "argument"));
                assertEquals("Argument argument (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = requireLessThanOrEqual(5L, 5L, "argument");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(6L, 5L, "argument"));
                assertEquals("Argument argument (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = requireLessThanOrEqual(5.0f, 5.0f, "argument");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(6.0f, 5.0f, "argument"));
                assertEquals("Argument argument (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = requireLessThanOrEqual(5.0, 5.0, "argument");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(6.0, 5.0, "argument"));
                assertEquals("Argument argument (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = requireLessThanOrEqual(value, 5, "argument");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 6;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(value, 5, "argument"));
                assertEquals("Argument argument (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual((Integer) null, 5, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = requireLessThanOrEqual(value, 5L, "argument");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 6L;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(value, 5L, "argument"));
                assertEquals("Argument argument (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual((Long) null, 5L, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = requireLessThanOrEqual(value, 5.0f, "argument");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 6.0f;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(value, 5.0f, "argument"));
                assertEquals("Argument argument (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual((Float) null, 5.0f, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = requireLessThanOrEqual(value, 5.0, "argument");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 6.0;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(value, 5.0, "argument"));
                assertEquals("Argument argument (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireLessThanOrEqual(null, 5.0, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void intOk() {
                int checked = checkLessThanOrEqual(5, 5, "state");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(6, 5, "state"));
                assertEquals("State state (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = checkLessThanOrEqual(5L, 5L, "state");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(6L, 5L, "state"));
                assertEquals("State state (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = checkLessThanOrEqual(5.0f, 5.0f, "state");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(6.0f, 5.0f, "state"));
                assertEquals("State state (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = checkLessThanOrEqual(5.0, 5.0, "state");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(6.0, 5.0, "state"));
                assertEquals("State state (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = checkLessThanOrEqual(value, 5, "state");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 6;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(value, 5, "state"));
                assertEquals("State state (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual((Integer) null, 5, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = checkLessThanOrEqual(value, 5L, "state");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 6L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(value, 5L, "state"));
                assertEquals("State state (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual((Long) null, 5L, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = checkLessThanOrEqual(value, 5.0f, "state");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 6.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(value, 5.0f, "state"));
                assertEquals("State state (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual((Float) null, 5.0f, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = checkLessThanOrEqual(value, 5.0, "state");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 6.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(value, 5.0, "state"));
                assertEquals("State state (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkLessThanOrEqual(null, 5.0, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void intOk() {
                int checked = ensureLessThanOrEqual(5, 5, "result");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(6, 5, "result"));
                assertEquals("Result result (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = ensureLessThanOrEqual(5L, 5L, "result");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(6L, 5L, "result"));
                assertEquals("Result result (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = ensureLessThanOrEqual(5.0f, 5.0f, "result");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(6.0f, 5.0f, "result"));
                assertEquals("Result result (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = ensureLessThanOrEqual(5.0, 5.0, "result");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(6.0, 5.0, "result"));
                assertEquals("Result result (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = ensureLessThanOrEqual(value, 5, "result");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 6;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(value, 5, "result"));
                assertEquals("Result result (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual((Integer) null, 5, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = ensureLessThanOrEqual(value, 5L, "result");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 6L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(value, 5L, "result"));
                assertEquals("Result result (6) was not less than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual((Long) null, 5L, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = ensureLessThanOrEqual(value, 5.0f, "result");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 6.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(value, 5.0f, "result"));
                assertEquals("Result result (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual((Float) null, 5.0f, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = ensureLessThanOrEqual(value, 5.0, "result");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 6.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(value, 5.0, "result"));
                assertEquals("Result result (6.0) was not less than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureLessThanOrEqual(null, 5.0, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }
        }
    }

    @Nested
    class GreaterThan {
        @Nested
        class Require {
            @Test
            void intOk() {
                int checked = requireGreaterThan(6, 5, "argument");
                assertEquals(6, checked);
            }

            @Test
            void intFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(5, 5, "argument"));
                assertEquals("Argument argument (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = requireGreaterThan(6L, 5L, "argument");
                assertEquals(6L, checked);
            }

            @Test
            void longFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(5L, 5L, "argument"));
                assertEquals("Argument argument (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = requireGreaterThan(6.0f, 5.0f, "argument");
                assertEquals(6.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(5.0f, 5.0f, "argument"));
                assertEquals("Argument argument (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = requireGreaterThan(6.0, 5.0, "argument");
                assertEquals(6.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(5.0, 5.0, "argument"));
                assertEquals("Argument argument (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 6;
                Integer checked = requireGreaterThan(value, 5, "argument");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(value, 5, "argument"));
                assertEquals("Argument argument (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan((Integer) null, 5, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 6L;
                Long checked = requireGreaterThan(value, 5L, "argument");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(value, 5L, "argument"));
                assertEquals("Argument argument (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan((Long) null, 5L, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 6.0f;
                Float checked = requireGreaterThan(value, 5.0f, "argument");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(value, 5.0f, "argument"));
                assertEquals("Argument argument (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan((Float) null, 5.0f, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 6.0;
                Double checked = requireGreaterThan(value, 5.0, "argument");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(value, 5.0, "argument"));
                assertEquals("Argument argument (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThan(null, 5.0, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void intOk() {
                int checked = checkGreaterThan(6, 5, "state");
                assertEquals(6, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(5, 5, "state"));
                assertEquals("State state (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = checkGreaterThan(6L, 5L, "state");
                assertEquals(6L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(5L, 5L, "state"));
                assertEquals("State state (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = checkGreaterThan(6.0f, 5.0f, "state");
                assertEquals(6.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(5.0f, 5.0f, "state"));
                assertEquals("State state (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = checkGreaterThan(6.0, 5.0, "state");
                assertEquals(6.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(5.0, 5.0, "state"));
                assertEquals("State state (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 6;
                Integer checked = checkGreaterThan(value, 5, "state");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(value, 5, "state"));
                assertEquals("State state (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan((Integer) null, 5, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 6L;
                Long checked = checkGreaterThan(value, 5L, "state");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(value, 5L, "state"));
                assertEquals("State state (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan((Long) null, 5L, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 6.0f;
                Float checked = checkGreaterThan(value, 5.0f, "state");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(value, 5.0f, "state"));
                assertEquals("State state (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan((Float) null, 5.0f, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 6.0;
                Double checked = checkGreaterThan(value, 5.0, "state");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(value, 5.0, "state"));
                assertEquals("State state (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThan(null, 5.0, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void intOk() {
                int checked = ensureGreaterThan(6, 5, "result");
                assertEquals(6, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(5, 5, "result"));
                assertEquals("Result result (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = ensureGreaterThan(6L, 5L, "result");
                assertEquals(6L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(5L, 5L, "result"));
                assertEquals("Result result (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = ensureGreaterThan(6.0f, 5.0f, "result");
                assertEquals(6.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(5.0f, 5.0f, "result"));
                assertEquals("Result result (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = ensureGreaterThan(6.0, 5.0, "result");
                assertEquals(6.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(5.0, 5.0, "result"));
                assertEquals("Result result (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 6;
                Integer checked = ensureGreaterThan(value, 5, "result");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 5;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(value, 5, "result"));
                assertEquals("Result result (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan((Integer) null, 5, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 6L;
                Long checked = ensureGreaterThan(value, 5L, "result");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 5L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(value, 5L, "result"));
                assertEquals("Result result (5) was not greater than 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan((Long) null, 5L, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 6.0f;
                Float checked = ensureGreaterThan(value, 5.0f, "result");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 5.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(value, 5.0f, "result"));
                assertEquals("Result result (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan((Float) null, 5.0f, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 6.0;
                Double checked = ensureGreaterThan(value, 5.0, "result");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 5.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(value, 5.0, "result"));
                assertEquals("Result result (5.0) was not greater than 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThan(null, 5.0, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }
        }
    }

    @Nested
    class GreaterThanOrEqual {
        @Nested
        class Require {
            @Test
            void intOk() {
                int checked = requireGreaterThanOrEqual(5, 5, "argument");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(4, 5, "argument"));
                assertEquals("Argument argument (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = requireGreaterThanOrEqual(5L, 5L, "argument");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(4L, 5L, "argument"));
                assertEquals("Argument argument (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = requireGreaterThanOrEqual(5.0f, 5.0f, "argument");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(4.0f, 5.0f, "argument"));
                assertEquals("Argument argument (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = requireGreaterThanOrEqual(5.0, 5.0, "argument");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(4.0, 5.0, "argument"));
                assertEquals("Argument argument (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = requireGreaterThanOrEqual(value, 5, "argument");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 4;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(value, 5, "argument"));
                assertEquals("Argument argument (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual((Integer) null, 5, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = requireGreaterThanOrEqual(value, 5L, "argument");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 4L;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(value, 5L, "argument"));
                assertEquals("Argument argument (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual((Long) null, 5L, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = requireGreaterThanOrEqual(value, 5.0f, "argument");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 4.0f;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(value, 5.0f, "argument"));
                assertEquals("Argument argument (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual((Float) null, 5.0f, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = requireGreaterThanOrEqual(value, 5.0, "argument");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 4.0;
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(value, 5.0, "argument"));
                assertEquals("Argument argument (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireGreaterThanOrEqual(null, 5.0, "argument"));
                assertEquals("Argument argument was null", throwable.getMessage());
            }
        }

        @Nested
        class Check {
            @Test
            void intOk() {
                int checked = checkGreaterThanOrEqual(5, 5, "state");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(4, 5, "state"));
                assertEquals("State state (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = checkGreaterThanOrEqual(5L, 5L, "state");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(4L, 5L, "state"));
                assertEquals("State state (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = checkGreaterThanOrEqual(5.0f, 5.0f, "state");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(4.0f, 5.0f, "state"));
                assertEquals("State state (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = checkGreaterThanOrEqual(5.0, 5.0, "state");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(4.0, 5.0, "state"));
                assertEquals("State state (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = checkGreaterThanOrEqual(value, 5, "state");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 4;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(value, 5, "state"));
                assertEquals("State state (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual((Integer) null, 5, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = checkGreaterThanOrEqual(value, 5L, "state");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 4L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(value, 5L, "state"));
                assertEquals("State state (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual((Long) null, 5L, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = checkGreaterThanOrEqual(value, 5.0f, "state");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 4.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(value, 5.0f, "state"));
                assertEquals("State state (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual((Float) null, 5.0f, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = checkGreaterThanOrEqual(value, 5.0, "state");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 4.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(value, 5.0, "state"));
                assertEquals("State state (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkGreaterThanOrEqual(null, 5.0, "state"));
                assertEquals("State state was null", throwable.getMessage());
            }
        }

        @Nested
        class Ensure {
            @Test
            void intOk() {
                int checked = ensureGreaterThanOrEqual(5, 5, "result");
                assertEquals(5, checked);
            }

            @Test
            void intFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(4, 5, "result"));
                assertEquals("Result result (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longOk() {
                long checked = ensureGreaterThanOrEqual(5L, 5L, "result");
                assertEquals(5L, checked);
            }

            @Test
            void longFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(4L, 5L, "result"));
                assertEquals("Result result (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void floatOk() {
                float checked = ensureGreaterThanOrEqual(5.0f, 5.0f, "result");
                assertEquals(5.0f, checked);
            }

            @Test
            void floatFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(4.0f, 5.0f, "result"));
                assertEquals("Result result (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleOk() {
                double checked = ensureGreaterThanOrEqual(5.0, 5.0, "result");
                assertEquals(5.0, checked);
            }

            @Test
            void doubleFail() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(4.0, 5.0, "result"));
                assertEquals("Result result (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void integerWrapperOk() {
                Integer value = 5;
                Integer checked = ensureGreaterThanOrEqual(value, 5, "result");
                assertSame(value, checked);
            }

            @Test
            void integerWrapperFail() {
                Integer value = 4;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(value, 5, "result"));
                assertEquals("Result result (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void integerWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual((Integer) null, 5, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void longWrapperOk() {
                Long value = 5L;
                Long checked = ensureGreaterThanOrEqual(value, 5L, "result");
                assertSame(value, checked);
            }

            @Test
            void longWrapperFail() {
                Long value = 4L;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(value, 5L, "result"));
                assertEquals("Result result (4) was not greater than or equal to 5", throwable.getMessage());
            }

            @Test
            void longWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual((Long) null, 5L, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void floatWrapperOk() {
                Float value = 5.0f;
                Float checked = ensureGreaterThanOrEqual(value, 5.0f, "result");
                assertSame(value, checked);
            }

            @Test
            void floatWrapperFail() {
                Float value = 4.0f;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(value, 5.0f, "result"));
                assertEquals("Result result (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void floatWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual((Float) null, 5.0f, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }

            @Test
            void doubleWrapperOk() {
                Double value = 5.0;
                Double checked = ensureGreaterThanOrEqual(value, 5.0, "result");
                assertSame(value, checked);
            }

            @Test
            void doubleWrapperFail() {
                Double value = 4.0;
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(value, 5.0, "result"));
                assertEquals("Result result (4.0) was not greater than or equal to 5.0", throwable.getMessage());
            }

            @Test
            void doubleWrapperNull() {
                IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureGreaterThanOrEqual(null, 5.0, "result"));
                assertEquals("Result result was null", throwable.getMessage());
            }
        }
    }
}
