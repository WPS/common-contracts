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

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <p>This class contains static methods to enforce contracts on strings ("has length" and "has text").</p>
 *
 * <p>There are methods to</p>
 * <ul>
 *     <li>require arguments to meet conditions (preconditions)</li>
 *     <li>check states (invariants)</li>
 *     <li>ensure results to meet conditions (postconditions)</li>
 * </ul>
 */
public class StringContracts {
    /**
     * <p>Requires the {@link String} argument to be not empty and not null.</p>
     *
     * @param argument The string to check
     * @param argumentName The name of the argument
     * @return The checked string
     * @throws IllegalArgumentException if argument is empty or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String requireHasLength(@Nullable String argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.isEmpty()) {
            throw new IllegalArgumentException("Argument " + argumentName + " was empty");
        }
        return argument;
    }


    /**
     * <p>Requires the {@link String} argument to be not blank and not null.</p>
     *
     * @param argument The string to check
     * @param argumentName The name of the argument
     * @return The checked string
     * @throws IllegalArgumentException if argument is blank or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String requireHasText(@Nullable String argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.isBlank()) {
            throw new IllegalArgumentException("Argument " + argumentName + " was blank");
        }
        return argument;
    }

    /**
     * <p>Requires the {@link String} argument to be not null and its length less or equal maxLength.</p>
     *
     * @param argument The string to check
     * @param maxLength Maximum length of argument
     * @param argumentName The name of the argument
     * @return The checked string
     * @throws IllegalArgumentException if argument is null or arguments length &gt; maxLength
     */
    @EnsuresNonNull("#1")
    public static @NonNull String requireMaxLength(@Nullable String argument, int maxLength, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.length() > maxLength) {
            throw new IllegalArgumentException("Length of " + argumentName + " was > " + maxLength);
        }
        return argument;
    }

    /**
     * <p>Checks the state {@link String} to be not empty and not null.</p>
     *
     * @param state The string to check
     * @param stateName The name of the state
     * @return The checked string
     * @throws IllegalStateException if state is empty or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String checkHasLength(@Nullable String state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state.isEmpty()) {
            throw new IllegalStateException("State " + stateName + " was empty");
        }
        return state;
    }

    /**
     * <p>Checks the state {@link String} to be not blank and not null.</p>
     *
     * @param state The string to check
     * @param stateName The name of the state
     * @return The checked string
     * @throws IllegalStateException if state is blank or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String checkHasText(@Nullable String state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state.isBlank()) {
            throw new IllegalStateException("State " + stateName + " was blank");
        }
        return state;
    }

    /**
     * <p>Checks the state {@link String} to be not null and its length less or equal maxLength.</p>
     *
     * @param state The string to check
     * @param maxLength Maximum length of state
     * @param stateName The name of the state
     * @return The checked string
     * @throws IllegalStateException if state is null or states length &gt; maxLength
     */
    @EnsuresNonNull("#1")
    public static @NonNull String checkMaxLength(@Nullable String state, int maxLength, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state.length() > maxLength) {
            throw new IllegalStateException("Length of " + stateName + " was > " + maxLength);
        }
        return state;
    }

    /**
     * <p>Ensures the result {@link String} to be not empty and not null.</p>
     *
     * @param result The string to check
     * @param resultName The name of the result
     * @return The checked collection
     * @throws IllegalStateException if result is empty or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String ensureHasLength(@Nullable String result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.isEmpty()) {
            throw new IllegalStateException("Result " + resultName + " was empty");
        }
        return result;
    }

    /**
     * <p>Ensures the result {@link String} to be not blank and not null.</p>
     *
     * @param result The string to check
     * @param resultName The name of the result
     * @return The checked string
     * @throws IllegalStateException if result is blank or is null
     */
    @EnsuresNonNull("#1")
    public static @NonNull String ensureHasText(@Nullable String result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.isBlank()) {
            throw new IllegalStateException("Result " + resultName + " was blank");
        }
        return result;
    }


    /**
     * <p>Ensures the result {@link String} to be not null and its length less or equal maxLength.</p>
     *
     * @param result The string to check
     * @param maxLength Maximum length of result
     * @param resultName The name of the result
     * @return The checked string
     * @throws IllegalStateException if result is null or results length &gt; maxLength
     */
    @EnsuresNonNull("#1")
    public static @NonNull String ensureMaxLength(@Nullable String result, int maxLength, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.length() > maxLength) {
            throw new IllegalStateException("Length of " + resultName + " was > " + maxLength);
        }
        return result;
    }
}
