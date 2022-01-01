package com.ylesb.plan.controller;
/**
 * @title: UserController
 * @projectName plan
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/2016:50
 */

import com.ylesb.plan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @className    : UserController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/20 16:50]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/20 16:50]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ResponseBody
    public String login(@RequestParam("userid")String userid,@RequestParam("password")String password){


        return null;
    }
}
