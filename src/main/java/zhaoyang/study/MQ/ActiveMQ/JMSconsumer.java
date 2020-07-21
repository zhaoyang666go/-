package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author zhaoyang
 * @Date 2020/7/21 - 10:00
 */
public class JMSconsumer {
    private static final String ACTIVEMQ_URL = "tcp://ip:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        //消息消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        //receive()——同步阻塞
        activemq_consumer_receive(connection, session, messageConsumer);

        //监听器——异步非阻塞方式
        /*
        * 异步非阻塞方式
        * 消息消费者注册一个消息监听器
        * 队列中有消息后，自动调用监听器的onMessage()
        * */
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("***消息消费者受到消息：" + textMessage);
                }
            }
        });

        System.in.read();   //保证成功连接到ActiveMQ前，程序不关闭

        messageConsumer.close();
        session.commit();
        connection.close();

    }

    private static void activemq_consumer_receive(Connection connection, Session session, MessageConsumer messageConsumer) throws JMSException {
        /*
        * receive()同步阻塞方式
        * 消息消费者在收到消息（或超时）之前，一直阻塞
        * */
        while (true){
            TextMessage textMessage = (TextMessage) messageConsumer.receive();    //一直等待消息出现，不关闭连接
            TextMessage textMessage2 = (TextMessage) messageConsumer.receive(4000L);    //指定时间间隔内收不到消息，断开连接
            if (null != textMessage){
                System.out.println("***消息消费者受到消息：" + textMessage);
            }else {
                break;
            }
        }
    }
}
