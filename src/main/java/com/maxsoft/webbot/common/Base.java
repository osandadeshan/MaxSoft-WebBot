package com.maxsoft.webbot.common;

import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Project Name : MaxSoft-WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 14/03/2019
 * Time         : 17:37
 * Description  :
 **/


public class Base extends SeleniumWrapper {

    public Base() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getElement(String sheetName, String elementName) throws IOException {
        switch (Excel.getLocatorStrategy(sheetName, elementName).toLowerCase()) {
            case "id":
                webElement = driver.findElement(By.id(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "xpath":
                webElement = driver.findElement(By.xpath(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "class name":
                webElement = driver.findElement(By.className(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "css selector":
                webElement = driver.findElement(By.cssSelector(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "link text":
                webElement = driver.findElement(By.linkText(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "partial link text":
                webElement = driver.findElement(By.partialLinkText(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "name":
                webElement = driver.findElement(By.name(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            case "tag name":
                webElement = driver.findElement(By.tagName(Excel.getWebElementLocator(sheetName, elementName)));
                return webElement;
            default :
                Assert.fail("Locator strategy is not supported");
        }
        return null;
    }

    public String getLocatorFilePath(){
        return CURRENT_DIRECTORY + File.separator + LOCATORS_FILE_PATH;
    }

    public String testDataExcelFilePath(){
        return CURRENT_DIRECTORY + File.separator + TEST_DATA_FILE_PATH;
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void implicitlyWait(int seconds){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], "+seconds+"000);");
        //driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static String getCurrentEpochTime(){
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public void print(String text){
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    public void isElementVisible(String sheetName, String elementName) throws IOException {
        Assert.assertTrue(getElement(sheetName, elementName).isDisplayed());
    }

    public void isElementNotVisible(String sheetName, String elementName) throws IOException {
        try {
            Assert.assertFalse(getElement(sheetName, elementName).isDisplayed());
            Assert.fail("\"" + getElement(sheetName, elementName) + "\"" + " Element has found");
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }

    public void waitUntilElementClickable(String sheetName, String elementName) throws IOException {
        super.waitUntilElementClickable(getElement(sheetName, elementName));
    }

    public void waitUntilElementEnabled(String sheetName, String elementName) throws IOException {
        super.waitUntilElementEnabled(getElement(sheetName, elementName));
    }

    public void waitForElementVisible(String sheetName, String elementName) throws IOException {
        super.waitUntilElementVisible(getElement(sheetName, elementName));
    }

    public void clickElement(String sheetName, String elementName) throws IOException {
        waitUntilElementClickable(sheetName, elementName);
        getElement(sheetName, elementName).click();
    }

    public void inputText(String sheetName, String elementName, String text) throws IOException {
        waitUntilElementClickable(sheetName, elementName);
        getElement(sheetName, elementName).sendKeys(text);
    }

    public String getScenarioDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            String value = (String) scenarioStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public String getSpecificationDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            String value = (String) specDataStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public String getSuiteDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            String value = (String) suiteStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public void saveToScenarioDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            scenarioStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToSpecificationDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            specDataStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToSuiteDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            suiteStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToDataStore(String dataStoreType, String variableName, String valueToBeStored){
        switch (dataStoreType.toLowerCase()){
            case "spec":
                saveToSpecificationDataStore(variableName, valueToBeStored);
                break;
            case "specification":
                saveToSpecificationDataStore(variableName, valueToBeStored);
                break;
            case "scenario":
                saveToScenarioDataStore(variableName, valueToBeStored);
                break;
            case "suite":
                saveToSuiteDataStore(variableName, valueToBeStored);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
    }

    public String readFromDataStore(String dataStoreType, String variableName){
        String value = "";
        switch (dataStoreType.toLowerCase()){
            case "spec":
                value = getSpecificationDataStoreValue(variableName);
                break;
            case "specification":
                value = getSpecificationDataStoreValue(variableName);
                break;
            case "scenario":
                value = getScenarioDataStoreValue(variableName);
                break;
            case "suite":
                value = getSuiteDataStoreValue(variableName);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
        return value;
    }


}
