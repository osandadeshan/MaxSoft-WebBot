package com.maxsoft.webbot.common.steps.datastore;

import com.maxsoft.webbot.common.Base;
import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
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

    private String valueRetrievingDataStoreType, valueRetrievingDataStoreVariableName = "";
    private String valueSavingDataStoreType, valueSavingDataStoreVariableName = "", replacementText = "";
    private String valueToBeStored, sheetName, propertyName, cellContent, isReplacementTextFromDataStore, elementName, placeholderText = "";

    // Clear variable values
    private void clearVariableValues() {
        valueRetrievingDataStoreType = ""; valueRetrievingDataStoreVariableName = "";
        valueSavingDataStoreType = ""; valueSavingDataStoreVariableName = "";
        valueToBeStored = ""; sheetName = ""; propertyName = ""; cellContent = ""; isReplacementTextFromDataStore = ""; elementName = ""; placeholderText = "";
        replacementText = "";
    }

    // Use this method to save strings in data store
    @Step("Save Values To Data Stores <table>")
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
    @Step("Read The Values From Data Stores <table>")
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

    // Use this method to save property file values into data stores
    @Step("Save Environment Property Values To Data Stores <table>")
    public void savePropertyValueToDataStore(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {

            valueSavingDataStoreType = row.getCell(columnNames.get(0));
            valueSavingDataStoreVariableName = row.getCell(columnNames.get(1));
            propertyName = row.getCell(columnNames.get(2));

            baseObj.savePropertyValueToDataStore(valueSavingDataStoreType, valueSavingDataStoreVariableName, propertyName);
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


}
