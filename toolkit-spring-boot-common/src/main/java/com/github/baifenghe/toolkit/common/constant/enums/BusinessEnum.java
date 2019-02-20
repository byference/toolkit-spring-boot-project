package com.github.baifenghe.toolkit.common.constant.enums;

import lombok.Getter;

/**
 * 业务枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
public enum BusinessEnum {

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

    private Integer code;
    private String msg;

    BusinessEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
