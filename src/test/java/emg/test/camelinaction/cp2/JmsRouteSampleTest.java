/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emg.test.camelinaction.cp2;

import emg.test.camelinaction.common.BaseCamelTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author edison
 */
public class JmsRouteSampleTest extends BaseCamelTest {
    private final static Logger logger = LogManager.getLogger(JmsRouteSampleTest.class);

    public JmsRouteSampleTest() {
    }

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

    /**
     * Test of copyFile method, of class FileCopier.
     */
    @Test
    public void testCopyFile() throws Exception {
        logger.info("jmsTest");
        JmsRouteSample.sampleJmsRoute();
        assertEquals(true, fileExists(OUT_FILE_XML));
    }
}
