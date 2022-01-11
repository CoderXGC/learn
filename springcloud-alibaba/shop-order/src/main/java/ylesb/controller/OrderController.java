package ylesb.controller;
/**
 * @title: UserController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:38
 */

import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ylesb.service.OrderService;

import java.util.List;

/**
 * @className    : UserController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:38]
 * @updateRemark : [描述说明本次修改内容] 
 */

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/order/prod/{pid}")
    public Order oder(@PathVariable("pid") Integer pid){
        List<ServiceInstance> instances=discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);

        Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+pid,Product.class);
        Order order = new Order();
        order.setUid(1);
        orderService.createOrder(order);
        return order;
    }
}
