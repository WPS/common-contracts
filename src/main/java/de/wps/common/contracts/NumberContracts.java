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
 * <p>This class contains static methods to enforce contracts on numbers (comparisons "less than",
 * "less than or equal to", "greater than" and "greater than or equal to").</p>
 *
 * <p>Every comparison is available for {@code int}, {@code long}, {@code float}, {@code double} and their
 * wrapper types {@link Integer}, {@link Long}, {@link Float} and {@link Double}. For the wrapper types the
 * value is additionally checked to be not null.</p>
 *
 * <p>There are methods to</p>
 * <ul>
 *     <li>require arguments to meet conditions (preconditions)</li>
 *     <li>check states (invariants)</li>
 *     <li>ensure results to meet conditions (postconditions)</li>
 * </ul>
 */
public final class NumberContracts {
    private NumberContracts() {
        // Should not be instantiated
    }

    // ===== less than =====

    /**
     * <p>Requires the argument to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than bound
     */
    public static int requireLessThan(int argument, int bound, @NonNull String argumentName) {
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than bound
     */
    public static int checkLessThan(int state, int bound, @NonNull String stateName) {
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than bound
     */
    public static int ensureLessThan(int result, int bound, @NonNull String resultName) {
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer requireLessThan(@Nullable Integer argument, int bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer checkLessThan(@Nullable Integer state, int bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer ensureLessThan(@Nullable Integer result, int bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than bound
     */
    public static long requireLessThan(long argument, long bound, @NonNull String argumentName) {
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than bound
     */
    public static long checkLessThan(long state, long bound, @NonNull String stateName) {
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than bound
     */
    public static long ensureLessThan(long result, long bound, @NonNull String resultName) {
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long requireLessThan(@Nullable Long argument, long bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long checkLessThan(@Nullable Long state, long bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long ensureLessThan(@Nullable Long result, long bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than bound
     */
    public static float requireLessThan(float argument, float bound, @NonNull String argumentName) {
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than bound
     */
    public static float checkLessThan(float state, float bound, @NonNull String stateName) {
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than bound
     */
    public static float ensureLessThan(float result, float bound, @NonNull String resultName) {
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float requireLessThan(@Nullable Float argument, float bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float checkLessThan(@Nullable Float state, float bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float ensureLessThan(@Nullable Float result, float bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than bound
     */
    public static double requireLessThan(double argument, double bound, @NonNull String argumentName) {
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than bound
     */
    public static double checkLessThan(double state, double bound, @NonNull String stateName) {
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than bound
     */
    public static double ensureLessThan(double result, double bound, @NonNull String resultName) {
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double requireLessThan(@Nullable Double argument, double bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument >= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double checkLessThan(@Nullable Double state, double bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state >= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double ensureLessThan(@Nullable Double result, double bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result >= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than " + bound);
        }
        return result;
    }

    // ===== less than or equal to =====

    /**
     * <p>Requires the argument to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than or equal to bound
     */
    public static int requireLessThanOrEqual(int argument, int bound, @NonNull String argumentName) {
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than or equal to bound
     */
    public static int checkLessThanOrEqual(int state, int bound, @NonNull String stateName) {
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than or equal to bound
     */
    public static int ensureLessThanOrEqual(int result, int bound, @NonNull String resultName) {
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer requireLessThanOrEqual(@Nullable Integer argument, int bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer checkLessThanOrEqual(@Nullable Integer state, int bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer ensureLessThanOrEqual(@Nullable Integer result, int bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than or equal to bound
     */
    public static long requireLessThanOrEqual(long argument, long bound, @NonNull String argumentName) {
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than or equal to bound
     */
    public static long checkLessThanOrEqual(long state, long bound, @NonNull String stateName) {
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than or equal to bound
     */
    public static long ensureLessThanOrEqual(long result, long bound, @NonNull String resultName) {
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long requireLessThanOrEqual(@Nullable Long argument, long bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long checkLessThanOrEqual(@Nullable Long state, long bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long ensureLessThanOrEqual(@Nullable Long result, long bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than or equal to bound
     */
    public static float requireLessThanOrEqual(float argument, float bound, @NonNull String argumentName) {
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than or equal to bound
     */
    public static float checkLessThanOrEqual(float state, float bound, @NonNull String stateName) {
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than or equal to bound
     */
    public static float ensureLessThanOrEqual(float result, float bound, @NonNull String resultName) {
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float requireLessThanOrEqual(@Nullable Float argument, float bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float checkLessThanOrEqual(@Nullable Float state, float bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float ensureLessThanOrEqual(@Nullable Float result, float bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not less than or equal to bound
     */
    public static double requireLessThanOrEqual(double argument, double bound, @NonNull String argumentName) {
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not less than or equal to bound
     */
    public static double checkLessThanOrEqual(double state, double bound, @NonNull String stateName) {
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not less than or equal to bound
     */
    public static double ensureLessThanOrEqual(double result, double bound, @NonNull String resultName) {
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive upper bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double requireLessThanOrEqual(@Nullable Double argument, double bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument > bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not less than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive upper bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double checkLessThanOrEqual(@Nullable Double state, double bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state > bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not less than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be less than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive upper bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not less than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double ensureLessThanOrEqual(@Nullable Double result, double bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result > bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not less than or equal to " + bound);
        }
        return result;
    }

    // ===== greater than =====

    /**
     * <p>Requires the argument to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than bound
     */
    public static int requireGreaterThan(int argument, int bound, @NonNull String argumentName) {
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than bound
     */
    public static int checkGreaterThan(int state, int bound, @NonNull String stateName) {
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than bound
     */
    public static int ensureGreaterThan(int result, int bound, @NonNull String resultName) {
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer requireGreaterThan(@Nullable Integer argument, int bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer checkGreaterThan(@Nullable Integer state, int bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer ensureGreaterThan(@Nullable Integer result, int bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than bound
     */
    public static long requireGreaterThan(long argument, long bound, @NonNull String argumentName) {
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than bound
     */
    public static long checkGreaterThan(long state, long bound, @NonNull String stateName) {
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than bound
     */
    public static long ensureGreaterThan(long result, long bound, @NonNull String resultName) {
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long requireGreaterThan(@Nullable Long argument, long bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long checkGreaterThan(@Nullable Long state, long bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long ensureGreaterThan(@Nullable Long result, long bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than bound
     */
    public static float requireGreaterThan(float argument, float bound, @NonNull String argumentName) {
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than bound
     */
    public static float checkGreaterThan(float state, float bound, @NonNull String stateName) {
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than bound
     */
    public static float ensureGreaterThan(float result, float bound, @NonNull String resultName) {
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float requireGreaterThan(@Nullable Float argument, float bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float checkGreaterThan(@Nullable Float state, float bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float ensureGreaterThan(@Nullable Float result, float bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than bound
     */
    public static double requireGreaterThan(double argument, double bound, @NonNull String argumentName) {
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than bound
     */
    public static double checkGreaterThan(double state, double bound, @NonNull String stateName) {
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than bound
     */
    public static double ensureGreaterThan(double result, double bound, @NonNull String resultName) {
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The exclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double requireGreaterThan(@Nullable Double argument, double bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument <= bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The exclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double checkGreaterThan(@Nullable Double state, double bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state <= bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The exclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double ensureGreaterThan(@Nullable Double result, double bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result <= bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than " + bound);
        }
        return result;
    }

    // ===== greater than or equal to =====

    /**
     * <p>Requires the argument to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than or equal to bound
     */
    public static int requireGreaterThanOrEqual(int argument, int bound, @NonNull String argumentName) {
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than or equal to bound
     */
    public static int checkGreaterThanOrEqual(int state, int bound, @NonNull String stateName) {
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than or equal to bound
     */
    public static int ensureGreaterThanOrEqual(int result, int bound, @NonNull String resultName) {
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer requireGreaterThanOrEqual(@Nullable Integer argument, int bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer checkGreaterThanOrEqual(@Nullable Integer state, int bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Integer ensureGreaterThanOrEqual(@Nullable Integer result, int bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than or equal to bound
     */
    public static long requireGreaterThanOrEqual(long argument, long bound, @NonNull String argumentName) {
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than or equal to bound
     */
    public static long checkGreaterThanOrEqual(long state, long bound, @NonNull String stateName) {
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than or equal to bound
     */
    public static long ensureGreaterThanOrEqual(long result, long bound, @NonNull String resultName) {
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long requireGreaterThanOrEqual(@Nullable Long argument, long bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long checkGreaterThanOrEqual(@Nullable Long state, long bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Long ensureGreaterThanOrEqual(@Nullable Long result, long bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than or equal to bound
     */
    public static float requireGreaterThanOrEqual(float argument, float bound, @NonNull String argumentName) {
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than or equal to bound
     */
    public static float checkGreaterThanOrEqual(float state, float bound, @NonNull String stateName) {
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than or equal to bound
     */
    public static float ensureGreaterThanOrEqual(float result, float bound, @NonNull String resultName) {
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float requireGreaterThanOrEqual(@Nullable Float argument, float bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float checkGreaterThanOrEqual(@Nullable Float state, float bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Float ensureGreaterThanOrEqual(@Nullable Float result, float bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is not greater than or equal to bound
     */
    public static double requireGreaterThanOrEqual(double argument, double bound, @NonNull String argumentName) {
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is not greater than or equal to bound
     */
    public static double checkGreaterThanOrEqual(double state, double bound, @NonNull String stateName) {
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is not greater than or equal to bound
     */
    public static double ensureGreaterThanOrEqual(double result, double bound, @NonNull String resultName) {
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }

    /**
     * <p>Requires the argument to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param argument The value to check
     * @param bound The inclusive lower bound
     * @param argumentName The name of the argument
     * @return The checked value
     * @throws IllegalArgumentException if argument is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double requireGreaterThanOrEqual(@Nullable Double argument, double bound, @NonNull String argumentName) {
        if(argument == null) {
            throw new IllegalArgumentException("Argument " + argumentName + " was null");
        }
        if(argument < bound) {
            throw new IllegalArgumentException("Argument " + argumentName + " (" + argument + ") was not greater than or equal to " + bound);
        }
        return argument;
    }

    /**
     * <p>Checks the state to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param state The value to check
     * @param bound The inclusive lower bound
     * @param stateName The name of the state
     * @return The checked value
     * @throws IllegalStateException if state is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double checkGreaterThanOrEqual(@Nullable Double state, double bound, @NonNull String stateName) {
        if(state == null) {
            throw new IllegalStateException("State " + stateName + " was null");
        }
        if(state < bound) {
            throw new IllegalStateException("State " + stateName + " (" + state + ") was not greater than or equal to " + bound);
        }
        return state;
    }

    /**
     * <p>Ensures the result to be not null and to be greater than or equal to {@code bound}.</p>
     *
     * @param result The value to check
     * @param bound The inclusive lower bound
     * @param resultName The name of the result
     * @return The checked value
     * @throws IllegalStateException if result is null or is not greater than or equal to bound
     */
    @EnsuresNonNull("#1")
    public static @NonNull Double ensureGreaterThanOrEqual(@Nullable Double result, double bound, @NonNull String resultName) {
        if(result == null) {
            throw new IllegalStateException("Result " + resultName + " was null");
        }
        if(result < bound) {
            throw new IllegalStateException("Result " + resultName + " (" + result + ") was not greater than or equal to " + bound);
        }
        return result;
    }
}
