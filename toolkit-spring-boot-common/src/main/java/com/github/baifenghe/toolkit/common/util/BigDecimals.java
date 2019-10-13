package com.github.baifenghe.toolkit.common.util;

import com.github.baifenghe.toolkit.common.function.ToBigDecimalFunction;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 * {@link BigDecimal} util
 *
 * @author byference
 * @since 2019-10-08
 */
public class BigDecimals {

    private BigDecimals() {
    }


    /**
     * Accepts a function that extracts an {@link BigDecimal} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param keyExtractor the function used to extract the {@link BigDecimal} sort key
     * @return a comparator that compares by an extracted key
     */
    public static <T> Comparator<T> comparing(ToBigDecimalFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (b1, b2) -> compareTo(keyExtractor.applyAsBigDecimal(b1), keyExtractor.applyAsBigDecimal(b2));
    }


    /**
     * Note: if b1 b2 is null, it means equality.
     *
     * @return -1, 0, or 1 as this {@code BigDecimal} is numerically
     * less than, equal to, or greater than {@code val}.
     */
    public static int compareTo(BigDecimal b1, BigDecimal b2) {
        if (b1 == null && b2 == null) {
            return 0;
        } else if (b1 == null) {
            return -1;
        } else if (b2 == null) {
            return 1;
        }
        return b1.compareTo(b2);
    }


    /**
     * Returns the smaller of two {@code BigDecimal} values
     */
    public static BigDecimal min(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#min is not allowed be null.");
        return b1.compareTo(b2) < 0 ? b1 : b2;
    }


    /**
     * Returns the greater of two {@code BigDecimal} values
     */
    public static BigDecimal max(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#max is not allowed be null.");
        return b1.compareTo(b2) > 0 ? b1 : b2;
    }


    /**
     * Adds two {@code BigDecimal} together
     */
    public static BigDecimal sum(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#sum is not allowed be null.");
        return b1.add(b2);
    }
}
