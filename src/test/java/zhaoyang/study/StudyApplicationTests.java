package zhaoyang.study;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTests {
    Logger logger = LoggerFactory.getLogger(this.getClass());   //日志记录器

    @Test
    void contextLoads() {
    }

    @Test
    void testDefaultLog() { //测试SpringBoot默认日志

        /*
        * 日志级别
        *   由低到高：trace > debug > info > warn > error
        * 通过调整日志级别，可以只记录等于或高于该日志的信息
        * */
        logger.trace("这是跟踪轨迹日志...trace");
        logger.debug("这是调试日志...debug");
        logger.info("这是自定义信息日志...info");    //SpinrgBoot日志默认info级别，低于这个级别的日志信息不会被记录
        logger.warn("这是警告日志...warn");
        logger.error("这是错误日志...error");
    }

}
