package com.outlook.test.BPM.PageFactory;

import com.outlook.test.BPM.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class Outlook_Page_Dashboard extends CommonPageModel{

    public String Txt_PageTitle;

    public void getOutlookPageDashboardElements(WebDriver driver) {
        Txt_PageTitle = driver.getTitle();
    }


}
