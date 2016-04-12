package com.outlook.test.BPM.Utils;

import com.outlook.test.BPM.TestParams.ProjectParams;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class ScreenShotTaker {

    public void takeScreenShot(WebDriver driver) {

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(ProjectParams.getScreenShotsPath() + TestUtilFunctions.getDateTime() + ProjectParams.getScreenShotsFormat()));
        }
        catch (IOException e) {System.out.println(e.getMessage());}
    }

}

