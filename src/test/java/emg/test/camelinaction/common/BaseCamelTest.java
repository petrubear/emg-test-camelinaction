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
