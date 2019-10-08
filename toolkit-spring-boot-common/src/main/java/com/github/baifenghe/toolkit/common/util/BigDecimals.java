package com.github.baifenghe.toolkit.common.util;

import org.springframework.util.Assert;

import java.math.BigDecimal;

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
     * 求最小值
     */
    public static BigDecimal min(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#min is not allowed be null.");
        return b1.compareTo(b2) < 0 ? b1 : b2;
    }


    /**
     * 求最大值
     */
    public static BigDecimal max(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#max is not allowed be null.");
        return b1.compareTo(b2) > 0 ? b1 : b2;
    }


    /**
     * 求和
     */
    public static BigDecimal sum(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#sum is not allowed be null.");
        return b1.add(b2);
    }

}
