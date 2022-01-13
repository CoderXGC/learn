package com.ylesb.service;
/**
 * @title: SmsService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1315:39
 */

import com.ylesb.domain.Order;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @className    : SmsService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 15:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 15:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
//消费者组名consumerGroup  topic消费的组名
@RocketMQMessageListener(consumerGroup = "shop-user", topic = "order-topic")
public class SmsService implements RocketMQListener<Order>{
    @Override
    public void onMessage(Order order) {
        //接收到了订单信息，就可以发短信了
    }
}
