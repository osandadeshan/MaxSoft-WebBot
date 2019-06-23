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

    // Maximize the current driver instance
    public static void maximizeDriver(){
        driver.manage().window().maximize();
    }

    // Close the current driver instance
    public static void closeDriver(){
        driver.close();
    }

    // Initialize a driver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the driver
    @BeforeSuite
    public static void initializeDriver(){
        driver = DriverFactory.getDriver();
        maximizeDriver();
        driver.get(APPLICATION_ENDPOINT);
    }

    // Close all the driver instances
    @AfterSuite
    public static void closeAllDrivers(){
        if(driver != null) {
            driver.quit();
        }
    }


}
