package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.topic.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 21:09
 */
@Component
public class Topic_Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000)
    public void produce(){
        jmsMessagingTemplate.convertAndSend(topic,
                "主题消息：" + UUID.randomUUID().toString().substring(0, 6));
    }
}
