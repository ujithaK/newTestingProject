package com.example.automation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage extends BasePage {
    private static final By HEADING = By.xpath("//*[self::h1 or self::h2][normalize-space()='Courses']");
    private static final String PAGE_TITLE = "Courses | Practice Test Automation";

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public void assertAt() {
        assertTrue(driver.getTitle().contains(PAGE_TITLE), "Unexpected courses page title.");
        assertTextEquals(visible(HEADING), "Courses", "Unexpected courses page heading.");
    }
}
