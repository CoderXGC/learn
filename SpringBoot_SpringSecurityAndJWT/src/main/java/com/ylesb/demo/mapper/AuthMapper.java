package com.ylesb.demo.mapper;
/**
 * @title: AuthMapper
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:42
 */

import com.ylesb.demo.domain.auth.Role;
import com.ylesb.demo.domain.auth.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @className    : AuthMapper
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:42]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:42]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Repository
public interface AuthMapper {
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    UserDetail findByUsername(@Param("name") String name);

    /**
     * 创建新用户
     * @param userDetail
     */
    void insert(UserDetail userDetail);

    /**
     * 创建用户角色
     * @param userId
     * @param roleId
     * @return
     */
    int insertRole(@Param("userId") long userId, @Param("roleId") long roleId);

    /**
     * 根据角色id查找角色
     * @param roleId
     * @return
     */
    Role findRoleById(@Param("roleId") long roleId);

    /**
     * 根据用户id查找该用户角色
     * @param userId
     * @return
     */
    Role findRoleByUserId(@Param("userId") long userId);
}

