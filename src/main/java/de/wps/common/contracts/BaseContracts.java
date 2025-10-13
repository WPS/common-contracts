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

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.optional.qual.EnsuresPresent;

/**
 * <p>This class contains static methods to enforce base contracts ("not null" and "is true").</p>
 *
 * <p>There are methods to</p>
 * <ul>
 *     <li>require arguments to meet conditions (preconditions)</li>
 *     <li>check states (invariants)</li>
 *     <li>ensure results to meet conditions (postconditions)</li>
 * </ul>
 */
public final class BaseContracts {
    private BaseContracts() {
        // Should not be instantiated
    }

    /**
     * <p>Requires the argument to be not null.</p>
     *
     * @param argument The argument to check
     * @param argumentName The name of the argument
     * @return The checked argument
     * @throws IllegalArgumentException if argument is null
     * @param <T> Class of the argument to check
     */
    @EnsuresNonNull("#1")
    public static <T> @NonNull T requireNotNull(@Nullable T argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        return argument;
    }

    /**
     * <p>Requires the argument to be present (and not to be null).</p>
     *
     * @param argument An {@link Optional} as argument to check
     * @param argumentName The name of the argument
     * @return The value of the checked argument Optional
     * @throws IllegalArgumentException if argument is empty or null
     * @param <T> Class of the argument to check
     */
    @EnsuresNonNull("#1")
    @EnsuresPresent("#1")
    public static <T> @NonNull T requirePresent(@SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<T> argument, @NonNull String argumentName) {
        //noinspection OptionalAssignedToNull
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.isPresent()) {
            return argument.get();
        } else {
            throw new IllegalArgumentException("Argument " + argumentName + " was empty");
        }
    }

    /**
     * <p>Requires an argument to meet the condition.</p>
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
     * <p>Requires an argument to meet the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalArgumentException if condition is false or null
     */
    public static void require(@Nullable Boolean condition, @NonNull String conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalArgumentException("Argument did not meet condition: " + conditionDescription);
        }
    }

    /**
     * <p>Requires an argument to meet the condition.</p>
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
     * <p>Requires an argument to meet the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalArgumentException if condition is false or null
     */
    public static void require(@Nullable Boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalArgumentException("Argument did not meet condition: " + conditionDescription.get());
        }
    }

    /**
     * <p>Checks that a state object is not null.</p>
     *
     * @param state The state object to check
     * @param stateName The name of the state object
     * @return The checked argument
     * @throws IllegalStateException if state object is null
     * @param <T> Class of the state object to check
     */
    @EnsuresNonNull("#1")
    public static <T> @NonNull T checkNotNull(@Nullable T state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State object " + stateName + " was null");
        }
        return state;
    }

    /**
     * <p>Requires the state to be present (and not to be null).</p>
     *
     * @param state An {@link Optional} as state to check
     * @param stateName The name of the state
     * @return The value of the checked state Optional
     * @throws IllegalStateException if state is empty or null
     * @param <T> Class of the state to check
     */
    @EnsuresNonNull("#1")
    @EnsuresPresent("#1")
    public static <T> @NonNull T checkPresent(@SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<T> state, @NonNull String stateName) {
        //noinspection OptionalAssignedToNull
        if(state == null) {
            throw new IllegalStateException("State object " + stateName + " was null");
        }
        if(state.isPresent()) {
            return state.get();
        } else {
            throw new IllegalStateException("State object " + stateName + " was empty");
        }
    }

    /**
     * <p>Checks that a state object meets the condition.</p>
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
     * <p>Checks that a state object meets the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalStateException if condition is false or null
     */
    public static void check(@Nullable Boolean condition, @NonNull String conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalStateException("State did not meet condition: " + conditionDescription);
        }
    }

    /**
     * <p>Checks that a state object meets the condition.</p>
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
     * <p>Checks that a state object meets the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalStateException if condition is false or null
     */
    public static void check(@Nullable Boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalStateException("State did not meet condition: " + conditionDescription.get());
        }
    }

    /**
     * <p>Ensures the argument to be not null.</p>
     *
     * @param result The result object to check
     * @param resultName The name of the result object
     * @return The checked argument
     * @throws IllegalStateException if state object is null
     * @param <T> Class of the state object to check
     */
    @EnsuresNonNull("#1")
    public static <T> @NonNull T ensureNotNull(@Nullable T result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        return result;
    }

    /**
     * <p>Requires the result to be present (and not to be null).</p>
     *
     * @param result An {@link Optional} as result to check
     * @param resultName The name of the result
     * @return The value of the checked result Optional
     * @throws IllegalStateException if result is empty or null
     * @param <T> Class of the result to check
     */
    @EnsuresNonNull("#1")
    @EnsuresPresent("#1")
    public static <T> @NonNull T ensurePresent(@SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<T> result, @NonNull String resultName) {
        //noinspection OptionalAssignedToNull
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new IllegalStateException("Result " + resultName + " was empty");
        }
    }

    /**
     * <p>Ensures that a result object meets the condition.</p>
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
     * <p>Ensures that a result object meets the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A textual description of the condition to check
     * @throws IllegalStateException if condition is false or null
     */
    public static void ensure(@Nullable Boolean condition, @NonNull String conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription);
        }
    }

    /**
     * <p>Ensures that a result object meets the condition.</p>
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
     * <p>Ensures that a result object meets the condition. Accepts a {@link Boolean} and treats null like false.</p>
     *
     * @param condition A condition to check (null is treated as false)
     * @param conditionDescription  A supplier of a textual description of the condition to check
     * @throws IllegalStateException if condition is false or null
     */
    public static void ensure(@Nullable Boolean condition, @NonNull Supplier<String> conditionDescription) {
        if(condition == null || !condition) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription.get());
        }
    }

    /**
     * <p>Ensures that a result object meets the condition of a predicate.</p>
     * Convenience method for single line return: <pre>return ensure(result, r -&gt; predicate, "message")</pre>
     *
     * @param result A result to check
     * @param resultPredicate A predicate to check the result
     * @param conditionDescription  A textual description of the condition to check
     * @param <T> Class of the result object to check
     * @return result if check succeeds
     * @throws IllegalStateException if predicate test is false
     */
    public static <T> T ensure(@Nullable T result, @NonNull Predicate<T> resultPredicate, @NonNull String conditionDescription) {
        if(result == null) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription + ", it was null instead");
        }
        if(!resultPredicate.test(result)) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription);
        }
        return result;
    }

    /**
     * <p>Ensures that a result object meets the condition of a predicate.</p>
     * Convenience method for single line return: <pre>return ensure(result, r -&gt; predicate, () -&gt; "message")</pre>
     *
     * @param result A result to check
     * @param resultPredicate A predicate to check the result
     * @param conditionDescription  A textual description of the condition to check
     * @param <T> Class of the result object to check
     * @return result if check succeeds
     * @throws IllegalStateException if predicate test is false
     */
    public static <T> T ensure(@Nullable T result, @NonNull Predicate<T> resultPredicate, @NonNull Supplier<String> conditionDescription) {
        if(result == null) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription.get() + ", it was null instead");
        }
        if(!resultPredicate.test(result)) {
            throw new IllegalStateException("Result did not meet condition: " + conditionDescription.get());
        }
        return result;
    }
}
