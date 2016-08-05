package emg.test.camelinaction.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;

/**
 * Created by edison on 7/28/16
 */
public abstract class BaseCamelTest {
    private final static Logger logger = LogManager.getLogger(BaseCamelTest.class);

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cleanOutbox();
    }

    @After
    public void tearDown() {
        cleanOutbox();
    }

    protected void cleanOutbox() {
        logger.info("cleaning outbox");
        final String outFileName = "data/outbox/message1.xml";
        File outFile = new File(outFileName);
        if (outFile.exists()) {
            outFile.delete();
        }
    }
}
