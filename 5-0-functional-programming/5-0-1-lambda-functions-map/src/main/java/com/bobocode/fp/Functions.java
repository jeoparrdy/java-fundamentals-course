package com.bobocode.fp;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();
        intFunctionMap.addFunction("increment", i -> i+1);
        intFunctionMap.addFunction("decrement", i -> i-1);
        intFunctionMap.addFunction("square", a -> a*a);
        intFunctionMap.addFunction("abs", b -> Math.abs(b));
        intFunctionMap.addFunction("sgn", b -> Integer.signum(b));

        // todo: add simple functions to the function map (abs, sgn, increment, decrement, square)

        return intFunctionMap;
    }
}
