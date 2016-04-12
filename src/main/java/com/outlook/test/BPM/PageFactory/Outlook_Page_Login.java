package com.outlook.test.BPM.PageFactory;

import com.outlook.test.BPM.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class Outlook_Page_Login extends CommonPageModel {

    public WebElement Ipt_UserName;
    public WebElement Ipt_PassWord;
    public WebElement Btn_Login;
    public WebElement Ckb_KeepMeLoggedIn;
    public WebElement Txt_PopUserNameError;
    public String Txt_PageTitle;

    public void getOutlookPageLoginElements(WebDriver driver) {

        Ipt_UserName = getPageElementById(driver, By.id("i0116"));
        Ipt_PassWord = getPageElementById(driver, By.id("i0118"));
        Btn_Login = getPageElementById(driver, By.id("idSIButton9"));
        Ckb_KeepMeLoggedIn = getPageElementById(driver, By.id("idChkBx_PWD_KMSI0Pwd"));
        Txt_PopUserNameError = getPageElementById(driver, By.id("usernameError"));
        Txt_PageTitle = driver.getTitle();

    }

    public void cleanLoginPageInputTextArea(WebDriver driver, TestUtilFunctions testUtil){
        testUtil.clearInputs(driver, Ipt_UserName);
        testUtil.clearInputs(driver, Ipt_PassWord);
    }



}
