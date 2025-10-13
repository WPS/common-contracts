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
import static de.wps.common.contracts.BaseContracts.ensure;
import static de.wps.common.contracts.BaseContracts.require;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test to demonstrate that the NPE issue with Boolean unboxing has been resolved.
 * These tests show that passing null Boolean objects no longer causes NPE during unboxing.
 */
class BooleanNpeTest {

    @Test
    void demonstrateNpePreventionInRequire() {
        // This would have caused NPE before our fix, now it throws IllegalArgumentException
        Boolean nullBoolean = null;
        assertThrows(IllegalArgumentException.class, () -> require(nullBoolean, "test condition"));
    }

    @Test  
    void demonstrateNpePreventionInCheck() {
        // This would have caused NPE before our fix, now it throws IllegalStateException
        Boolean nullBoolean = null;
        assertThrows(IllegalStateException.class, () -> check(nullBoolean, "test condition"));
    }

    @Test
    void demonstrateNpePreventionInEnsure() {
        // This would have caused NPE before our fix, now it throws IllegalStateException
        Boolean nullBoolean = null;
        assertThrows(IllegalStateException.class, () -> ensure(nullBoolean, "test condition"));
    }

    @Test
    void demonstrateNpePreventionInRequireWithSupplier() {
        // This would have caused NPE before our fix, now it throws IllegalArgumentException
        Boolean nullBoolean = null;
        assertThrows(IllegalArgumentException.class, () -> require(nullBoolean, () -> "test condition"));
    }

    @Test  
    void demonstrateNpePreventionInCheckWithSupplier() {
        // This would have caused NPE before our fix, now it throws IllegalStateException
        Boolean nullBoolean = null;
        assertThrows(IllegalStateException.class, () -> check(nullBoolean, () -> "test condition"));
    }

    @Test
    void demonstrateNpePreventionInEnsureWithSupplier() {
        // This would have caused NPE before our fix, now it throws IllegalStateException
        Boolean nullBoolean = null;
        assertThrows(IllegalStateException.class, () -> ensure(nullBoolean, () -> "test condition"));
    }
}