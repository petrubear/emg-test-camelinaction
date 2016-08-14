package emg.test.camelinaction.cp2.spring.dynamic.endpoints;

import emg.test.camelinaction.common.BaseCamelTest;
import org.apache.camel.CamelContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import static emg.test.camelinaction.constants.RoutesConstants.CAMEL_CONTEXT_SHUTDOWN;
import static org.junit.Assert.assertEquals;

/**
 * Created by edison on 8/9/16
 */
public class DynamicEndPointProcessorTest extends BaseCamelTest {
    @Test
    public void dynamicRouteTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-dynamic-endpoint.xml");
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        CamelContext camelContext = (CamelContext) context.getBean("camelContext");
        camelContext.stop();

        assertEquals(true, fileExists(OUT_FILE_XML));
    }
}