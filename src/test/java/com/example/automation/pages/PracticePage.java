package com.example.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage extends BasePage {
    private static final By HEADING = By.xpath("//*[self::h1 or self::h2][normalize-space()='Practice']");
    private static final String PAGE_TITLE = "Practice | Practice Test Automation";

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    public void assertAt() {
        assertEquals(driver.getTitle(), PAGE_TITLE, "Unexpected practice page title.");
        assertTextEquals(visible(HEADING), "Practice", "Unexpected practice page heading.");
    }
}
