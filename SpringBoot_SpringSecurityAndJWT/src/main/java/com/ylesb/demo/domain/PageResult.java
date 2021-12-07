package com.ylesb.demo.domain;
/**
 * @title: PageResult
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:37
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className    : PageResult
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:37]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:37]
 * @updateRemark : [描述说明本次修改内容] 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResult<T> {
    private int page;
    private int rows;
    private int total;
    private T data;
}