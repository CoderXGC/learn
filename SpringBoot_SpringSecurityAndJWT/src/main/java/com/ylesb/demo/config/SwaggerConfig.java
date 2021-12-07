package com.ylesb.demo.config;
/**
 * @title: SwaggerConfig
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:35
 */

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className    : SwaggerConfig
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:35]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:35]
 * @updateRemark : [描述说明本次修改内容] 
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private Contact contact = new Contact("Joetao","localhost:8080/swagger-ui.html", "cutesimba@163.com");

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台接口 v1.0")
                .description("平台接口")
                .contact(contact)
                .version("1.0")
                .build();
    }
}

