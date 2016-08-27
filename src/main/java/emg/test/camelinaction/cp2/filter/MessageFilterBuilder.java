package emg.test.camelinaction.cp2.filter;

import org.apache.camel.builder.RouteBuilder;

import static emg.test.camelinaction.constants.RoutesConstants.*;

/**
 * Created by edison on 8/27/16
 */
public class MessageFilterBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(URI_INBOX_FILE)
                .choice()
                .when(header("CamelFileName").endsWith(".xml"))
                .filter(xpath("/order[not(@test)]"))
                .log(">>> Processing test file ${header.CamelFileName} ")
                .to(URI_JMS_XML);

        //multicast
        from(URI_JMS_XML)
                .multicast()
                //.parallelProcessing()
                .to(URI_OUTBOX_FILE, URI_DIRECT_XML);
        from(URI_DIRECT_XML)
                .log(">>> Got into directXML ${header.CamelFileName} ")
                .to(URI_DEV_NULL);
    }
}
