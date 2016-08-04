package emg.test.camelinaction.cp2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.ConnectionFactory;

import static emg.test.camelinaction.constants.RoutesConstants.*;


public class JmsRouteSample {
    private final static Logger log = LogManager.getLogger(JmsRouteSample.class);

    public static void sampleJmsRoute() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_JMS_CONECTION);
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(URI_INBOX_FILE).process((exchange) -> {
                    log.info("/****************hello processor****************/");
                }).to(URI_JMS_INFILE);
            }
        });

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(URI_JMS_INFILE).to(URI_OUTBOX_FILE);
            }
        });

        camelContext.start();
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        camelContext.stop();
    }
}
