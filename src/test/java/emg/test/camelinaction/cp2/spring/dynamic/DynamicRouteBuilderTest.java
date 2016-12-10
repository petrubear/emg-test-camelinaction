package emg.test.camelinaction.cp2.spring.dynamic;

import emg.test.camelinaction.common.BaseCamelTest;
import org.apache.camel.CamelContext;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static emg.test.camelinaction.constants.RoutesConstants.CAMEL_CONTEXT_SHUTDOWN;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by edison on 8/4/16
 */
public class DynamicRouteBuilderTest extends BaseCamelTest {
    @Test
    public void dynamicRouteTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp2.xml");
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        CamelContext camelContext = (CamelContext) context.getBean("camelContext");
        camelContext.stop();

        assertEquals(true, fileExists(OUT_FILE_XML));
    }
}
