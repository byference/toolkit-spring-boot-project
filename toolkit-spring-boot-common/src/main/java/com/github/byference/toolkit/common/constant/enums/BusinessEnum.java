package com.github.byference.toolkit.common.constant.enums;

import com.github.byference.toolkit.common.constant.BusinessEnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum BusinessEnum implements BusinessEnumInterface {

    /**
     * 未知错误
     */
    UN_KNOW_ERROR(-1, "未知错误"),

    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    /**
     * 失败
     */
    ERROR(0, "失败");

    private int code;
    private String desc;


    @Override
    public int code() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }
}
