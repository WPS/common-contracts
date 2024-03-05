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

import java.util.function.Predicate;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * This class contains static methods to enforce base contracts ("not null" and "is true").<br/>
 * There are methods to
 * <ul>
 *     <li>require arguments to meet conditions (preconditions)</li>
 *     <li>check states (invariants)</li>
 *     <li>ensure results to meet conditions (postconditions)</li>
 * </ul>
 *
 */
public final class BaseContracts {
    private BaseContracts() {
        // Should not be instantiated
    }

    /**
     * Requires the argument to be not null.
     *
     * @param argument The argument to check
     * @param argumentName The name of the argument
     * @return The checked argument
     * @throws IllegalArgumentException if argument is null
     * @param <T> Class of the argument to check
     */
    @EnsuresNonNull("#1")
    @NonNull
    public static <T> T requireNotNull(T argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        return argument;
    }

    /**
     * Requires an argument to meet the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalArgumentException if condition is false
     */
    public static void require(boolean condition, @NonNull String conditionDescription) {
        if(!condition) {
            throw new IllegalArgumentException("Argument did not meet condition: " + conditionDescription);
        }
    }

    /**
     * Requires an argument to meet the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalArgumentException if condition is false
     */
    public static void require(boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(!condition) {
            throw new IllegalArgumentException("Argument did not meet condition: " + conditionDescription.get());
        }
    }

    /**
     * Checks that a state object is not null.
     *
     * @param state The state object to check
     * @param stateName The name of the state object
     * @return The checked argument
     * @throws IllegalStateException if state object is null
     * @param <T> Class of the state object to check
     */
    @EnsuresNonNull("#1")
    @NonNull
    public static <T> T checkNotNull(T state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State object " + stateName + " was null");
        }
        return state;
    }

    /**
     * Checks that a state object meets the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalStateException if condition is false
     */
    public static void check(boolean condition, @NonNull String conditionDescription) {
        if(!condition) {
            throw new IllegalStateException("State did not meet condition: " + conditionDescription);
        }
    }

    /**
     *  Checks that a state object meets the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalStateException if condition is false
     */
    public static void check(boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(!condition) {
            throw new IllegalStateException("State did not meet condition: " + conditionDescription.get());
        }
    }

    /**
     * Ensures the argument to be not null.
     *
     * @param result The result object to check
     * @param resultName The name of the result object
     * @return The checked argument
     * @throws IllegalStateException if state object is null
     * @param <T> Class of the state object to check
     */
    @EnsuresNonNull("#1")
    @NonNull
    public static <T> T ensureNotNull(T result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        return result;
    }

    /**
     * Ensures that a result object meets the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalStateException if condition is false
     */
    public static void ensure(boolean condition, @NonNull String conditionDescription) {
        if(!condition) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription);
        }
    }

    /**
     *  Ensures that a result object meets the condition.
     *
     * @param condition A condition to check
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalStateException if condition is false
     */
    public static void ensure(boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(!condition) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription.get());
        }
    }


    /**
     * Ensures that a result object meets the condition of a predicate.<br />
     * Convenience method for single line return: <pre>return ensure(result, r -> predicate, "message")</pre>
     *
     * @param result A result to check
     * @param resultPredicate A predicate to check the result
     * @param conditionDescription  A textual description of the condition to check
     * @return result if check succeeds
     * @throws IllegalStateException if predicate test is false
     */
    public static <T> T ensure(T result, @NonNull Predicate<T> resultPredicate, @NonNull String conditionDescription) {
        if(!resultPredicate.test(result)) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription);
        }
        return result;
    }

    /**
     * Ensures that a result object meets the condition of a predicate.<br/>
     * Convenience method for single line return: <pre>return ensure(result, r -> predicate, () -> "message")</pre>
     *
     * @param result A result to check
     * @param resultPredicate A predicate to check the result
     * @param conditionDescription  A textual description of the condition to check
     *                              @return result if check succeeds
     * @throws IllegalStateException if predicate test is false
     */
    public static <T> T ensure(T result, @NonNull Predicate<T> resultPredicate, @NonNull Supplier<String> conditionDescription) {
        if(!resultPredicate.test(result)) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription.get());
        }
        return result;
    }
}
