package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author zhaoyang
 * @Date 2020/7/21 - 14:21
 */
public class JMSconsumer_topic_persistent {
    private static final String ACTIVEMQ_URL = "tcp://ip:61616";
    private static final String TOPIC_NAME = "topic-zhaoyang";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("***zhaoyang");

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("zhaoyang"); //设置订阅用户

//        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark...");  //持久化主题订阅者


        connection.start(); //设置持久化后开启连接
        Message message = topicSubscriber.receive();
        while (null != message){
            if (message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                System.out.println("***zhaoyang收到持久化消息：" + textMessage.getText());

                message = topicSubscriber.receive(5000L);   //监听5s
            }
        }

        System.in.read();
        session.close();
        connection.close();
    }
}
