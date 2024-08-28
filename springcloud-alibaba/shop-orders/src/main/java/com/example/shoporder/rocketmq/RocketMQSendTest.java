package com.example.shoporder.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class RocketMQSendTest {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        //4. 创建消息对象，指定主题、标签和消息体
        Message msg = new Message("myTopic", "myTag",
                ("RocketMQ Message").getBytes());
        //5. 发送消息
        SendResult sendResult = producer.send(msg,10000);
        System.out.println(sendResult);
//6. 关闭生产者
        producer.shutdown();

    }
}
