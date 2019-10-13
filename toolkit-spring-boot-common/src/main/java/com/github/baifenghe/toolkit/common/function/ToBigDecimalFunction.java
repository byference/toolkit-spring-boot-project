package com.github.baifenghe.toolkit.common.function;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Represents a function that produces {@link BigDecimal} result.  This is the
 * {@code BigDecimal}-producing primitive specialization for {@link Function}.
 *
 * @param <T> the type of the input to the function
 * @author byference
 * @since 2019-10-09
 */
@FunctionalInterface
public interface ToBigDecimalFunction<T> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    BigDecimal applyAsBigDecimal(T value);
}
