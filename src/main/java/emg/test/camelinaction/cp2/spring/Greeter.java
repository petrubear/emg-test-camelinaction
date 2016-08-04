package emg.test.camelinaction.cp2.spring;

/**
 * Created by edison on 8/3/16
 */
public interface Greeter {
    default String sayHello() {
        return "hola!!!";
    }
}
