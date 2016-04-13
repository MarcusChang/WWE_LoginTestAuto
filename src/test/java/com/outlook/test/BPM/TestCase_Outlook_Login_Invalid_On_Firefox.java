package com.outlook.test.BPM;

import com.outlook.test.BPM.PageFactory.Outlook_Page_Dashboard;
import com.outlook.test.BPM.PageFactory.Outlook_Page_Login;
import com.outlook.test.BPM.TestParams.BaseTest;
import com.outlook.test.BPM.TestParams.ProjectParams;
import com.outlook.test.BPM.Utils.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Marcus_Chang on 2016/4/14.
 */
public class TestCase_Outlook_Login_Invalid_On_Firefox extends BaseTest {

    private static WebDriver firefoxDriver;
    private static Outlook_Page_Login OutlookPageLogin;
    private static ReportsUtils report;
    private static ScreenShotTaker capture;
    private static ExtentTest logger;
    private static TestUtilFunctions testUtil;


    @Rule
    public RetryTest retry = new RetryTest(3, firefoxDriver, logger, capture);

    @BeforeClass
    public static void init() {
        //create the testUtilFunctions instance
        testUtil = new TestUtilFunctions();
        //initial DriverUtilFunctions.class，set the driver boot path in its constructor
        new DriverUtilFunctions("Firefox");
        DesiredCapabilities firefoxCapabilities = testUtil.setFirefoxDriverProperties();

        //create a Firefox browser instance
        firefoxDriver = new FirefoxDriver(firefoxCapabilities);
        //Create the ReportsUtils instance
        report = new ReportsUtils();
        //Create the ScreenShotTaker instance
        capture = new ScreenShotTaker();
        //Begin to log the report details
        logger = report.testLogger("TestCase_Outlook_Login_Invalid_On_Firefox");
        //initial LogUtilFunctions.class，set the system level info log configuration by create the class instance
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_Outlook_Login_Invalid_On_Firefox", ProjectParams.getTestCase_Outlook_Login_Invalid_On_Firefox_LayOut(), ProjectParams.getFireFoxDriverLocalPath());

        OutlookPageLogin = new Outlook_Page_Login();

        //Maximize the browser window
        OutlookPageLogin.MaxPageWindow(firefoxDriver);
    }

    @Test
    public void TestAction_Outlook_Login_Invalid_On_Firefox() {

        //Action 1 : Open the Outlook login page
        logger.log(LogStatus.INFO, "Begin the test and open the test login page.");
        OutlookPageLogin.OpenTargetURL(firefoxDriver, ProjectParams.getOutlookURL());
        //Grab all target web elements on the page : Outlook_Page_Login
        OutlookPageLogin.getOutlookPageLoginElements(firefoxDriver);
        //Assert the page title == [登陆]
        Assert.assertTrue(OutlookPageLogin.Txt_PageTitle.equals("登录"));
        logger.log(LogStatus.PASS, "Outlook Login Page Opened!");
        //Input the user name & pass to login
        OutlookPageLogin.cleanLoginPageInputTextArea(firefoxDriver, testUtil);
        OutlookPageLogin.Ipt_UserName.sendKeys(ProjectParams.getLoginUserName_Invalid());
        OutlookPageLogin.Ipt_PassWord.sendKeys(ProjectParams.getLoginUserPass_Invalid());
        OutlookPageLogin.Btn_Login.click();

        //Action 2 : verify the login action
        logger.log(LogStatus.INFO, "Login the Outlook Failed and prepare to grab target alert elements on the page.");
        //Grab all target web elements on the page : Outlook.com
        OutlookPageLogin.getOutlookPageLoginElements(firefoxDriver);
        //Assert the Popup alert errors
        Assert.assertTrue(OutlookPageLogin.Txt_PopUserNameError.isDisplayed());
        Assert.assertTrue(OutlookPageLogin.Txt_PopPassWordError.isDisplayed());
        logger.log(LogStatus.FAIL, "Login Failed! Check the Login Username & Password. TestAction_Login -> Finished!");

    }


    @AfterClass
    public static void tearDown() {
        report.endTestLogger(logger);
        firefoxDriver.quit();
    }


}


