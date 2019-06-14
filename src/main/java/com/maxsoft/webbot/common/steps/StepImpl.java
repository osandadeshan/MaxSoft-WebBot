package com.maxsoft.webbot.common.steps;

import com.maxsoft.webbot.common.Base;
import com.maxsoft.webbot.common.wrapper.SeleniumWrapper;
import com.maxsoft.webbot.util.ascii.StringToAsciiMapper;
import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.maxsoft.webbot.common.Base.TEST_DATA_FILE_PATH;
import static com.maxsoft.webbot.util.datastore.DataStores.readFromDataStore;
import static com.maxsoft.webbot.util.datastore.DataStores.saveToDataStore;

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
    private String refreshCount = "";

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
        refreshCount = "";
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

            saveToDataStore(valueSavingDataStoreType, valueSavingDataStoreVariableName, valueToBeStored, Boolean.TRUE);
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

            readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE);
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

            saveToDataStore(valueSavingDataStoreType, valueSavingDataStoreVariableName,
                    Excel.getCellContentInRightSideCell(TEST_DATA_FILE_PATH, sheetName, cellContent), Boolean.TRUE);
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
                        readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE), valueSavingDataStoreType, valueSavingDataStoreVariableName);
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
                    seleniumWrapperObj.verifyElementIsVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE));
                } else {
                    seleniumWrapperObj.verifyElementIsNotVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE));
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
                seleniumWrapperObj.waitUntilElementVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE));
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
                seleniumWrapperObj.waitUntilElementNotVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE));
            }
            clearVariableValues();

        }
    }

    // Use this method to refresh until the element is visible on the current view port
    @Step("Refresh Until Element Is Visible On The Page <table>")
    public void refreshUntilElementVisible(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            refreshCount = row.getCell(columnNames.get(7));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.refreshUntilElementVisible(sheetName, elementName, Integer.valueOf(refreshCount));
            } else {
                seleniumWrapperObj.refreshUntilElementVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE),
                        Integer.valueOf(refreshCount));
            }
            clearVariableValues();

        }
    }

    // Use this method to refresh until the element is not visible on the current view port
    @Step("Refresh Until Element Is Not Visible On The Page <table>")
    public void refreshUntilElementNotVisible(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isElementFromLocatorsFile = row.getCell(columnNames.get(1));
            sheetName = row.getCell(columnNames.get(2));
            elementName = row.getCell(columnNames.get(3));
            locatorStrategy = row.getCell(columnNames.get(4));
            locatorRetrievingDataStoreType = row.getCell(columnNames.get(5));
            locatorRetrievingDataStoreVariableName = row.getCell(columnNames.get(6));
            refreshCount = row.getCell(columnNames.get(7));

            if (baseObj.isVariableContainsTrue(isElementFromLocatorsFile)) {
                baseObj.refreshUntilElementNotVisible(sheetName, elementName, Integer.valueOf(refreshCount));
            } else {
                seleniumWrapperObj.refreshUntilElementNotVisible(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE),
                        Integer.valueOf(refreshCount));
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
                seleniumWrapperObj.clickElement(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE));
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
                    baseObj.inputText(sheetName, elementName, readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE));
                } else {
                    baseObj.inputText(sheetName, elementName, inputText);
                }
            } else {
                if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                    seleniumWrapperObj.inputText(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE),
                            readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE));
                } else {
                    seleniumWrapperObj.inputText(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE), inputText);
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
                seleniumWrapperObj.pressKey(locatorStrategy, readFromDataStore(locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName, Boolean.TRUE), asciiCode);
            }
            clearVariableValues();

        }
    }

    // Use this method to open an url in a new tab
    @Step("Open URL In New Tab <table>")
    public void OpenURLNewTab(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isInputTextFromDataStore = row.getCell(columnNames.get(1));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(2));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(3));
            inputText = row.getCell(columnNames.get(4));

            if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                seleniumWrapperObj.openURLNewTab(readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE));
            } else {
                seleniumWrapperObj.openURLNewTab(inputText);
            }
            clearVariableValues();

        }
    }

    // Use this method to open an url in the current tab
    @Step("Open URL In Current Tab <table>")
    public void OpenURLInCurrentTab(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isInputTextFromDataStore = row.getCell(columnNames.get(1));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(2));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(3));
            inputText = row.getCell(columnNames.get(4));

            if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                seleniumWrapperObj.openURLCurrentTab(readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE));
            } else {
                seleniumWrapperObj.openURLCurrentTab(inputText);
            }
            clearVariableValues();

        }
    }

    // Use this method to validate the page title of the current tab
    @Step("Current Page Title Is <table>")
    public void isPageTitleEquals(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isInputTextFromDataStore = row.getCell(columnNames.get(1));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(2));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(3));
            inputText = row.getCell(columnNames.get(4));

            if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                Assert.assertEquals(readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE), seleniumWrapperObj.getPageTitle());
            } else {
                Assert.assertEquals(inputText, seleniumWrapperObj.getPageTitle());
            }
            clearVariableValues();

        }
    }

    // Use this method to validate the page title of the current tab
    @Step("Current Page Title Contains <table>")
    public void isPageTitleContains(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isInputTextFromDataStore = row.getCell(columnNames.get(1));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(2));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(3));
            inputText = row.getCell(columnNames.get(4));

            if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                Assert.assertTrue("Expected <" + readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE) + ">. But actual was <" +
                        seleniumWrapperObj.getPageTitle() + ">", seleniumWrapperObj.getPageTitle().contains(readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.TRUE)));
            } else {
                Assert.assertTrue("Expected <" + inputText + ">. But actual was <" + seleniumWrapperObj.getPageTitle() + ">", seleniumWrapperObj.getPageTitle().contains(inputText));
            }
            clearVariableValues();

        }
    }

    // Use this method to close the current tab
    @Step("Close The Current Tab")
    public void closeTab() {
        seleniumWrapperObj.closeTab();
    }

    // Use this method to switch to a tab using the tab index
    @Step("Switch To The Tab By Tab Index <tabIndex>")
    public void switchToTab(int tabIndex) {
        seleniumWrapperObj.switchToTab(tabIndex);
    }

    // Use this method to switch to a tab using the tab title
    @Step("Switch To The Tab By Tab Title <table>")
    public void switchToTab(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            isInputTextFromDataStore = row.getCell(columnNames.get(1));
            valueRetrievingDataStoreType = row.getCell(columnNames.get(2));
            valueRetrievingDataStoreVariableName = row.getCell(columnNames.get(3));
            inputText = row.getCell(columnNames.get(4));

            if (baseObj.isVariableContainsTrue(isInputTextFromDataStore)) {
                seleniumWrapperObj.switchToTab(readFromDataStore(valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName, Boolean.FALSE));
            } else {
                seleniumWrapperObj.switchToTab(inputText);
            }
            clearVariableValues();

        }
    }

    // Use this method to switch to the parent tab
    @Step("Switch To The Parent Tab")
    public void switchToParentTab() {
        seleniumWrapperObj.switchToParentTab();
    }


}
