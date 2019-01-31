package com.github.baifenghe.toolkit.common.constant.enums;

import lombok.Getter;

/**
 * 非法参数枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
public enum IllegalParameterEnum {

    /**
     * 参数校验失败
     */
    PARAMS_CHECK_ERROR(10000, "参数校验失败");


    private Integer code;
    private String msg;

    IllegalParameterEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
