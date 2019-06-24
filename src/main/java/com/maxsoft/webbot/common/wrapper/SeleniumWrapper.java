package com.maxsoft.webbot.common.wrapper;

import com.maxsoft.webbot.util.driver.Driver;
import com.maxsoft.webbot.util.driver.DriverFactory;
import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

import static com.maxsoft.webbot.common.Constants.*;
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


public class SeleniumWrapper {

    private WebDriver driver = Driver.driver;

    private static final long TIMEOUT = Long.parseLong(System.getenv("timeout"));

    public SeleniumWrapper() {
        PageFactory.initElements(driver, this);
    }

    public boolean isElementDisplayed(String locatorStrategy, String webElementLocator) {
        try {
            switch (locatorStrategy.toLowerCase()) {
                case "id":
                    return driver.findElement(By.id(webElementLocator)).isDisplayed();
                case "xpath":
                    return driver.findElement(By.xpath(webElementLocator)).isDisplayed();
                case "class name":
                    return driver.findElement(By.className(webElementLocator)).isDisplayed();
                case "css selector":
                    return driver.findElement(By.cssSelector(webElementLocator)).isDisplayed();
                case "link text":
                    return driver.findElement(By.linkText(webElementLocator)).isDisplayed();
                case "partial link text":
                    return driver.findElement(By.partialLinkText(webElementLocator)).isDisplayed();
                case "name":
                    return driver.findElement(By.name(webElementLocator)).isDisplayed();
                case "tag name":
                    return driver.findElement(By.tagName(webElementLocator)).isDisplayed();
                default:
                    Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                    break;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    public void verifyElementIsVisible(String locatorStrategy, String webElementLocator) {
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                Assert.assertTrue("WebElement " + driver.findElement(By.id(webElementLocator)) + " is not visible"
                        , driver.findElement(By.id(webElementLocator)).isDisplayed());
                break;
            case "xpath":
                Assert.assertTrue("WebElement " + driver.findElement(By.xpath(webElementLocator)) + " is not visible"
                        , driver.findElement(By.xpath(webElementLocator)).isDisplayed());
                break;
            case "class name":
                Assert.assertTrue("WebElement " + driver.findElement(By.className(webElementLocator)) + " is not visible"
                        , driver.findElement(By.className(webElementLocator)).isDisplayed());
                break;
            case "css selector":
                Assert.assertTrue("WebElement " + driver.findElement(By.cssSelector(webElementLocator)) + " is not visible"
                        , driver.findElement(By.cssSelector(webElementLocator)).isDisplayed());
                break;
            case "link text":
                Assert.assertTrue("WebElement " + driver.findElement(By.linkText(webElementLocator)) + " is not visible"
                        , driver.findElement(By.linkText(webElementLocator)).isDisplayed());
                break;
            case "partial link text":
                Assert.assertTrue("WebElement " + driver.findElement(By.partialLinkText(webElementLocator)) + " is not visible"
                        , driver.findElement(By.partialLinkText(webElementLocator)).isDisplayed());
                break;
            case "name":
                Assert.assertTrue("WebElement " + driver.findElement(By.name(webElementLocator)) + " is not visible"
                        , driver.findElement(By.name(webElementLocator)).isDisplayed());
                break;
            case "tag name":
                Assert.assertTrue("WebElement " + driver.findElement(By.tagName(webElementLocator)) + " is not visible"
                        , driver.findElement(By.tagName(webElementLocator)).isDisplayed());
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void verifyElementIsNotVisible(String locatorStrategy, String webElementLocator) {
        try {
            switch (locatorStrategy.toLowerCase()) {
                case "id":
                    driver.findElement(By.id(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.id(webElementLocator)) + " is visible");
                    break;
                case "xpath":
                    driver.findElement(By.xpath(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.xpath(webElementLocator)) + " is visible");
                    break;
                case "class name":
                    driver.findElement(By.className(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.className(webElementLocator)) + " is visible");
                    break;
                case "css selector":
                    driver.findElement(By.cssSelector(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.cssSelector(webElementLocator)) + " is visible");
                    break;
                case "link text":
                    driver.findElement(By.linkText(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.linkText(webElementLocator)) + " is visible");
                    break;
                case "partial link text":
                    driver.findElement(By.partialLinkText(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.partialLinkText(webElementLocator)) + " is visible");
                    break;
                case "name":
                    driver.findElement(By.name(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.name(webElementLocator)) + " is visible");
                    break;
                case "tag name":
                    driver.findElement(By.tagName(webElementLocator)).isDisplayed();
                    Assert.fail("WebElement " + driver.findElement(By.tagName(webElementLocator)) + " is visible");
                    break;
                default:
                    Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                    break;
            }
        } catch (NoSuchElementException ex) {

        }
    }

    public void refreshUntilElementVisible(String locatorStrategy, String webElementLocator, int refreshCount) {
        int i = 0;
        do {
            driver.navigate().refresh();
            i++;
        } while (!isElementDisplayed(locatorStrategy, webElementLocator) && i < refreshCount);
        System.out.println("Refreshed page " + i + " time/s");
        Gauge.writeMessage("Refreshed page " + i + " time/s");
        waitUntilElementVisible(locatorStrategy, webElementLocator);
    }

    public void refreshUntilElementNotVisible(String locatorStrategy, String webElementLocator, int refreshCount) {
        int i = 0;
        do {
            driver.navigate().refresh();
            i++;
        } while (isElementDisplayed(locatorStrategy, webElementLocator) && i < refreshCount);
        System.out.println("Refreshed page " + i + " time/s");
        Gauge.writeMessage("Refreshed page " + i + " time/s");
        waitUntilElementNotVisible(locatorStrategy, webElementLocator);
    }

    public void waitUntilElementVisible(String locatorStrategy, String webElementLocator) {
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.id(webElementLocator)));
                break;
            case "xpath":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementLocator)));
                break;
            case "class name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.className(webElementLocator)));
                break;
            case "css selector":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(webElementLocator)));
                break;
            case "link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(webElementLocator)));
                break;
            case "partial link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(webElementLocator)));
                break;
            case "name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.name(webElementLocator)));
                break;
            case "tag name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.tagName(webElementLocator)));
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void waitUntilElementClickable(String locatorStrategy, String webElementLocator) {
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.id(webElementLocator)));
                break;
            case "xpath":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLocator)));
                break;
            case "class name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.className(webElementLocator)));
                break;
            case "css selector":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.cssSelector(webElementLocator)));
                break;
            case "link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.linkText(webElementLocator)));
                break;
            case "partial link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(webElementLocator)));
                break;
            case "name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.name(webElementLocator)));
                break;
            case "tag name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.tagName(webElementLocator)));
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void waitUntilElementEnabled(String locatorStrategy, final String webElementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsEnabled;
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.id(webElementLocator)).isEnabled();
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
                break;
            case "xpath":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.xpath(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "class name":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.className(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "css selector":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.cssSelector(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "link text":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.linkText(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "partial link text":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.partialLinkText(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "name":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.name(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            case "tag name":
                elementIsEnabled = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver arg0) {
                        try {
                            driver.findElement(By.tagName(webElementLocator)).isEnabled();
                            return true;
                        } catch (NoSuchElementException e) {
                            return false;
                        } catch (StaleElementReferenceException e) {
                            return false;
                        }
                    }
                };
                wait.until(elementIsEnabled);
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void waitUntilElementNotVisible(String locatorStrategy, String webElementLocator) {
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.id(webElementLocator)));
                break;
            case "xpath":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElementLocator)));
                break;
            case "class name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.className(webElementLocator)));
                break;
            case "css selector":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(webElementLocator)));
                break;
            case "link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(webElementLocator)));
                break;
            case "partial link text":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(webElementLocator)));
                break;
            case "name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.name(webElementLocator)));
                break;
            case "tag name":
                new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(webElementLocator)));
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public String replaceWebElementLocatorPlaceholder(String webElementLocator, String placeholderText, String replacementText) {
        return webElementLocator.replaceAll(placeholderText, replacementText);
    }

    public void fluentWaitUntilNoExceptions(String locatorStrategy, final String webElementLocator, int pollingDuration) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(pollingDuration, TimeUnit.SECONDS)
                .ignoring(Exception.class);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.id(webElementLocator));
                    }
                });
                break;
            case "xpath":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.xpath(webElementLocator));
                    }
                });
                break;
            case "class name":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.className(webElementLocator));
                    }
                });
                break;
            case "css selector":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(webElementLocator));
                    }
                });
                break;
            case "link text":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.linkText(webElementLocator));
                    }
                });
                break;
            case "partial link text":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.partialLinkText(webElementLocator));
                    }
                });
                break;
            case "name":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.name(webElementLocator));
                    }
                });
                break;
            case "tag name":
                wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.tagName(webElementLocator));
                    }
                });
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
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

    public void scrollToElement(String locatorStrategy, String webElementLocator) {
        /** Scroll to the element using Touch Actions
         Actions actions = new Actions(driver);
         actions.moveToElement(element);
         actions.perform();
         waitUntilElementEnabled(element);
         **/
        // Scroll to the element using JavascriptExecutor
        waitUntilElementVisible(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id(webElementLocator)));
                break;
            case "xpath":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(webElementLocator)));
                break;
            case "class name":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className(webElementLocator)));
                break;
            case "css selector":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(webElementLocator)));
                break;
            case "link text":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText(webElementLocator)));
                break;
            case "partial link text":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.partialLinkText(webElementLocator)));
                break;
            case "name":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.name(webElementLocator)));
                break;
            case "tag name":
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.tagName(webElementLocator)));
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void inputText(String locatorStrategy, String webElementLocator, String text) {
        waitUntilElementEnabled(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                driver.findElement(By.id(webElementLocator)).sendKeys(text);
                break;
            case "xpath":
                driver.findElement(By.xpath(webElementLocator)).sendKeys(text);
                break;
            case "class name":
                driver.findElement(By.className(webElementLocator)).sendKeys(text);
                break;
            case "css selector":
                driver.findElement(By.cssSelector(webElementLocator)).sendKeys(text);
                break;
            case "link text":
                driver.findElement(By.linkText(webElementLocator)).sendKeys(text);
                break;
            case "partial link text":
                driver.findElement(By.partialLinkText(webElementLocator)).sendKeys(text);
                break;
            case "name":
                driver.findElement(By.name(webElementLocator)).sendKeys(text);
                break;
            case "tag name":
                driver.findElement(By.tagName(webElementLocator)).sendKeys(text);
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void clickElement(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickable(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                driver.findElement(By.id(webElementLocator)).click();
                break;
            case "xpath":
                driver.findElement(By.xpath(webElementLocator)).click();
                break;
            case "class name":
                driver.findElement(By.className(webElementLocator)).click();
                break;
            case "css selector":
                driver.findElement(By.cssSelector(webElementLocator)).click();
                break;
            case "link text":
                driver.findElement(By.linkText(webElementLocator)).click();
                break;
            case "partial link text":
                driver.findElement(By.partialLinkText(webElementLocator)).click();
                break;
            case "name":
                driver.findElement(By.name(webElementLocator)).click();
                break;
            case "tag name":
                driver.findElement(By.tagName(webElementLocator)).click();
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void clickElementUsingXCoordinates(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickable(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.id(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.id(webElementLocator)).click();
                break;
            case "xpath":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.xpath(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.xpath(webElementLocator)).click();
                break;
            case "class name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.className(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.className(webElementLocator)).click();
                break;
            case "css selector":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.cssSelector(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.cssSelector(webElementLocator)).click();
                break;
            case "link text":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.linkText(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.linkText(webElementLocator)).click();
                break;
            case "partial link text":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.partialLinkText(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.partialLinkText(webElementLocator)).click();
                break;
            case "name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.name(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.name(webElementLocator)).click();
                break;
            case "tag name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.tagName(webElementLocator)).getLocation().x + ")");
                driver.findElement(By.tagName(webElementLocator)).click();
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void clickElementUsingYCoordinates(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickable(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.id(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.id(webElementLocator)).click();
                break;
            case "xpath":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.xpath(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.xpath(webElementLocator)).click();
                break;
            case "class name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.className(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.className(webElementLocator)).click();
                break;
            case "css selector":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.cssSelector(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.cssSelector(webElementLocator)).click();
                break;
            case "link text":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.linkText(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.linkText(webElementLocator)).click();
                break;
            case "partial link text":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.partialLinkText(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.partialLinkText(webElementLocator)).click();
                break;
            case "name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.name(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.name(webElementLocator)).click();
                break;
            case "tag name":
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + driver.findElement(By.tagName(webElementLocator)).getLocation().y + ")");
                driver.findElement(By.tagName(webElementLocator)).click();
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void clickElementUsingJavascriptExecutor(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickable(locatorStrategy, webElementLocator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                js.executeScript("arguments[0].click();", driver.findElement(By.id(webElementLocator)));
                break;
            case "xpath":
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath(webElementLocator)));
                break;
            case "class name":
                js.executeScript("arguments[0].click();", driver.findElement(By.className(webElementLocator)));
                break;
            case "css selector":
                js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(webElementLocator)));
                break;
            case "link text":
                js.executeScript("arguments[0].click();", driver.findElement(By.linkText(webElementLocator)));
                break;
            case "partial link text":
                js.executeScript("arguments[0].click();", driver.findElement(By.partialLinkText(webElementLocator)));
                break;
            case "name":
                js.executeScript("arguments[0].click();", driver.findElement(By.name(webElementLocator)));
                break;
            case "tag name":
                js.executeScript("arguments[0].click();", driver.findElement(By.tagName(webElementLocator)));
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void selectFromDropdown(String locatorStrategy, String webElementLocator, String visibleText) {
        clickElementUsingJavascriptExecutor(locatorStrategy, webElementLocator);
        Select dropdown;
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                dropdown = new Select(driver.findElement(By.id(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "xpath":
                dropdown = new Select(driver.findElement(By.xpath(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "class name":
                dropdown = new Select(driver.findElement(By.className(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "css selector":
                dropdown = new Select(driver.findElement(By.cssSelector(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "link text":
                dropdown = new Select(driver.findElement(By.linkText(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "partial link text":
                dropdown = new Select(driver.findElement(By.partialLinkText(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "name":
                dropdown = new Select(driver.findElement(By.name(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            case "tag name":
                dropdown = new Select(driver.findElement(By.tagName(webElementLocator)));
                dropdown.selectByVisibleText(visibleText);
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    protected String getText(String locatorStrategy, String webElementLocator) {
        waitUntilElementVisible(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                return driver.findElement(By.id(webElementLocator)).getText();
            case "xpath":
                return driver.findElement(By.xpath(webElementLocator)).getText();
            case "class name":
                return driver.findElement(By.className(webElementLocator)).getText();
            case "css selector":
                return driver.findElement(By.cssSelector(webElementLocator)).getText();
            case "link text":
                return driver.findElement(By.linkText(webElementLocator)).getText();
            case "partial link text":
                return driver.findElement(By.partialLinkText(webElementLocator)).getText();
            case "name":
                return driver.findElement(By.name(webElementLocator)).getText();
            case "tag name":
                return driver.findElement(By.tagName(webElementLocator)).getText();
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
        return null;
    }

    public void pressKey(String locatorStrategy, String webElementLocator, CharSequence asciiCode) {
        waitUntilElementVisible(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                driver.findElement(By.id(webElementLocator)).sendKeys(asciiCode);
                break;
            case "xpath":
                driver.findElement(By.xpath(webElementLocator)).sendKeys(asciiCode);
                break;
            case "class name":
                driver.findElement(By.className(webElementLocator)).sendKeys(asciiCode);
                break;
            case "css selector":
                driver.findElement(By.cssSelector(webElementLocator)).sendKeys(asciiCode);
                break;
            case "link text":
                driver.findElement(By.linkText(webElementLocator)).sendKeys(asciiCode);
                break;
            case "partial link text":
                driver.findElement(By.partialLinkText(webElementLocator)).sendKeys(asciiCode);
                break;
            case "name":
                driver.findElement(By.name(webElementLocator)).sendKeys(asciiCode);
                break;
            case "tag name":
                driver.findElement(By.tagName(webElementLocator)).sendKeys(asciiCode);
                break;
            default :
                Assert.fail("\"" + locatorStrategy + "\" Locator strategy is not supported");
                break;
        }
    }

    public void switchToLastTab() {
        ArrayList <String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        saveToDataStore(SCENARIO, CURRENT_TAB_INDEX, String.valueOf(tabs.size()-1), Boolean.FALSE);
    }

    public void openURLNewTab(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToLastTab();
        driver.navigate().to(url);
    }

    public void openURLCurrentTab(String url) {
        driver.navigate().to(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void closeTab() {
//        ((JavascriptExecutor)driver).executeScript("close();");
        driver.close();
        try {
            if (Integer.valueOf(readFromDataStore(SCENARIO, CURRENT_TAB_INDEX, Boolean.FALSE)) <= 1) {
                switchToParentTab();
            } else {
                switchToTab(Integer.valueOf(readFromDataStore(SCENARIO, CURRENT_TAB_INDEX, Boolean.FALSE)) - 1);
            }
        }
        catch (Exception ex) {
            switchToParentTab();
        }
    }

    public void switchToTab(int tabIndex) {
        ArrayList <String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
        saveToDataStore(SCENARIO, CURRENT_TAB_INDEX, String.valueOf(tabIndex), Boolean.FALSE);
    }

    public void switchToTab(String tabTitle) {
        ArrayList <String> tabs = new ArrayList<String> (driver.getWindowHandles());
        ArrayList <String> tabList = new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++){
            tabList.add(i, driver.switchTo().window(tabs.get(i)).getTitle());
            driver.switchTo().window(tabs.get(0));
            if(tabList.get(i).equals(tabTitle)){
                driver.switchTo().window(tabs.get(i));
                saveToDataStore(SCENARIO, CURRENT_TAB_INDEX, String.valueOf(i), Boolean.FALSE);
                break;
            }
        }
    }

    public void switchToParentTab(){
        ArrayList <String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void openNewWindow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_N);
        switchToLastTab();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    public void closeAllTabsAndSwitchedToMainTab() {
        try {
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> iter = windows.iterator();
            String[] winNames=new String[windows.size()];
            int i=0;
            while (iter.hasNext()) {
                winNames[i]=iter.next();
                i++;
            }

            if(winNames.length > 1) {
                for(i = winNames.length; i > 1; i--) {
                    driver.switchTo().window(winNames[i - 1]);
                    driver.close();
                }
            }
            driver.switchTo().window(winNames[0]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
