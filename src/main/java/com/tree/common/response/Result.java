package com.tree.common.response;

import com.tree.common.enums.ResultCode;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author shanhai
 * 通用返回类
 */
@Getter
public final class Result<T> implements Serializable {

    // 状态码
    private final Integer code;

    // 操作信息
    private final String msg;

    // 返回数据
    private final T data;

    private Result(Builder<T> builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
    }

    public static <T> Result<T> ok() {
        return Result.ok(ResultCode.SUCCESS.getMsg());
    }

    public static <T> Result<T> okAndReturnData(@Nullable T data) {
        return new Builder<T>(ResultCode.SUCCESS.getCode())
                .data(data)
                .build();
    }

    public static <T> Result<T> ok(String message) {
        return new Builder<T>(ResultCode.SUCCESS.getCode())
                .msg(message)
                .build();
    }

    public static <T> Result<T> ok(@Nullable T data) {
        return new Builder<T>(ResultCode.SUCCESS.getCode())
                .data(data)
                .build();
    }

    public static <T> Result<T> ok(String message, @Nullable T data) {
        return new Builder<T>(ResultCode.SUCCESS.getCode())
                .msg(message)
                .data(data)
                .build();
    }

    public static <T> Result<T> okTotal(@Nullable T data, @Nullable Long total) {
        return new Builder<T>(ResultCode.SUCCESS.getCode())
                .data(data)
                .build();
    }

    public static <T> Result<T> failure(String message) {
        return Result.failure(ResultCode.FAILURE.getCode(), message);
    }

    public static <T> Result<T> failure(Integer code, String message) {
        return new Builder<T>(code)
                .msg(message)
                .build();
    }

    public static <T> Result<T> failure(Integer code, String message, T data) {
        return new Builder<T>(code)
                .msg(message)
                .data(data)
                .build();
    }

    public static <T> Result<T> failure(ResultCode status) {
        return new Builder<T>(status.getCode())
                .msg(status.getMsg())
                .build();
    }

    private static class Builder<T> {

        private final Integer code;
        private String msg;
        private T data;

        public Builder(Integer code) {
            this.code = code;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder<T> data(@Nullable T data) {
            this.data = data;
            return this;
        }

        public Result<T> build() {
            return new Result<>(this);
        }

        @Override
        public String toString() {
            return "ResultResponse{" +
                    "code='" + code + '\'' +
                    ", message='" + msg + '\'' +
                    ", result=" + data +
                    '}';
        }
    }
}
