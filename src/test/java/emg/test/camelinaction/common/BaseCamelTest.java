package emg.test.camelinaction.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        cleanOutbox();
    }

    @AfterEach
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
