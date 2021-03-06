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
                .when(header("CamelFileName").regex("^.*(csv|csl)$")).to(URI_JMS_CSV)
                //.when(simple("${header.CamelFileName} ends with '.csv'")).to(URI_JMS_CSV);
                .otherwise().log("Unrecognized File Type: ${header.CamelFileName}").to(URI_DEV_NULL).stop() //stop detiene el proceso para esta opcion de la ruta
                .end()
                //continua el proceso despues del cbr
                .to(URI_JMS_CONTINUE);
        from(URI_JMS_XML).log("receive XML file: ${header.CamelFileName}").to(URI_OUTBOX_FILE);
        from(URI_JMS_CSV).log("receive CSV file: ${header.CamelFileName}").to(URI_OUTBOX_FILE);
        from(URI_JMS_CONTINUE).log("Continue With File: ${header.CamelFileName}").to(URI_DEV_NULL);
    }
}
