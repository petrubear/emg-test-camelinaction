package emg.test.camelinaction.cp2.spring;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by edison on 8/4/16
 */
@Service
public class SimpleXmlRouteProcessor implements Processor {
    private final static Logger log = LogManager.getLogger(SimpleXmlRouteProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("hello from processor!!");
        log.info("reading file: {}", exchange.getIn().getHeader("CamelFileName"));
    }
}
