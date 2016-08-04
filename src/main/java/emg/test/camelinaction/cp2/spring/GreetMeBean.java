package emg.test.camelinaction.cp2.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by edison on 8/3/16
 */
public class GreetMeBean {
    private final static Logger log = LogManager.getLogger(GreetMeBean.class);
    private Greeter greeter;

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public void excecute() {
        log.info(greeter.sayHello());
    }
}
