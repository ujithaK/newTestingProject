package com.example.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    private static final By HEADING = By.xpath("//*[self::h1 or self::h2][normalize-space()='Unlock Your Future: Selenium WebDriver Career Launcher Part 6']");
    private static final String PAGE_TITLE = "Blog | Practice Test Automation";

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void assertAt() {
        assertEquals(driver.getTitle(), PAGE_TITLE, "Unexpected blog page title.");
        assertTextEquals(visible(HEADING), "Unlock Your Future: Selenium WebDriver Career Launcher Part 6",
                "Unexpected blog page heading.");
    }
}
