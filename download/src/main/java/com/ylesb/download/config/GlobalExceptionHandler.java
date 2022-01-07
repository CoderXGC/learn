package com.ylesb.download.config;
/**
 * @title: GlobalExceptionHandler
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/711:30
 */

import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className    : GlobalExceptionHandler
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 11:30]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 11:30]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    public String handlerNotLoginException(NotLoginException nle, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        }
        else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return message;
    }
}
