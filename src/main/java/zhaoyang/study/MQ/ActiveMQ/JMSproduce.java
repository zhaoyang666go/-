package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zhaoyang
 * @Date 2020/7/21 - 9:08
 */
public class JMSproduce {
    private static final String ACTIVEMQ_URL = "tcp://ip:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂，按照指定的url地址，使用默认的用户名密码
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //通过连接工厂获得连接，并启动访问
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建会话
        //两个参数：事务；签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地：队列还是主题
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消息生产者，默认消息生产者传送的消息是持久化的
        MessageProducer messageProducer = session.createProducer(queue);
//        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);   //消息非持久化，服务器宕机，消息丢失
//        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);   //消息持久化，服务器宕机，消息依然存在

        //消息生产者发送消息到目的地队列
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("Message---" + i);
            messageProducer.send(textMessage);
        }

        //释放连接
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("***消息发布到MQ完成");
    }
}
