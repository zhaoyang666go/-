package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.topic.consume;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 21:14
 */
@Component
public class Topic_Consumer {

    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage) throws Exception{
        System.out.println("消费者收到订阅的主题: " + textMessage.getText());
    }
}
