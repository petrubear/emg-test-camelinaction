package emg.test.camelinaction.cp2.filter;

import emg.test.camelinaction.common.BaseCamelTest;
import emg.test.camelinaction.cp2.cbr.ContentBaseBuilderTest;
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
 * Created by edison on 8/27/16
 */
public class MessageFilterBuilderTest extends BaseCamelTest {
    private final static Logger logger = LogManager.getLogger(ContentBaseBuilderTest.class);

    @Test
    public void testFilter() throws Exception {
        logger.info("CBR Test");
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new MessageFilterBuilder());
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_JMS_CONECTION);
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.start();
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        camelContext.stop();

        assertEquals(true, fileExists(OUT_FILE_XML));
    }

    @Test
    public void testFilterXml() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("./cp2/filter-beans.xml");
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        CamelContext camelContext = (CamelContext) context.getBean("camelContext");
        camelContext.stop();
    }
}
