package com.maxsoft.webbot.common;

import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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

    public static final String APPLICATION_ENDPOINT = System.getenv("application_endpoint");
    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    protected static final String TEST_DATA_FILE_PATH = System.getenv("test_data_excel_file_path");
    private static final String LOCATORS_FILE_PATH = System.getenv("locators_file_path");

    public Base() {
        PageFactory.initElements(driver, this);
    }

    public String getLocatorFilePath() {
        return CURRENT_DIRECTORY + File.separator + LOCATORS_FILE_PATH;
    }

    public String testDataExcelFilePath() {
        return CURRENT_DIRECTORY + File.separator + TEST_DATA_FILE_PATH;
    }

    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void implicitlyWait(int seconds) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], "+seconds+"000);");
        //driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected static String getCurrentEpochTime() {
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    protected void print(String text) {
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    protected void verifyElementIsVisible(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.verifyElementIsVisibleBy(locatorStrategy, webElementLocator);
    }

    protected void verifyElementIsNotVisible(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        verifyElementIsNotVisibleBy(locatorStrategy, webElementLocator);
    }

    protected void waitUntilElementVisible(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.waitUntilElementVisibleBy(locatorStrategy, webElementLocator);
    }

    protected void waitUntilElementClickable(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.waitUntilElementClickableBy(locatorStrategy, webElementLocator);
    }

    protected void waitUntilElementEnabled(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.waitUntilElementEnabledBy(locatorStrategy, webElementLocator);
    }

    protected void waitUntilElementNotVisible(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.waitUntilElementNotVisibleBy(locatorStrategy, webElementLocator);
    }

    protected void replaceWebElementLocatorPlaceholderAndSaveToDataStore(String sheetName, String elementName, String placeholderText, String replacementText,
                                                                         String dataStoreType, String variableName) throws IOException {
        saveToDataStore(dataStoreType, variableName, replaceWebElementLocatorPlaceholder(Excel.getWebElementLocator(sheetName, elementName), placeholderText, replacementText));
    }

    protected void click(String sheetName, String elementName) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.clickElementBy(locatorStrategy, webElementLocator);
    }

    protected void inputText(String sheetName, String elementName, String text) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.inputTextBy(locatorStrategy, webElementLocator, text);
    }

    protected void pressKey(String sheetName, String elementName, String asciiCode) throws IOException {
        String locatorStrategy = Excel.getLocatorStrategy(sheetName, elementName);
        String webElementLocator = Excel.getWebElementLocator(sheetName, elementName);
        super.pressKeyBy(locatorStrategy, webElementLocator, asciiCode);
    }

    protected String getScenarioDataStoreValue(String variableNameOfValueStoredInDataStore) {
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

    protected String getSpecificationDataStoreValue(String variableNameOfValueStoredInDataStore) {
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

    protected String getSuiteDataStoreValue(String variableNameOfValueStoredInDataStore) {
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

    protected void saveToScenarioDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
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

    protected void saveToSpecificationDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
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

    protected void saveToSuiteDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
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

    protected void saveToDataStore(String dataStoreType, String variableName, String valueToBeStored){
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

    protected String readFromDataStore(String dataStoreType, String variableName){
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
