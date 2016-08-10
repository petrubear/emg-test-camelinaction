package emg.test.camelinaction.constants;

/**
 * Created by edison on 7/28/16.
 */
public class RoutesConstants {
    public final static String URI_INBOX_FILE = "file:data/inbox?noop=true";
    public final static String URI_OUTBOX_FILE = "file:data/outbox";
    public final static String URI_JMS_INFILE = "jms:queue:incomingFiles";

    public final static String DEFAULT_JMS_CONECTION = "vm://localhost?broker.persistent=false";

    public final static int CAMEL_CONTEXT_SHUTDOWN = 8000;
}
