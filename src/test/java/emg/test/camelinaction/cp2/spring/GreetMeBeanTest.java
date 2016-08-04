package emg.test.camelinaction.cp2.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by edison on 8/3/16
 */
public class GreetMeBeanTest {
    @Test
    public void excecute() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        GreetMeBean bean = (GreetMeBean) context.getBean("greeterBean");
        bean.excecute();
    }

}