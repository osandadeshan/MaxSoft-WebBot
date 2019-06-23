package com.maxsoft.webbot.common;

import com.maxsoft.webbot.common.wrapper.SeleniumWrapper;
import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.Calendar;

import static com.maxsoft.webbot.util.datastore.DataStores.saveToDataStore;

/**
 * Project Name : MaxSoft-WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 14/03/2019
 * Time         : 17:37
 * Description  :
 **/


public class Base {

    private WebDriver driver = Driver.driver;

    private SeleniumWrapper seleniumWrapperObj = PageFactory.initElements(driver, SeleniumWrapper.class);

    public static final String APPLICATION_ENDPOINT = System.getenv("application_endpoint");
    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public static final String TEST_DATA_FILE_PATH = System.getenv("test_data_excel_file_path");
    private static final String LOCATORS_FILE_PATH = System.getenv("locators_file_path");

    public Base() {
        PageFactory.initElements(driver, this);
    }

    public Boolean isVariableContainsTrue(String variable) {
        switch (variable.toLowerCase()){
            case "y":
                return true;
            case "yes":
                return true;
            case "t":
                return true;
            case "true":
                return true;
            default:
                return false;
        }
    }

    public String getLocatorFilePath() {
        return CURRENT_DIRECTORY + File.separator + LOCATORS_FILE_PATH;
    }

    public String testDataExcelFilePath() {
        return CURRENT_DIRECTORY + File.separator + TEST_DATA_FILE_PATH;
    }

    public void savePropertyValueToDataStore(String dataStoreType, String dataStoreVariableName, String propertyName){
        saveToDataStore(dataStoreType, dataStoreVariableName, System.getenv(propertyName), Boolean.TRUE);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void implicitlyWait(int seconds) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], "+seconds+"000);");
        //driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static String getCurrentEpochTime() {
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public void print(String text) {
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    public void verifyElementIsVisible(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.verifyElementIsVisible(locatorStrategy, webElementLocator);
    }

    public void verifyElementIsNotVisible(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.verifyElementIsNotVisible(locatorStrategy, webElementLocator);
    }

    public void refreshUntilElementVisible(String sheetName, String elementName, int refreshCount) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.refreshUntilElementVisible(locatorStrategy, webElementLocator, refreshCount);
    }

    public void refreshUntilElementNotVisible(String sheetName, String elementName, int refreshCount) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.refreshUntilElementNotVisible(locatorStrategy, webElementLocator, refreshCount);
    }

    public void waitUntilElementVisible(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.waitUntilElementVisible(locatorStrategy, webElementLocator);
    }

    public void waitUntilElementClickable(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.waitUntilElementClickable(locatorStrategy, webElementLocator);
    }

    public void waitUntilElementEnabled(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.waitUntilElementEnabled(locatorStrategy, webElementLocator);
    }

    public void waitUntilElementNotVisible(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.waitUntilElementNotVisible(locatorStrategy, webElementLocator);
    }

    public void replaceWebElementLocatorPlaceholderAndSaveToDataStore(String sheetName, String elementName, String placeholderText, String replacementText,
                                                                         String dataStoreType, String variableName) {
        saveToDataStore(dataStoreType, variableName, seleniumWrapperObj.replaceWebElementLocatorPlaceholder(Excel.getWebElementLocator(sheetName, elementName), placeholderText, replacementText), Boolean.TRUE);
    }

    public void clickElement(String sheetName, String elementName) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.clickElement(locatorStrategy, webElementLocator);
    }

    public void inputText(String sheetName, String elementName, String text) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.inputText(locatorStrategy, webElementLocator, text);
    }

    public void pressKey(String sheetName, String elementName, CharSequence asciiCode) {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        seleniumWrapperObj.pressKey(locatorStrategy, webElementLocator, asciiCode);
    }


}
