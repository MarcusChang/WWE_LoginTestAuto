package com.outlook.test.BPM.TestParams;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class BaseTest {

    protected static ApplicationContext appContext;

    @BeforeClass
    public static void setUp() throws Exception {
        try {
            long start = System.currentTimeMillis();
            System.out.println("Loading the Config files...");

            appContext = new ClassPathXmlApplicationContext("spring/spring-config.xml");//Init the spring containers
            System.out.println("Config File loaded finished, Cost：" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
