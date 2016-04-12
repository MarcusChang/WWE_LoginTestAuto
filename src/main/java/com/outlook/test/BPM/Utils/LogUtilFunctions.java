package com.outlook.test.BPM.Utils;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

import java.util.Properties;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class LogUtilFunctions {

    public void setLoggerProperties(String testCaseClassName, String layOutPath, String driverLocalPath){

        //Obtain the upper level folder path
        String parentPath = System.getProperty("user.dir");

        Logger logger = Logger.getLogger(testCaseClassName + ".class");
        //BasicConfigurator.configure();

        Properties prop = new Properties();

        prop.setProperty("log4j.rootLogger", "ALL, ChromeTestOutputFile");
        prop.setProperty("log4j.appender.ChromeTestOutputFile", "org.apache.log4j.FileAppender");
        prop.setProperty("log4j.appender.ChromeTestOutputFile.File", parentPath + layOutPath);
        prop.setProperty("log4j.appender.ChromeTestOutputFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.ChromeTestOutputFile.layout.ConversionPattern", "%d{HH:mm:ss,SSS} [%t] %-5p %C{1} : %m%n");

        PropertyConfigurator.configure(prop);

        //logger.setLevel(Level.ALL);
        SimpleLayout Test_Case_layout = new SimpleLayout();
        //HTMLLayout htmlLayout = new HTMLLayout();
        FileAppender Test_Case_appender = null;
        //create the selenium verify | assert methods object
        //SeleneseTestBase seleneseTestBase=new SeleneseTestBase();

        try {
            System.out.println(parentPath);
            System.out.println();
            Test_Case_appender = new FileAppender(Test_Case_layout, parentPath + layOutPath, false);
        } catch (Exception e) {
            logger.fatal("the FileAppender cannot be initialized, please check the output path!");
        }

        logger.addAppender(Test_Case_appender);
        logger.info("-----> Begin to set the driver properties : driver path = " + driverLocalPath + " <-----");

    }
}
