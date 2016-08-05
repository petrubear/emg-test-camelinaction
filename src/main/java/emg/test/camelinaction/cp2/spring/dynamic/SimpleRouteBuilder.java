package emg.test.camelinaction.cp2.spring.dynamic;

import emg.test.camelinaction.cp2.spring.SimpleXmlRouteProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static emg.test.camelinaction.constants.RoutesConstants.URI_INBOX_FILE;
import static emg.test.camelinaction.constants.RoutesConstants.URI_OUTBOX_FILE;

/**
 * Created by edison on 8/4/16
 */

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    private SimpleXmlRouteProcessor processor;

    public void setProcessor(SimpleXmlRouteProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void configure() throws Exception {
        from(URI_INBOX_FILE).process(processor).to(URI_OUTBOX_FILE);
    }
}
