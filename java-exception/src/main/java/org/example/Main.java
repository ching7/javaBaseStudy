package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenyanan
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        testException();
        logger.info("t");
    }


    public static void testException() {
        try {
            Integer a = null;
            String i = a.toString();
        } catch (Exception e) {
            logger.info("yi chang le:" + e);
            e.printStackTrace();

        }
    }

    private void getEx() throws Exception {
        throw new Exception("error");
    }
}