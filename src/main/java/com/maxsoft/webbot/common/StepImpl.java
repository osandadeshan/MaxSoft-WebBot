package com.maxsoft.webbot.common;

import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
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

    // Use this method to keep idling the application for a given time in seconds
    @Step("Sleep <seconds> Seconds")
    public void sleep (int seconds) {
        baseObj.sleep(seconds);
    }

    // Use this method to save strings in data store
    @Step("Save the values inside data stores <table>")
    public void saveValueToDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.saveToDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

    // Use this method to read strings from data store
    @Step("Read the values from data stores <table>")
    public void readValueFromDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.readFromDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)));
        }
    }

    // Use this method to save the test data from the test_data.xlsx file to data stores
    @Step("Save Test Data From Excel To Data Stores <table>")
    public void saveFromExcelToDataStores(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.saveToDataStore(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)),
                    Excel.getCellContentInRightSideCell(TEST_DATA_FILE_PATH, row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1))));
        }
    }

    // Use this method to replace the locator placeholder in locators.xlsx file and save the locator in a data store
    @Step("Replace Element Locator Placeholder And Save To Data Store <table>")
    public void replaceWebElementLocatorPlaceholderAndSaveToDataStore(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.replaceWebElementLocatorPlaceholderAndSaveToDataStore(row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)),
                    row.getCell(columnNames.get(4)), row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6)));
        }
    }

    // Use this method to verify the element's visibility which is on the current view port
    @Step("Validate Element's Visibility On The Page <table>")
    public void isElementVisible(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(1)).toLowerCase().equals("y") || row.getCell(columnNames.get(1)).toLowerCase().equals("yes")) {
                if (row.getCell(columnNames.get(7)).toLowerCase().equals("y") || row.getCell(columnNames.get(7)).toLowerCase().equals("yes")) {
                    baseObj.verifyElementIsVisible(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)));
                } else {
                    baseObj.verifyElementIsNotVisible(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)));
                }
            } else {
                if (row.getCell(columnNames.get(7)).toLowerCase().equals("y") || row.getCell(columnNames.get(7)).toLowerCase().equals("yes")) {
                    baseObj.verifyElementIsVisibleBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))));
                } else {
                    baseObj.verifyElementIsNotVisibleBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))));
                }
            }
        }
    }

    // Use this method to wait until the element is visible on the current view port
    @Step("Wait Until Element Visible On The Page <table>")
    public void waitUntilElementVisible(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(1)).toLowerCase().equals("y") || row.getCell(columnNames.get(1)).toLowerCase().equals("yes")) {
                baseObj.waitUntilElementVisible(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)));
            } else {
                    baseObj.waitUntilElementVisibleBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))));
            }
        }
    }

    // Use this method to click the element on the current view port
    @Step("Click Element <table>")
    public void clickElement(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(1)).toLowerCase().equals("y") || row.getCell(columnNames.get(1)).toLowerCase().equals("yes")) {
                baseObj.click(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)));
            } else {
                baseObj.clickElementBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))));
            }
        }
    }

    // Use this method to input text into a text box on the current view port
    @Step("Input Text <table>")
    public void inputText(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(1)).toLowerCase().equals("y") || row.getCell(columnNames.get(1)).toLowerCase().equals("yes")) {
                if (row.getCell(columnNames.get(7)).toLowerCase().equals("y") || row.getCell(columnNames.get(7)).toLowerCase().equals("yes")) {
                    baseObj.inputText(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), baseObj.readFromDataStore(row.getCell(columnNames.get(8)), row.getCell(columnNames.get(9))));
                } else {
                    baseObj.inputText(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), row.getCell(columnNames.get(10)));
                }
            } else {
                if (row.getCell(columnNames.get(7)).toLowerCase().equals("y") || row.getCell(columnNames.get(7)).toLowerCase().equals("yes")) {
                    baseObj.inputTextBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))),
                            baseObj.readFromDataStore(row.getCell(columnNames.get(8)), row.getCell(columnNames.get(9))));
                } else {
                    baseObj.inputTextBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))), row.getCell(columnNames.get(10)));
                }
            }
        }
    }

    // Use this method to press a keyboard key on an element on the current view port
    @Step("Press Key <table>")
    public void pressKey(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(1)).toLowerCase().equals("y") || row.getCell(columnNames.get(1)).toLowerCase().equals("yes")) {
                baseObj.pressKey(row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), row.getCell(columnNames.get(7)));
            }else {
                baseObj.pressKeyBy(row.getCell(columnNames.get(4)), baseObj.readFromDataStore(row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6))), row.getCell(columnNames.get(7)));
            }
        }
    }


}
