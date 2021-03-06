package com.ylesb.service;
/**
 * @title: ProductService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/129:02
 */

import com.ylesb.domain.Product;
import com.ylesb.service.fallback.ProductServiceFallback;
import com.ylesb.service.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className    : ProductService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/12 9:02]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/12 9:02]
 * @updateRemark : [描述说明本次修改内容] 
 */
@FeignClient(value = "service-product",fallbackFactory = ProductServiceFallbackFactory.class)//value用于指定nacos指定服务
public interface ProductService {
    @RequestMapping("/product/{pid}")//指定请求url部分
     Product findByPid(@PathVariable Integer pid);
}

