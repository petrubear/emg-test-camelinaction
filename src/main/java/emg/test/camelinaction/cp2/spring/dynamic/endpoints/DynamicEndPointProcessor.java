package emg.test.camelinaction.cp2.spring.dynamic.endpoints;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by edison on 8/9/16
 */
public class DynamicEndPointProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("queueDest", "customerQueue_");
    }
}
