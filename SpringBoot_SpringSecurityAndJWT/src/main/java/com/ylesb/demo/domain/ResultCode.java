package com.ylesb.demo.domain;
/**
 * @title: ResultCode
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:38
 */

/**
 * @className    : ResultCode
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:38]
 * @updateRemark : [描述说明本次修改内容] 
 */

public enum ResultCode {
    /*
    请求返回状态码和说明信息
     */
    SUCCESS(200, "成功"),

    BAD_REQUEST(400, "参数或者语法不对"),
    UNAUTHORIZED(401, "认证失败"),
    LOGIN_ERROR(401, "登陆失败，用户名或密码无效"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "请求的资源不存在"),
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    TIME_OUT(408, "请求超时"),

    SERVER_ERROR(500, "服务器内部错误"),
    ;
    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
