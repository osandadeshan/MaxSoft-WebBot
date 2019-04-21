package com.maxsoft.webbot.common.steps;

import com.maxsoft.webbot.common.Base;
import com.maxsoft.webbot.common.wrapper.SeleniumWrapper;
import com.maxsoft.webbot.util.ascii.StringToAsciiMapper;
import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.maxsoft.webbot.common.Base.TEST_DATA_FILE_PATH;

/**
 * Project Name : MaxSoft WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 13/03/2019
 * Time         : 10:00 PM
 * Description  :
 **/


public class StepImpl {

    private WebDriver driver = Driver.driver;

    private Base baseObj = PageFactory.initElements(driver, Base.class);
    private SeleniumWrapper seleniumWrapperObj = PageFactory.initElements(driver, SeleniumWrapper.class);

    private String locatorRetrievingDataStoreType = "";
    private String locatorRetrievingDataStoreVariableName = "";
    private String valueRetrievingDataStoreType = "";
    private String valueRetrievingDataStoreVariableName = "";
    private String valueSavingDataStoreType = "";
    private String valueSavingDataStoreVariableName = "";
    private String valueToBeStored = "";
    private String sheetName = "";
    private String cellContent = "";
    private String isReplacementTextFromDataStore = "";
    private String elementName = "";
    private String placeholderText = "";
    private String replacementText = "";
    private String isElementFromLocatorsFile = "";
    private String locatorStrategy = "";
    private String isVisible = "";
    private String isInputTextFromDataStore = "";
    private String inputText = "";

    // Clear variable values
    private void clearVariableValues() {
        locatorRetrievingDataStoreType = "";
        locatorRetrievingDataStoreVariableName = "";
        valueRetrievingDataStoreType = "";
        valueRetrievingDataStoreVariableName = "";
        valueSavingDataStoreType = "";
        valueSavingDataStoreVariableName = "";
        valueToBeStored = "";
        sheetName = "";
        cellContent = "";
        isReplacementTextFromDataStore = "";
        elementName = "";
        placeholderText = "";
        replacementText = "";
        isElementFromLocatorsFile = "";
        locatorStrategy = "";
        isVisible = "";
        isInputTextFromDataStore = "";
        inputText = "";
    }

    // Use this method to keep idling the application for a given time in seconds
    @Step("Sleep <seconds> Seconds")
    public void sleep(int seconds) {
        baseObj.sleep(seconds);
    }

    // Use this method to save strings in data store
    @Step("Save the values inside data stores <table>")
    public void saveValueToDataStore(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            valueSavingDataStoreType = row.getCell(columnNames.get(0));
            valueSavingDataStoreVariableName = row.getCell(columnNames.get(1));
            valueToBeStored = row.getCell(columnNames.get(2));

            baseObj.saveToDataStore(valueSavingDataStoreType, valueSavingDataStoreVariableName, valueToBeStored);
            clearVariableValues();

        }
    }

    // Use this method to read strings from data store
    @Step("Read the values from data stores <table>")
    public void readValueFromDataStore(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            valueRetrievingDataStoreType = row.getCell(columnNames.get(0));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(1));

            baseObj.readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName);
            clearVariableValues();

        }
    }

    // Use this method to save the test data from the test_data.xlsx file to data stores
    @Step("Save Test Data From Excel To Data Stores <table>")
    public void saveFromExcelToDataStores(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            sheetName = row.getCell(columnNames.get(0));
            cellContent = row.getCell(columnNames.get(1));
            valueSavingDataStoreType = row.getCell(columnNames.get(2));
            valueSavingDataStoreVariableName = row.getCell(columnNames.get(3));

            baseObj.saveToDataStore(valueSavingDataStoreType, valueSavingDataStoreVariableName,
                    Excel.getCellContentInRightSideCell(TEST_DATA_FILE_PATH, sheetName, cellContent));
            clearVariableValues();

        }
    }

    // Use this method to replace the locator placeholder in locators.xlsx file and save the locator in a data store
    @Step("Replace Element Locator Placeholder And Save To Data Store <table>")
    public void replaceWebElementLocatorPlaceholderAndSaveToDataStore(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            sheetName = row.getCell(columnNames.get(1));
            elementName = row.getCell(columnNames.get(2));
            placeholderText = row.getCell(columnNames.get(3));
            isReplacementTextFromDataStore = row.getCell(columnNames.get(4)).toLowerCase();
            valueRetrievingDataStoreType = row.getCell(columnNames.get(5));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            replacementText = row.getCell(columnNames.get(7));
            valueSavingDataStoreType = row.getCell(columnNames.get(8));
            valueSavingDataStoreVariableName = row.getCell(columnNames.get(9));

            if (baseObj.isVariableContainsTrue(isReplacementTextFromDataStore)) {
                baseObj.replaceWebElementLocatorPlaceholderAndSaveToDataStore(sheetName, elementName, placeholderText,
                        baseObj.readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName), valueSavingDataStoreType, valueSavingDataStoreVariableName);
            } else {
                baseObj.replaceWebElementLocatorPlaceholderAndSaveToDataStore(sheetName, elementName, placeholderText,
                        replacementText, valueSavingDataStoreType, valueSavingDataStoreVariableName);
            }
            clearVariableValues();

        }
    }

    // Use this method to verify the element's visibility which is on the current view port
    @Step("Validate Element's Visibility On The Page <table>")
    public void isElementVisible(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            isVisible = row.getCell(columnNames.get(7));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                if (baseObj.isVariableContainsTrue(isVisible)) {
                    baseObj.verifyElementIsVisible(sheetName, elementName);
                } else {
                    baseObj.verifyElementIsNotVisible(sheetName, elementName);
                }
            } else {
                if (baseObj.isVariableContainsTrue(isVisible)) {
                    seleniumWrapperObj.verifyElementIsVisible(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName));
                } else {
                    seleniumWrapperObj.verifyElementIsNotVisible(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName));
                }
            }
            clearVariableValues();

        }
    }

    // Use this method to wait until the element is visible on the current view port
    @Step("Wait Until Element Is Visible On The Page <table>")
    public void waitUntilElementVisible(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.waitUntilElementVisible(sheetName, elementName);
            } else {
                seleniumWrapperObj.waitUntilElementVisible(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName));
            }
            clearVariableValues();

        }
    }

    // Use this method to wait until the element is not visible on the current view port
    @Step("Wait Until Element Is Not Visible On The Page <table>")
    public void waitUntilElementNotVisible(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.waitUntilElementNotVisible(sheetName, elementName);
            } else {
                seleniumWrapperObj.waitUntilElementNotVisible(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName));
            }
            clearVariableValues();

        }
    }

    // Use this method to click the element on the current view port
    @Step("Click Element <table>")
    public void clickElement(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.clickElement(sheetName, elementName);
            } else {
                seleniumWrapperObj.clickElement(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName));
            }
            clearVariableValues();

        }
    }

    // Use this method to input text into a text box on the current view port
    @Step("Input Text <table>")
    public void inputText(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            isInputTextFromDataStore = row.getCell(columnNames.get(7));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(8));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(9));
            inputText = row.getCell(columnNames.get(10));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                    baseObj.inputText(sheetName, elementName, baseObj.readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName));
                } else {
                    baseObj.inputText(sheetName, elementName, inputText);
                }
            } else {
                if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                    seleniumWrapperObj.inputText(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName),
                            baseObj.readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName));
                } else {
                    seleniumWrapperObj.inputText(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName), inputText);
                }
            }
            clearVariableValues();

        }
    }

    // Use this method to press a keyboard key on an element on the current view port
    @Step("Press Key <table>")
    public void pressKey(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            CharSequence asciiCode = StringToAsciiMapper.convertToASCII(row.getCell(columnNames.get(7)).toLowerCase());

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.pressKey(sheetName, elementName, asciiCode);
            } else {
                seleniumWrapperObj.pressKey(locatorStrategy, baseObj.readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName), asciiCode);
            }
            clearVariableValues();

        }
    }

    
}
