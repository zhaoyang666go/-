package zhaoyang.study.MQ.ActiveMQ;

import org.apache.activemq.broker.BrokerService;

/**
 * @author zhaoyang
 * @Date 2020/7/23 - 15:04
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
