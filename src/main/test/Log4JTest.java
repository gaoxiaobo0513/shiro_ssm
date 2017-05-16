import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mr_Gao on 2017/5/16.
 */
public class Log4JTest {

    @Test
    public void log4jTest(){
        Logger log= LoggerFactory.getLogger(Log4JTest.class);
        log.info("log4f正常运行了！");

    }
}
