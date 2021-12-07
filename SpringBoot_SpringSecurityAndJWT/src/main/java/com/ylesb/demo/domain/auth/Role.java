package com.ylesb.demo.domain.auth;
/**
 * @title: Role
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:40
 */

import lombok.Builder;
import lombok.Data;

/**
 * @className    : Role
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
@Builder
public class Role {
    private Long id;
    private String name;
    private String nameZh;
}