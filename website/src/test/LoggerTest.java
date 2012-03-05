/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author sen
 */
public class LoggerTest {
    Logger logger = Logger.getLogger("loggertest");

    private class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + "|" + record.getMillis() + "|" + record.getMessage() + "\n";
        }
    }

    public LoggerTest() {
        try {
            FileHandler fileHandler = new FileHandler("logtest.log", Integer.MAX_VALUE, 1, true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException ex) {
            Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void logContent(String msg) {
        logger.info(msg);
    }

    public static void main(String[] args) {
        LoggerTest test = new LoggerTest();
        test.logContent("xxxx");
        test.logContent("abc|123".split("|")[0]);
    }
}
