package zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.topic.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author zhaoyang
 * @Date 2020/7/26 - 21:06
 */
@Component
public class ConfigBean {

    @Value("${mytopic}")
    private String myTopic;

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(myTopic);
    }
}
