package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.queue.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 20:21
 */
@Component
@EnableJms  //开启JMS适配注解
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    public Queue queue(){   //新建队列目的地，放入容器中
        return new ActiveMQQueue(myQueue);
    }
}
