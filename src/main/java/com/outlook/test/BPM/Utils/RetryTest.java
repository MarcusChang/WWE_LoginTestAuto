package com.outlook.test.BPM.Utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class RetryTest implements TestRule{

    private int retryCount;
    private WebDriver driver;
    private ExtentTest logger;
    private ScreenShotTaker capture;


    public RetryTest(int retryCount, WebDriver driver, ExtentTest logger, ScreenShotTaker capture) {
        this.retryCount = retryCount;
        this.driver = driver;
        this.logger = logger;
        this.capture = capture;
    }

    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;

                // implement retry logic
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        logger.log(LogStatus.ERROR, t.getMessage());
                        System.err.println(description.getDisplayName() + ": run " + (i+1) + " failed");
                    }
                }
                capture.takeScreenShot(driver);
                System.err.println(description.getDisplayName() + ": giving up after " + retryCount + " failures");
                throw caughtThrowable;
            }
        };

    }

}