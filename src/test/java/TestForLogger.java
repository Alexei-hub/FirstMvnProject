

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestForLogger {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void test1() {
        logger.trace("the built-in TRACE level");
        logger.debug("the built-in DEBUG level");
        logger.info("the built-in INFO level");
        logger.warn("the built-in WARN level");
        logger.error("the built-in ERROR level");
        logger.fatal("the built-in FATAL level");
    }
}

