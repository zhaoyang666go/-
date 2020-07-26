package zhaoyang.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import zhaoyang.study.MQ.ActiveMQ.SpirngBoot_ActiveMQ.queue.produce.Queue_Producer;

import javax.annotation.Resource;

/*
* MQ的单元测试类
* */
@SpringBootTest(classes = StudyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class Test_MQ {
    @Resource   //Java的注解，@Autowired是spirng注解
    private Queue_Producer queue_producer;

    @Test
    public void testSend() throws Exception{
        queue_producer.produceMessage();
    }
}
