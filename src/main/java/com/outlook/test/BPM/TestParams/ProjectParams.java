package com.outlook.test.BPM.TestParams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;
import org.junit.BeforeClass;

/**
 * Created by Marcus_Chang on 2016/4/13.
 * This java file is used to store all const params for all test projects
 */
public class ProjectParams implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ProjectParams.class);

    private static Properties propertiesFactoryBean;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setPropertiesFactoryBean((Properties) applicationContext.getBean("propertiesFactoryBean"));
    }

    public static void setPropertiesFactoryBean(Properties propertiesFactoryBean) {
        ProjectParams.propertiesFactoryBean = propertiesFactoryBean;
    }

    public static Properties getPropertiesFactoryBean() {
        return propertiesFactoryBean;
    }

    public static String getChromeDriverLocalPath() {
        return propertiesFactoryBean.get("ChromeDriverLocalPath").toString().trim();
    }

    public static String getFireFoxDriverLocalPath() {
        return propertiesFactoryBean.get("FireFoxDriverLocalPath").toString().trim();
    }

    public static String getIEDriverLocalPath() {
        return propertiesFactoryBean.get("IEDriverLocalPath").toString().trim();
    }

    public static String getExtentReportsPath() {
        return propertiesFactoryBean.get("ExtentReportsPath").toString().trim();
    }

    public static String getScreenShotsPath() {
        return propertiesFactoryBean.get("ScreenShotsPath").toString().trim();
    }

    public static String getScreenShotsFormat() {
        return propertiesFactoryBean.get("ScreenShotsFormat").toString().trim();
    }

    public static String getOutlookURL() {
        return propertiesFactoryBean.get("OutlookURL").toString().trim();
    }

    public static String getLoginUserName_Valid() {
        return propertiesFactoryBean.get("LoginUserName_Valid").toString().trim();
    }

    public static String getLoginUserPass_Valid() {
        return propertiesFactoryBean.get("LoginUserPass_Valid").toString().trim();
    }

    public static String getLoginUserName_Invalid() {
        return propertiesFactoryBean.get("LoginUserName_Invalid").toString().trim();
    }

    public static String getLoginUserPass_Invalid() {
        return propertiesFactoryBean.get("LoginUserPass_Invalid").toString().trim();
    }



    public static String getTestCase_Outlook_Login_Valid_On_Chrome_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Valid_On_Chrome_LayOut").toString().trim();
    }

    public static String getTestCase_Outlook_Login_Valid_On_Firefox_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Valid_On_Firefox_LayOut").toString().trim();
    }

    public static String getTestCase_Outlook_Login_Valid_On_IE_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Valid_On_IE_LayOut").toString().trim();
    }


    public static String getTestCase_Outlook_Login_Invalid_On_Chrome_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Invalid_On_Chrome_LayOut").toString().trim();
    }

    public static String getTestCase_Outlook_Login_Invalid_On_Firefox_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Invalid_On_Firefox_LayOut").toString().trim();
    }

    public static String getTestCase_Outlook_Login_Invalid_On_IE_LayOut() {
        return propertiesFactoryBean.get("TestCase_Outlook_Login_Invalid_On_IE_LayOut").toString().trim();
    }


    public static String getWaitElementTime() {
        return propertiesFactoryBean.get("WaitElementTime").toString().trim();
    }

    public static String getMySqlAddress() {
        return propertiesFactoryBean.get("MySqlAddress").toString().trim();
    }

    public static String getMySqlDbClass() {
        return propertiesFactoryBean.get("MySqlDbClass").toString().trim();
    }

    public static String getMySqlUserName() {
        return propertiesFactoryBean.get("MySqlUserName").toString().trim();
    }

    public static String getMySqlUserPass() {
        return propertiesFactoryBean.get("MySqlUserPass").toString().trim();
    }


}


