package com.example.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final By HEADING = By.xpath("//*[self::h1 or self::h2][normalize-space()='Hello']");
    private static final String PAGE_TITLE = "Practice Test Automation | Learn Selenium WebDriver";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void assertAt() {
        assertEquals(driver.getTitle(), PAGE_TITLE, "Unexpected home page title.");
        assertTextEquals(visible(HEADING), "Hello", "Unexpected home page heading.");
    }
}
