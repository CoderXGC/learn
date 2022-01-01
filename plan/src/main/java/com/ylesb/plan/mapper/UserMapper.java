package com.ylesb.plan.mapper;
/**
 * @title: UserMapper
 * @projectName plan
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/2015:43
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ylesb.plan.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @className    : UserMapper
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/20 15:43]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/20 15:43]
 * @updateRemark : [描述说明本次修改内容] 
 */
//在对应的Mapper上继承基本的类baseMapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD已经编写完成
    //不需要像以前的配置一些xml
}
