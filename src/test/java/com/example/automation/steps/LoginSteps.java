package com.example.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.automation.core.DriverFactory;
import com.example.automation.pages.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private WebDriver driver;
    private BasePage basePage;

    @Before
    public void setUp() {
        driver = DriverFactory.createDriver();
        basePage = new BasePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open the practice login page")
    public void openPracticeLoginPage() {
        basePage.openUrl("https://practicetestautomation.com/practice-test-login/");
    }

    @When("I login with username {string} and password {string}")
    public void loginWithUsernameAndPassword(String username, String password) {
        basePage.type(By.id("username"), username);
        basePage.type(By.id("password"), password);
        basePage.click(By.id("submit"));
    }

    @Then("the logged in page URL should contain {string}")
    public void loggedInPageUrlShouldContain(String expectedUrlPart) {
        basePage.waitForUrlContains(expectedUrlPart);
        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {
            throw new AssertionError("Expected URL to contain: " + expectedUrlPart + ", but was: " + driver.getCurrentUrl());
        }
    }

    @And("the logged in page should show a success message")
    public void loggedInPageShouldShowSuccessMessage() {
        WebElement pageContent = basePage.visible(By.id("loop-container"));
        basePage.assertTextContains(pageContent, "Congratulations",
                "Expected success message was not displayed. Page text was: " + pageContent.getText());
    }

    @And("the logout button should be displayed")
    public void logoutButtonShouldBeDisplayed() {
        WebElement logoutButton = basePage.visible(By.linkText("Log out"));
        basePage.assertDisplayed(logoutButton, "Expected Log out button to be displayed.");
    }

    @Then("the page heading should be {string}")
    public void pageHeadingShouldBe(String expectedHeading) {
        WebElement heading = basePage.visible(By.xpath("//*[self::h1 or self::h2][normalize-space()='" + expectedHeading + "']"));

        basePage.assertTextEquals(heading, expectedHeading, "Expected page heading to match the UI text.");
    }

    @And("the page description should contain {string}")
    public void pageDescriptionShouldContain(String expectedText) {
        WebElement body = basePage.visible(By.tagName("body"));

        basePage.assertTextContains(body, expectedText,
                "Expected description to contain: " + expectedText + ", but was: " + body.getText());
    }

    @And("the submit button should be labeled {string}")
    public void submitButtonShouldBeLabeled(String expectedLabel) {
        WebElement submitButton = basePage.visible(By.id("submit"));

        basePage.assertValueEquals(submitButton, expectedLabel,
                "Expected submit button label to match the UI text.");
    }
}
