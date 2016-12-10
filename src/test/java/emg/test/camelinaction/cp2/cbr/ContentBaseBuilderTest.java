package emg.test.camelinaction.cp2.cbr;

import emg.test.camelinaction.common.BaseCamelTest;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.ConnectionFactory;

import static emg.test.camelinaction.constants.RoutesConstants.CAMEL_CONTEXT_SHUTDOWN;
import static emg.test.camelinaction.constants.RoutesConstants.DEFAULT_JMS_CONECTION;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by edison on 8/13/16
 */
public class ContentBaseBuilderTest extends BaseCamelTest {
    private final static Logger logger = LogManager.getLogger(ContentBaseBuilderTest.class);

    @Test
    public void testCbr() throws Exception {
        logger.info("CBR Test");
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new ContentBaseBuilder());
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_JMS_CONECTION);
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.start();
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        camelContext.stop();

        assertEquals(true, fileExists(OUT_FILE_XML));
        assertEquals(true, fileExists(OUT_FILE_CSV));
    }

    @Test
    public void testCbrXml() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("./cp2/cbr-beans.xml");
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        CamelContext camelContext = (CamelContext) context.getBean("camelContext");
        camelContext.stop();

        assertEquals(true, fileExists(OUT_FILE_XML));
        assertEquals(true, fileExists(OUT_FILE_CSV));
    }
}
