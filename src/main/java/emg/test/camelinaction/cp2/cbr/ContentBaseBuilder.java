package emg.test.camelinaction.cp2.cbr;

import org.apache.camel.builder.RouteBuilder;

import static emg.test.camelinaction.constants.RoutesConstants.*;

/**
 * Created by edison on 8/13/16
 */
public class ContentBaseBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from(URI_INBOX_FILE).to(URI_JMS_INFILE);
        from(URI_JMS_INFILE)
                .choice()
                .when(header("CamelFileName").endsWith(".xml")).to(URI_JMS_XML)
                .when(header("CamelFileName").endsWith(".csv")).to(URI_JMS_CSV);
        from(URI_JMS_XML).log("receive XML file: ${header.CamelFileName}").to(URI_OUTBOX_FILE);
        from(URI_JMS_CSV).log("receive CSV file: ${header.CamelFileName}").to(URI_OUTBOX_FILE);
    }
}
