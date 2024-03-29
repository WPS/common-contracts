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

import static de.wps.common.contracts.CollectionContracts.checkNotEmpty;
import static de.wps.common.contracts.CollectionContracts.ensureNotEmpty;
import static de.wps.common.contracts.CollectionContracts.requireNotEmpty;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CollectionContractsTest {

    @Test
    void requireNotEmpty_collection_default() {
        List<String> argument = List.of("Object");
        List<String> nonEmptyArgument = requireNotEmpty(argument, "argument");
        assertSame(argument, nonEmptyArgument);
    }

    @Test
    void requireNotEmpty_collection_empty() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty(List.of(), "argument"));
        assertEquals("Argument argument was empty", throwable.getMessage());
    }

    @Test
    void requireNotEmpty_collection_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty((Collection<?>) null, "argument"));
        assertEquals("Argument argument was null", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_collection_default() {
        List<Object> state = List.of(new Object());
        List<Object> nonEmptyState = checkNotEmpty(state, "state");
        assertSame(state, nonEmptyState);
    }

    @Test
    void checkNotEmpty_collection_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty(List.of(), "state"));
        assertEquals("State state was empty", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_collection_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty((Collection<?>) null, "state"));
        assertEquals("State state was null", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_collection_default() {
        List<Object> result = List.of(new Object());
        List<Object> nonEmptyResult = ensureNotEmpty(result, "result");
        assertSame(result, nonEmptyResult);
    }

    @Test
    void ensureNotEmpty_collection_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty(List.of(), "result"));
        assertEquals("Result result was empty", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_collection_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty((Collection<?>) null, "result"));
        assertEquals("Result result was null", throwable.getMessage());
    }

    @Test
    void requireNotEmpty_map_default() {
        Map<String, String> argument = Map.of("key", "value");
        Map<String, String> nonEmptyArgument = requireNotEmpty(argument, "argument");
        assertSame(argument, nonEmptyArgument);
    }

    @Test
    void requireNotEmpty_map_empty() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty(Map.of(), "argument"));
        assertEquals("Argument argument was empty", throwable.getMessage());
    }

    @Test
    void requireNotEmpty_map_null() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> requireNotEmpty((Map<?, ?>) null, "argument"));
        assertEquals("Argument argument was null", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_map_default() {
        Map<String, String> state = Map.of("key", "value");
        Map<String, String> nonEmptyState = checkNotEmpty(state, "state");
        assertSame(state, nonEmptyState);
    }

    @Test
    void checkNotEmpty_map_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty(Map.of(), "state"));
        assertEquals("State state was empty", throwable.getMessage());
    }

    @Test
    void checkNotEmpty_map_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> checkNotEmpty((Map<?, ?>) null, "state"));
        assertEquals("State state was null", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_map_default() {
        Map<String, Object> result = Map.of("key", new Object());
        Map<String, Object> nonEmptyResult = ensureNotEmpty(result, "result");
        assertSame(result, nonEmptyResult);
    }

    @Test
    void ensureNotEmpty_map_empty() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty(Map.of(), "result"));
        assertEquals("Result result was empty", throwable.getMessage());
    }

    @Test
    void ensureNotEmpty_map_null() {
        IllegalStateException throwable = assertThrows(IllegalStateException.class, () -> ensureNotEmpty((Map<?, ?>) null, "result"));
        assertEquals("Result result was null", throwable.getMessage());
    }
}