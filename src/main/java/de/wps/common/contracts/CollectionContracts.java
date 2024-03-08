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

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * <p>This class contains static methods to enforce contracts on collections ("not empty" and "not null").</p>
 *
 * <p>There are methods to</p>
 * <ul>
 *     <li>require arguments to meet conditions (preconditions)</li>
 *     <li>check states (invariants)</li>
 *     <li>ensure results to meet conditions (postconditions)</li>
 * </ul>
 */
public class CollectionContracts {
    /**
     * <p>Requires the {@link Collection} argument to be not empty and not null.</p>
     *
     * @param argument The collection to check
     * @param argumentName The name of the argument
     * @return The checked collection
     * @throws IllegalArgumentException if argument is empty or is null
     * @param <T> Type of the collection
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Collection<?>> @NonNull T requireNotEmpty(T argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.isEmpty()) {
            throw new IllegalArgumentException("Argument " + argumentName + " was empty");
        }
        return argument;
    }

    /**
     * <p>Requires the state {@link Collection} to be not empty and not null.</p>
     *
     * @param state The collection to check
     * @param stateName The name of the state
     * @return The checked collection
     * @throws IllegalStateException if state is empty or is null
     * @param <T> Type of the collection
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Collection<?>> @NonNull T checkNotEmpty(T state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state.isEmpty()) {
            throw new IllegalStateException("State " + stateName + " was empty");
        }
        return state;
    }

    /**
     * <p>Requires the result {@link Collection} to be not empty and not null.</p>
     *
     * @param result The collection to check
     * @param resultName The name of the result
     * @return The checked collection
     * @throws IllegalStateException if result is empty or is null
     * @param <T> Type of the collection
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Collection<?>> @NonNull T ensureNotEmpty(T result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.isEmpty()) {
            throw new IllegalStateException("Result " + resultName + " was empty");
        }
        return result;
    }

    /**
     * <p>Requires the {@link Map} argument to be not empty and not null.</p>
     *
     * @param argument The map to check
     * @param argumentName The name of the argument
     * @return The checked map
     * @throws IllegalArgumentException if argument is empty or is null
     * @param <T> Type of the map
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Map<?, ?>> @NonNull T requireNotEmpty(T argument, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument.isEmpty()) {
            throw new IllegalArgumentException("Argument " + argumentName + " was empty");
        }
        return argument;
    }

    /**
     * <p>Requires the state {@link Map} to be not empty and not null.</p>
     *
     * @param state The map to check
     * @param stateName The name of the state
     * @return The checked map
     * @throws IllegalStateException if state is empty or is null
     * @param <T> Type of the map
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Map<?, ?>> @NonNull T checkNotEmpty(T state, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state.isEmpty()) {
            throw new IllegalStateException("State " + stateName + " was empty");
        }
        return state;
    }

    /**
     * <p>Requires the result {@link Map} to be not empty and not null.</p>
     *
     * @param result The map to check
     * @param resultName The name of the result
     * @return The checked map
     * @throws IllegalStateException if result is empty or is null
     * @param <T> Type of the map
     */
    /* @EnsuresNonNull("#1") not working see https://github.com/typetools/checker-framework/issues/6478 */
    public static <T extends Map<?, ?>> @NonNull T ensureNotEmpty(T result, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result.isEmpty()) {
            throw new IllegalStateException("Result " + resultName + " was empty");
        }
        return result;
    }
}
