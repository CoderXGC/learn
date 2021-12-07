package com.ylesb.demo.domain.auth;
/**
 * @title: ResponseUserToken
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:40
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className    : ResponseUserToken
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:40]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:40]
 * @updateRemark : [描述说明本次修改内容] 
 */

@Data
@AllArgsConstructor
public class ResponseUserToken {
    private String token;
    private UserDetail userDetail;
}
