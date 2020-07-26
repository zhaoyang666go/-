package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.queue.consume;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 20:56
 */
@Component
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws Exception{
        System.out.println("***消费者收到消息: " + textMessage.getText());
    }
}
