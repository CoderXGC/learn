package com.ylesb.demo.domain.auth;
/**
 * @title: User
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:40
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @className    : User
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:40]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:40]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Builder
@Data
public class User {
    @ApiModelProperty(value = "用户名", required = true)
    @Size(min=6, max=20)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    @Size(min=8, max=20)
    private String password;
}
