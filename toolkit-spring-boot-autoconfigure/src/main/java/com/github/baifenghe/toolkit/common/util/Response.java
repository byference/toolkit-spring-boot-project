package com.github.baifenghe.toolkit.common.util;

import lombok.Getter;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 2019/01/31
 */
@Getter
public class Response<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static Response build() {
        return new Response();
    }

    public static <T> Response build(T data) {
        return new Response();
    }

    public Response code(Integer code) {
        this.code = code;
        return this;
    }

    public Response message(String message) {
        this.message = message;
        return this;
    }

    public Response data(T data) {
        this.data = data;
        return this;
    }

}
