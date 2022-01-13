package com.ylesb.service.Impl;
/**
 * @title: UserServiceImpl
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:39
 */

import com.ylesb.domain.Order;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.ylesb.dao.OrderDao;
import com.ylesb.service.OrderService;

/**
 * @className    : UserServiceImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }


}
