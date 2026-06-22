package com.example.automation.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement visible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement clickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForUrlContains(String expectedPart) {
        wait.until(
                ExpectedConditions.urlContains(expectedPart));
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void highlight(WebElement element) {
        javascriptExecutor.executeScript(
                "arguments[0].style.border='3px solid red'",
                element);
    }

    public void type(By locator, String text) {
        WebElement element = visible(locator);
        highlight(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {

        WebElement element = clickable(locator);
        highlight(element);

        try {
            element.click();
        } catch (Exception e) {
            javascriptExecutor.executeScript(
                    "arguments[0].click();",
                    element);
        }
    }

    public void assertTextEquals(
            WebElement element,
            String expectedText,
            String failureMessage) {

        highlight(element);

        assertEquals(
                element.getText().trim(),
                expectedText,
                failureMessage);
    }

    public void assertTextContains(
            WebElement element,
            String expectedText,
            String failureMessage) {

        highlight(element);

        assertTrue(
                element.getText().contains(expectedText),
                failureMessage);
    }

    public void assertDisplayed(
            WebElement element,
            String failureMessage) {

        highlight(element);

        assertTrue(
                element.isDisplayed(),
                failureMessage);
    }
    public void assertValueEquals(
            WebElement element,
            String expectedValue,
            String failureMessage) {

        highlight(element);

        String actualValue = element.getText();

        if (actualValue == null || actualValue.isBlank()) {
            actualValue = element.getAttribute("value");
        }

        assertEquals(
                actualValue,
                expectedValue,
                failureMessage);
    }
}