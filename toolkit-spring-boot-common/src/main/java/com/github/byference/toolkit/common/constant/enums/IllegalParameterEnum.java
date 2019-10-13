package com.github.byference.toolkit.common.constant.enums;

import com.github.byference.toolkit.common.constant.BusinessEnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 非法参数枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum IllegalParameterEnum implements BusinessEnumInterface {

    /**
     * 参数校验失败
     */
    PARAMS_CHECK_ERROR(10000, "参数校验失败");


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
