package com.outlook.test.BPM;

import com.outlook.test.BPM.PageFactory.*;
import com.outlook.test.BPM.TestParams.*;
import com.outlook.test.BPM.Utils.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class TestCase_Outlook_Login_Valid_On_Chrome extends BaseTest {

    private static WebDriver chromeDriver;
    private static Outlook_Page_Login OutlookPageLogin;
    private static Outlook_Page_Dashboard OutlookPageDashboard;
    private static ReportsUtils report;
    private static ScreenShotTaker capture;
    private static ExtentTest logger;
    private static TestUtilFunctions testUtil;


    @Rule
    public RetryTest retry = new RetryTest(3, chromeDriver, logger, capture);

    @BeforeClass
    public static void init() {
        //create the testUtilFunctions instance
        testUtil = new TestUtilFunctions();
        //initial DriverUtilFunctions.class，set the driver boot path in its constructor
        new DriverUtilFunctions("Chrome");
        DesiredCapabilities chromeCapabilities = testUtil.setChromeDriverProperties();

        //create a Chrome browser instance
        chromeDriver = new ChromeDriver(chromeCapabilities);
        //Create the ReportsUtils instance
        report = new ReportsUtils();
        //Create the ScreenShotTaker instance
        capture = new ScreenShotTaker();
        //Begin to log the report details
        logger = report.testLogger("TestCase_Outlook_Login_Valid_On_Chrome");
        //initial LogUtilFunctions.class，set the system level info log configuration by create the class instance
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_Outlook_Login_Valid_On_Chrome", ProjectParams.getTestCase_Outlook_Login_Valid_On_Chrome_LayOut(), ProjectParams.getChromeDriverLocalPath());

        OutlookPageLogin = new Outlook_Page_Login();
        OutlookPageDashboard = new Outlook_Page_Dashboard();

        //Maximize the browser window
        OutlookPageLogin.MaxPageWindow(chromeDriver);
    }

    @Test
    public void TestAction_CreateNewPage_QuickCreate() {

        //Action 1 : Open the Outlook login page
        logger.log(LogStatus.INFO, "Begin the test and open the test login page.");
        OutlookPageLogin.OpenTargetURL(chromeDriver, ProjectParams.getOutlookURL());
        //Grab all target web elements on the page : Outlook_Page_Login
        OutlookPageLogin.getOutlookPageLoginElements(chromeDriver);
        //Assert the page title == [登陆]
        Assert.assertTrue(OutlookPageLogin.Txt_PageTitle.equals("登录"));
        logger.log(LogStatus.PASS, "Outlook Login Page Opened!");
        //Input the user name & pass to login
        OutlookPageLogin.cleanLoginPageInputTextArea(chromeDriver, testUtil);
        OutlookPageLogin.Ipt_UserName.sendKeys(ProjectParams.getLoginUserName_1());
        OutlookPageLogin.Ipt_PassWord.sendKeys(ProjectParams.getLoginUserPass_1());
        OutlookPageLogin.Btn_Login.click();

        //Action 2 : verify the login action
        logger.log(LogStatus.INFO, "Login the Outlook Dashboard and prepare to grab target elements on the page.");
        //Grab all target web elements on the page : Outlook_Page_Dashboard
        OutlookPageDashboard.getOutlookPageDashboardElements(chromeDriver);
        //Assert the page title == [Outlook.com - loginUser1]
        Assert.assertTrue(OutlookPageDashboard.Txt_PageTitle.equals("Outlook.com - " + ProjectParams.getLoginUserName_1()));
        logger.log(LogStatus.PASS, "Login Success! Outlook Dashboard Opened. TestAction_Login -> Finished!");

    }


    @AfterClass
    public static void tearDown() {
        report.endTestLogger(logger);
        chromeDriver.quit();
    }


}


