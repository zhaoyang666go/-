package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author zhaoyang
 * @Date 2020/7/21 - 14:21
 */
public class JMSconsumer_topic {
    private static final String ACTIVEMQ_URL = "tcp://ip:61616";
    private static final String TOPIC_NAME = "topic-zhaoyang";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageConsumer messageConsumer = session.createConsumer(topic);

        messageConsumer.setMessageListener(message -> {
            if (null != message && message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                System.out.println("***消费者收到topic消息：" + textMessage);
            }
        });

        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
