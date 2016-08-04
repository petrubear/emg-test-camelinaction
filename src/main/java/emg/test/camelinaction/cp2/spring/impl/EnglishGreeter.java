package emg.test.camelinaction.cp2.spring.impl;

import emg.test.camelinaction.cp2.spring.Greeter;

/**
 * Created by edison on 8/3/16
 */
public class EnglishGreeter implements Greeter {
    @Override
    public String sayHello() {
        return "Hello, " + System.getProperty("user.name");
    }
}
