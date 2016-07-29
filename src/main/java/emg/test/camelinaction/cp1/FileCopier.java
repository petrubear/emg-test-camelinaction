/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emg.test.camelinaction.cp1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import static emg.test.camelinaction.constants.RoutesConstants.CAMEL_CONTEXT_SHUTDOWN;
import static emg.test.camelinaction.constants.RoutesConstants.URI_INBOX_FILE;
import static emg.test.camelinaction.constants.RoutesConstants.URI_OUTBOX_FILE;

/**
 * @author edison
 */
public class FileCopier {

    public static void copyFile() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(getRoute());
        context.start();
        Thread.sleep(CAMEL_CONTEXT_SHUTDOWN);
        context.stop();
    }

    private static RouteBuilder getRoute() {
        RouteBuilder builder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(URI_INBOX_FILE).to(URI_OUTBOX_FILE);
            }
        };

        return builder;
    }
}
