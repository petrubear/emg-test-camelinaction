/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emg.test.camelinaction.cp1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author edison
 */
public class FileCopier {

    public static void copyFile() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(getRoute());
        context.start();
        Thread.sleep(5000);
        context.stop();
    }

    private static RouteBuilder getRoute() {
        RouteBuilder builder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        };

        return builder;
    }
}
