package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zhaoyang
 * @Date 2020/7/21 - 14:13
 */
public class JMSproduce_topic {
    private static final String ACTIVEMQ_URL = "tcp://ip:61616";
    private static final String TOPIC_NAME = "topic-zhaoyang";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);  //目的题——主题
        MessageProducer messageProducer = session.createProducer(topic);
        for (int i = 1; i <= 6; i++) {
            TextMessage textMessage = session.createTextMessage("zhaoyang---" + i);
            messageProducer.send(textMessage);
        }

        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("***zhaoyang发布消息到MQ完成");
    }
}
