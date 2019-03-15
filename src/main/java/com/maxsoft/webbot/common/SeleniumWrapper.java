package com.maxsoft.webbot.common;

import com.maxsoft.webbot.util.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Project Name : MaxSoft WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 13/03/2019
 * Time         : 10:00 PM
 * Description  :
 **/


public class SeleniumWrapper {

    public static final String APPLICATION_ENDPOINT = System.getenv("application_endpoint");
    public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public static final long TIMEOUT = Long.parseLong(System.getenv("timeout"));
    public static final String TEST_DATA_FILE_PATH = System.getenv("test_data_excel_file_path");
    public static final String LOCATORS_FILE_PATH = System.getenv("locators_file_path");
    public WebElement webElement;

    WebDriver driver = Driver.driver;

    public SeleniumWrapper() {
        PageFactory.initElements(driver, this);
    }

    public void isElementVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public void isElementNotVisible(WebElement element) {
        try {
            Assert.assertFalse(element.isDisplayed());
            Assert.fail("\"" + element + "\"" + " Element has found");
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }

    protected void waitUntilElementClickable(WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementEnabled(final WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsEnabled = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isEnabled();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
                catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        };
        wait.until(elementIsEnabled);
    }

    protected void waitUntilElementVisible(final WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementVisible(String xpathOfElement){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOfElement)));
    }

    protected void waitUntilElementInvisible(final WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isDisplayed();
                    return false;
                }
                catch (NoSuchElementException e ) {
                    return true;
                }
                catch (StaleElementReferenceException f) {
                    return true;
                }
            }
        };
        wait.until(elementIsDisplayed);
    }

    public void waitUntilElementRedrawed(WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }

    public void waitUntilPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for page load request to complete.");
        }
    }

    public void scrollToElement(WebElement element){
        /** Scroll to the element using Touch Actions
         Actions actions = new Actions(driver);
         actions.moveToElement(element);
         actions.perform();
         waitUntilElementEnabled(element);
         **/
        // Scroll to the element using JavascriptExecutor
        waitUntilElementVisible(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToElement(String xpathOfElement){
        /** Scroll to the element using Touch Actions
         Actions actions = new Actions(driver);
         actions.moveToElement(element);
         actions.perform();
         waitUntilElementEnabled(element);
         **/
        // Scroll to the element using JavascriptExecutor
        waitUntilElementVisible(xpathOfElement);
        WebElement element = driver.findElement(By.xpath(xpathOfElement));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void setTextAs(WebElement element, String text){
        waitUntilElementEnabled(element);
        element.click();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element){
        waitUntilElementClickable(element);
        element.click();
    }

    protected void clickElementByXCoordinates(WebElement element){
        waitUntilElementClickable(element);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
        element.click();
    }

    protected void clickElementByYCoordinates(WebElement element){
        waitUntilElementClickable(element);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
        element.click();
    }

    protected void clickElementByJavascriptExecutor(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        waitUntilElementClickable(element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected void clickElementByJavascriptExecutor(WebElement element){
        waitUntilElementClickable(element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected void clickLink(WebElement element){
        waitUntilElementEnabled(element);
        element.click();
    }

    public void selectFromDropdown(WebElement dropDown, String visibleText) {
        clickElementByJavascriptExecutor(dropDown);
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(visibleText);
    }

    protected String getText(WebElement element){
        waitUntilElementEnabled(element);
        return element.getText();
    }


}
