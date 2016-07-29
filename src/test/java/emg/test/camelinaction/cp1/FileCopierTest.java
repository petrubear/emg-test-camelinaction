/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emg.test.camelinaction.cp1;

import emg.test.camelinaction.common.BaseCamelTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author edison
 */
public class FileCopierTest extends BaseCamelTest {
    private final static Logger logger = LogManager.getLogger(FileCopier.class);

    public FileCopierTest() {
    }

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

    /**
     * Test of copyFile method, of class FileCopier.
     */
    @Test
    public void testCopyFile() throws Exception {
        logger.info("copyFile");
        FileCopier.copyFile();
        final String outFileName = "data/outbox/message1.xml";
        File outFile = new File(outFileName);
        assertEquals(true, outFile.exists());

    }


}
