package com.maxsoft.webbot.util.reader;

import com.maxsoft.webbot.common.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Project Name : MaxSoft WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 13/03/2019
 * Time         : 10:30 PM
 * Description  :
 **/


public class Excel {

    private static Base baseObj = new Base();
    private static String testDataExcelFilePath = baseObj.testDataExcelFilePath();
    private static String locatorFilePath = baseObj.getLocatorFilePath();
    private static final int DEFAULT_TEXT_DISTANCE = 40;
    private static final int TEXT_DISTANCE = 40;
    private static final String SPACE = " ";
    private static int column;

    public static int getColumnNumberByCellContent(String excelFilePath, String sheetName, String cellContent) {
        try {
            FileInputStream excelFile = excelFile = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet firstSheet = workbook.getSheetAt(workbook.getSheetIndex(sheetName));
            Iterator<Row> iterator = firstSheet.iterator();
            CellAddress columnNumber = null;
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        String text = cell.getStringCellValue();
                        if (cellContent.equals(text)) {
                            columnNumber = cell.getAddress();
                            column = cell.getColumnIndex();
                            break;
                        }
                    }
                }
            }
            workbook.close();
            return column;
        }
        catch (FileNotFoundException ex) {
            Assert.fail("Excel file cannot be found at \"" + excelFilePath + "\"");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getRowNumberByCellContent(String excelFilePath, String sheetName, String cellContent) {
        try {
            FileInputStream excelFile = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet workSheet = workbook.getSheet(sheetName);
            for (Row row : workSheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                            return row.getRowNum();
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException ex) {
            Assert.fail("Excel file cannot be found at \"" + excelFilePath + "\"");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static String getCellContentInRightSideCell(String excelFilePath, String sheetName, String cellContent) {
        String cellValue = "";
        int colNum = 1;
        try {
            FileInputStream excelFile = new FileInputStream(new File(testDataExcelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet workSheet = workbook.getSheet(sheetName);
            cellValue = workSheet.getRow(Excel.getRowNumberByCellContent(excelFilePath, sheetName, cellContent)).getCell(colNum).getStringCellValue();
            return cellValue;
        }
        catch (NullPointerException ex) {
            Assert.fail("Key name \"" + cellContent + "\" cannot be found in \"" + sheetName+ "\" sheet on the excel file at " + excelFilePath + "\"");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return cellValue;
    }

    public static String getSpaces(int charCount){
        String spaces = "";
        int noOfSpaces = TEXT_DISTANCE - charCount;
        if (noOfSpaces > 0) {
            for (int i = 0; i < noOfSpaces; i++) {
                spaces = spaces.concat(SPACE);
            }
        } else {
            for (int i = 0; i < DEFAULT_TEXT_DISTANCE; i++) {
                spaces = spaces.concat(SPACE);
            }
        }
        return spaces;
    }

    public static String getCellContentByRowAndColumn(String excelFilePath, String sheetName, int row, int column) {
        String value = "";
        try {
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet workSheet = workbook.getSheetAt(workbook.getSheetIndex(sheetName));
            value = workSheet.getRow(row).getCell(column).getStringCellValue();
        }
        catch (FileNotFoundException ex) {
            Assert.fail("Excel file cannot be found at \"" + excelFilePath + "\"");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static String getWebElementName(String sheetName, String elementName) {
        int row, column;
        row = getRowNumberByCellContent(locatorFilePath, sheetName, elementName);
        if (row == -1){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        column = getColumnNumberByCellContent(locatorFilePath, sheetName, elementName);
        if (column == -1){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        return getCellContentByRowAndColumn(locatorFilePath, sheetName, row, column);
    }

    public static String getLocatorStrategy(String sheetName, String elementName) {
        int row, column;
        row = getRowNumberByCellContent(locatorFilePath, sheetName, elementName);
        if (row == -1){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        column = getColumnNumberByCellContent(locatorFilePath, sheetName, elementName) + 1;
        if (column == 0){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        return getCellContentByRowAndColumn(locatorFilePath, sheetName, row, column);
    }

    public static String getWebElementLocator(String sheetName, String elementName) {
        int row, column;
        row = getRowNumberByCellContent(locatorFilePath, sheetName, elementName);
        if (row == -1){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        column = getColumnNumberByCellContent(locatorFilePath, sheetName, elementName) + 2;
        if (column == 1){
            Assert.fail("\"" + elementName + "\" cannot be found in \"" + sheetName + "\" sheet on the locator excel file at " + locatorFilePath + "\"");
        }
        return getCellContentByRowAndColumn(locatorFilePath, sheetName, row, column);
    }


}
