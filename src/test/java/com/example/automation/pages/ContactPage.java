package com.example.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    private static final By HEADING = By.xpath("//*[self::h1 or self::h2][normalize-space()='Contact']");
    private static final String PAGE_TITLE = "Contact | Practice Test Automation | Selenium WebDriver";

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void assertAt() {
        assertEquals(driver.getTitle(), PAGE_TITLE, "Unexpected contact page title.");
        assertTextEquals(visible(HEADING), "Contact", "Unexpected contact page heading.");
    }
}
