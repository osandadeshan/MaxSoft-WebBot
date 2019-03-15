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

import static com.maxsoft.webbot.common.SeleniumWrapper.TEST_DATA_FILE_PATH;

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

    @Step("Sleep <seconds> seconds")
    public void sleep (int seconds) {
        baseObj.sleep(seconds);
    }

    @Step("test")
    public void main() {
        Excel.getDataInRightSideCell(TEST_DATA_FILE_PATH, "Test Data", "Username");
        Excel.getDataInRightSideCell(TEST_DATA_FILE_PATH, "Test Data", "Password");
        Excel.getDataInRightSideCell(TEST_DATA_FILE_PATH, "Test Data", "Purchase Token");
    }

    @Step("Validate the elements' visibility on the screen <table>")
    public void isElementVisible(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            if (row.getCell(columnNames.get(3)).toLowerCase().equals("y") || row.getCell(columnNames.get(3)).toLowerCase().equals("yes")) {
                baseObj.isElementVisible(row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
            } else {
                baseObj.isElementNotVisible(row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
            }
        }
    }

    @Step("Click element <table>")
    public void clickElement(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.clickElement(row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

    @Step("Input text <table>")
    public void inputText(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.inputText(row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)));
        }
    }


}
