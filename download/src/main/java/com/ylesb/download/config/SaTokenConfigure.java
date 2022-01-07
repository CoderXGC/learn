package com.ylesb.download.config;
/**
 * @title: SaTokenConfigure
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/710:51
 */

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className    : SaTokenConfigure
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 10:51]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 10:51]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}
