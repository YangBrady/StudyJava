package me.yangjun.modules.frame.log.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mooejun
 * @since 2019/05/07
 */
public class TestLog {
    final static Logger logger = LoggerFactory.getLogger(TestLog.class);

    @Test
    public void testDemo(){
        logger.info("打出日志");
    }
}
