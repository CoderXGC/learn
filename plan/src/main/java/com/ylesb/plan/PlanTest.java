package com.ylesb.plan;
/**
 * @title: PlanTest
 * @projectName plan
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/2016:05
 */

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.ylesb.plan.mapper.UserMapper;
import com.ylesb.plan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
/**
 * @className    : PlanTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/20 16:05]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/20 16:05]
 * @updateRemark : [描述说明本次修改内容] 
 */
@MybatisPlusTest
public class PlanTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testInsert() {
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
        user.setUserId(10001);
        user.setUserName("徐广超");
        user.setPassword("123456");
        userMapper.insert(user);
    }
}
