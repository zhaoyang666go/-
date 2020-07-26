package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.queue.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 20:26
 */
@Component
public class Queue_Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void produceMessage(){
        jmsMessagingTemplate.convertAndSend(queue,
                "***" + UUID.randomUUID().toString().substring(0, 6));
    }

    //间隔3s定时投递
    @Scheduled(fixedDelay = 3000)   //每3s调用一次该方法
    public void produceMessageScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,
                "***Scheduled" + UUID.randomUUID().toString().substring(0, 6));
        System.out.println("***produceMessageScheduled send successfully");
    }
}
