package com.outlook.test.BPM.Utils;

import com.outlook.test.BPM.TestParams.ProjectParams;

/**
 * Created by Marcus_Chang on 2016/4/13.
 */
public class DriverUtilFunctions {
    public DriverUtilFunctions(String driver){

        if (driver != null && driver.equals("Chrome")){
            // set the local Chrome driver path
            System.setProperty("webdriver.chrome.driver", ProjectParams.getChromeDriverLocalPath());
        }
        else if (driver != null && driver.equals("Firefox")){
            // set the local Firefox driver path
            System.setProperty("webdriver.firefox.bin", ProjectParams.getFireFoxDriverLocalPath());
        }
        else if (driver != null && driver.equals("IE")){
            // set the local IE driver path
            System.setProperty("webdriver.ie.driver", ProjectParams.getIEDriverLocalPath());
        }

    }
}
