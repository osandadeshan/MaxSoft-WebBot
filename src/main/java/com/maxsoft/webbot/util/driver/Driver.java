package com.maxsoft.webbot.util.driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import static com.maxsoft.webbot.common.Base.APPLICATION_ENDPOINT;

/**
 * Project Name : MaxSoft WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 13/03/2019
 * Time         : 10:30 PM
 * Description  :
 **/


public class Driver {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the driver
    @BeforeSuite
    public void initializeDriver(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(APPLICATION_ENDPOINT);
    }

    // Close the driver instance
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }


}
