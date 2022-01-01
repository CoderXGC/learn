package com.ylesb.plan.entity;
/**
 * @title: User
 * @projectName plan
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/2015:40
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @className    : User
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/20 15:40]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/20 15:40]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Data
@TableName("user")
public class User {
    @TableField("userid")
    private Integer userId;
    @TableField("username")
    private String userName;
    @TableField("password")
    private String password;
}
