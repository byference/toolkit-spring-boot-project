package com.github.baifenghe.tools.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@Setter
public class ResponseInfo<T> {

    private Integer code;

    private String message;

    private T data;

}
