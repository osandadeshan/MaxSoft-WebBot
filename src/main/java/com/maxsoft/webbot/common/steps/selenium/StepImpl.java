package com.maxsoft.webbot.common.steps.selenium;

import com.maxsoft.webbot.common.Base;
import com.maxsoft.webbot.common.wrapper.SeleniumWrapper;
import com.maxsoft.webbot.util.ascii.StringToAsciiMapper;
import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.driver.DriverFactory;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.util.List;

import static com.maxsoft.webbot.util.datastore.DataStores.readFromDataStore;

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

    private String locatorRetrievingDataStoreType, locatorRetrievingDataStoreVariableName = "";
    private String valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName = "";
    private String sheetName, elementName = "";
    private String isElementFromLocatorsFile, locatorStrategy, isVisible, isInputTextFromDataStore, inputText, refreshCount = "";

    // Clear variable values
    private void clearVariableValues() {
        locatorRetrievingDataStoreType = ""; locatorRetrievingDataStoreVariableName = "";
        valueRetrievingDataStoreType = ""; valueRetrievingDataStoreVariableName = "";
        sheetName = ""; elementName = "";
        isElementFromLocatorsFile = ""; locatorStrategy = ""; isVisible = ""; isInputTextFromDataStore = ""; inputText = ""; refreshCount = "";
    }

    // Use this method to open a new browser window
    @Step("Open New Browser Window")
    public void openNewWindow() throws AWTException {
        seleniumWrapperObj.openNewWindow();
    }

    // Use this method to maximize the browser window
    @Step("Maximize Browser Window")
    public void maximizeBrowserWindow() {
        Driver.maximizeDriver();
    }

    // Use this method to keep idling the application for a given time in seconds
    @Step("Sleep <seconds> Seconds")
    public void sleep(int seconds) {
        baseObj.sleep(seconds);
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

    // Use this method to open an url in a new browser tab
    @Step("Open URL In New Browser Tab <table>")
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

    // Use this method to open an url in the current browser tab
    @Step("Open URL In Current Browser Tab <table>")
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

    // Use this method to close the current browser tab
    @Step("Close The Current Browser Tab")
    public void closeTab() {
        seleniumWrapperObj.closeTab();
    }

    // Use this method to switch to a browser tab using the browser tab index
    @Step("Switch To The Browser Tab By Browser Tab Index <tabIndex>")
    public void switchToTab(int tabIndex) {
        seleniumWrapperObj.switchToTab(tabIndex);
    }

    // Use this method to switch to a browser tab using the browser tab title
    @Step("Switch To The Browser Tab By Browser Tab Title <table>")
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

    // Use this method to switch to the parent browser tab
    @Step("Switch To The Parent Browser Tab")
    public void switchToParentTab() {
        seleniumWrapperObj.switchToParentTab();
    }

    // Use this method to switch to the parent browser tab
    @Step("Close All Other Tabs And Switch To The Parent Browser Tab")
    public void closeAllTabsAndSwitchedToMainTab() {
        seleniumWrapperObj.closeAllTabsAndSwitchedToMainTab();
    }


}
