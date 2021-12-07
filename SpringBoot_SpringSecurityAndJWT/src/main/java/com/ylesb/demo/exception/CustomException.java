package com.ylesb.demo.exception;
/**
 * @title: CustomException
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:41
 */

import com.ylesb.demo.domain.ResultJson;
import lombok.Getter;

/**
 * @className    : CustomException
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:41]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:41]
 * @updateRemark : [描述说明本次修改内容] 
 */

@Getter
public class CustomException extends RuntimeException{
    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}

