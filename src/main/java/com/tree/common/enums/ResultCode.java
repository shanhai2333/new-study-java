package com.tree.common.enums;

/**
 * @author shanhai
 * 返回code码
 */

public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILURE(400, "参数错误"),
    TOKEN_EXCEED(401, "未登录"),
    TOKE_NULL(403, "权限不足"),
    NOT_FOUND(404, "未找到该资源"),
    AUTHENTICATION_FAILED(405, "身份验证失败"),
    SERVER_ERROR(500, "服务器内部异常"),
    BAD_REQUEST(502, "请求有误"),
    SYSTEM_MAINTAIN(503, "系统维护中"),
    SERVICE_TIMEOUT(504, "服务请求超时"),
    BAD_CREDENTIALS(4001, "用户名或密码错误"),
    BAD_REGISTRATION_KEY(4002, "注册码错误"),
    LOGIN_USER_NOT_FOUNT(4003, "未找到当前登录用户"),
    USER_LOCKED(4004, "账户已被锁定"),
    USER_DISABLED(4005, "账户已被禁用"),
    ;


    private final Integer code;
    private final String msg;

    private final String template;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.template = "";
    }

    ResultCode(Integer code, String msg, String template) {
        this.code = code;
        this.msg = msg;
        this.template = template;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getTemplate() {
        return this.template;
    }
}