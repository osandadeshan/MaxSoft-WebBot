package com.maxsoft.webbot.common;

import com.maxsoft.webbot.util.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

/**
 * Project Name : MaxSoft WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 13/03/2019
 * Time         : 10:00 PM
 * Description  :
 **/


public class SeleniumWrapper {

    public static final long TIMEOUT = Long.parseLong(System.getenv("timeout"));

    WebDriver driver = Driver.driver;

    public SeleniumWrapper() {
        PageFactory.initElements(driver, this);
    }

    protected void verifyElementIsVisibleBy(String locatorStrategy, String webElementLocator) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void verifyElementIsNotVisibleBy(String locatorStrategy, String webElementLocator) {
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
                    Assert.fail("Locator strategy is not supported");
                    break;
            }
        } catch (NoSuchElementException ex) {

        }
    }

    protected void waitUntilElementVisibleBy(String locatorStrategy, String webElementLocator) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void waitUntilElementClickableBy(String locatorStrategy, String webElementLocator) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void waitUntilElementEnabledBy(String locatorStrategy, final String webElementLocator) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void waitUntilElementNotVisibleBy(String locatorStrategy, String webElementLocator) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected String replaceWebElementLocatorPlaceholder(String webElementLocator, String placeholderText, String replacementText) {
        return webElementLocator.replaceAll(placeholderText, replacementText);
    }

    protected void fluentWaitUntilNoExceptions(String locatorStrategy, final String webElementLocator, int pollingDuration) {
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void waitUntilPageLoaded() {
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

    protected void scrollToElementBy(String locatorStrategy, String webElementLocator) {
        /** Scroll to the element using Touch Actions
         Actions actions = new Actions(driver);
         actions.moveToElement(element);
         actions.perform();
         waitUntilElementEnabled(element);
         **/
        // Scroll to the element using JavascriptExecutor
        waitUntilElementVisibleBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void inputTextBy(String locatorStrategy, String webElementLocator, String text) {
        waitUntilElementEnabledBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void clickElementBy(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickableBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void clickElementUsingXCoordinatesBy(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickableBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void clickElementUsingYCoordinatesBy(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickableBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void clickElementUsingJavascriptExecutorBy(String locatorStrategy, String webElementLocator) {
        waitUntilElementClickableBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected void selectFromDropdownBy(String locatorStrategy, String webElementLocator, String visibleText) {
        clickElementUsingJavascriptExecutorBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }

    protected String getTextBy(String locatorStrategy, String webElementLocator) {
        waitUntilElementVisibleBy(locatorStrategy, webElementLocator);
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
                Assert.fail("Locator strategy is not supported");
                break;
        }
        return null;
    }

    protected void pressKeyBy(String locatorStrategy, String webElementLocator, String asciiCode) {
        //CharSequence cs = asciiCode;
        //element.sendKeys(cs);
        waitUntilElementVisibleBy(locatorStrategy, webElementLocator);
        switch (locatorStrategy.toLowerCase()) {
            case "id":
                driver.findElement(By.id(webElementLocator)).sendKeys("\ue007");
                break;
            case "xpath":
                driver.findElement(By.xpath(webElementLocator)).sendKeys("\ue007");
                break;
            case "class name":
                driver.findElement(By.className(webElementLocator)).sendKeys("\ue007");
                break;
            case "css selector":
                driver.findElement(By.cssSelector(webElementLocator)).sendKeys("\ue007");
                break;
            case "link text":
                driver.findElement(By.linkText(webElementLocator)).sendKeys("\ue007");
                break;
            case "partial link text":
                driver.findElement(By.partialLinkText(webElementLocator)).sendKeys("\ue007");
                break;
            case "name":
                driver.findElement(By.name(webElementLocator)).sendKeys("\ue007");
                break;
            case "tag name":
                driver.findElement(By.tagName(webElementLocator)).sendKeys("\ue007");
                break;
            default :
                Assert.fail("Locator strategy is not supported");
                break;
        }
    }


}
