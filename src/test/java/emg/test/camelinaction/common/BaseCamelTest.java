package emg.test.camelinaction.common;

import org.apache.commons.io.FileUtils;
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
    protected final static String OUT_FILE_XML = "data/outbox/message1.xml";
    protected final static String OUT_FILE_CSV = "data/outbox/message1.csv";
    protected final static String OUT_FILE_CSL = "data/outbox/message1.csl";
    protected final static String OUT_FILE_XSL = "data/outbox/message1.xls";

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
        try {
            logger.info("cleaning outbox");
            final String outputDirectory = "data/outbox/";
            File outDir = new File(outputDirectory);
            FileUtils.cleanDirectory(outDir);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    protected boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
