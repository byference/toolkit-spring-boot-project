package com.github.baifenghe.toolkit.common.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;


/**
 * @author bfh
 * @since 1.0.0
 */
public class ResponseHelper {

    private ResponseHelper() {}

    public static ResponseHelper.BodyBuilder status(HttpStatus status) {
        Assert.notNull(status, "HttpStatus must not be null");
        return new ResponseHelper.DefaultBuilder(status);
    }

    public static ResponseHelper.BodyBuilder status(int status) {
        return new ResponseHelper.DefaultBuilder(HttpStatus.valueOf(status));
    }

    public static ResponseHelper.BodyBuilder ok() {
        return status(HttpStatus.OK);
    }

    public interface BodyBuilder {

        /**
         * 封装：错误返回body
         *
         * @param code 错误码
         * @param message 错误信息
         * @return @{link ResponseEntity}
         */
        ResponseEntity body(Integer code, String message);

        /**
         * 封装：成功返回body
         *
         * @param data 数据
         * @return @{link ResponseEntity}
         */
        ResponseEntity body(Object data);

        /**
         * 封装：构造一个空的返回body
         *
         * @return @{link ResponseEntity}
         */
        ResponseEntity build();
    }

    private static class DefaultBuilder implements BodyBuilder {

        private final HttpStatus statusCode;

        private final HttpHeaders headers = new HttpHeaders();

        DefaultBuilder(HttpStatus statusCode) {
            this.statusCode = statusCode;
        }

        @Override
        public ResponseEntity body(Integer code, String message) {

            Result result = Result.builder().code(code).message(message).build();
            return new ResponseEntity<>(result, this.headers, this.statusCode);
        }

        @Override
        public ResponseEntity body(Object data) {

            return new ResponseEntity<>(data, this.headers, this.statusCode);
        }

        @Override
        public ResponseEntity build() {

            return new ResponseEntity<>(null, this.headers, this.statusCode);
        }

    }

    @Builder
    @Getter
    private static class Result<T> {

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

    }

}
