package com.example.automation.steps;

import org.openqa.selenium.WebDriver;

import com.example.automation.core.DriverFactory;
import com.example.automation.pages.BlogPage;
import com.example.automation.pages.ContactPage;
import com.example.automation.pages.CoursesPage;
import com.example.automation.pages.HomePage;
import com.example.automation.pages.PracticePage;
import com.example.automation.pages.components.HeaderComponent;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderNavigationSteps {
    private WebDriver driver;
    private HeaderComponent header;
    private HomePage homePage;
    private PracticePage practicePage;
    private CoursesPage coursesPage;
    private BlogPage blogPage;
    private ContactPage contactPage;

    @Before
    public void setUp() {
        driver = DriverFactory.createDriver();
        header = new HeaderComponent(driver);
        homePage = new HomePage(driver);
        practicePage = new PracticePage(driver);
        coursesPage = new CoursesPage(driver);
        blogPage = new BlogPage(driver);
        contactPage = new ContactPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open the Practice Test Automation home page")
    public void openHomePage() {

        homePage.openUrl("https://practicetestautomation.com");

        homePage.assertAt();
    }

    @When("I click the {string} header")
    public void clickTheHeader(String headerName) {
        switch (headerName.toLowerCase()) {
            case "home" -> header.clickHome();
            case "practice" -> header.clickPractice();
            case "courses" -> header.clickCourses();
            case "blog" -> header.clickBlog();
            case "contact" -> header.clickContact();
            default -> throw new IllegalArgumentException("Unsupported header: " + headerName);
        }
    }

    @Then("I should be on the {string} page")
    public void iShouldBeOnThePage(String pageName) {
        switch (pageName.toLowerCase()) {
            case "home" -> homePage.assertAt();
            case "practice" -> practicePage.assertAt();
            case "courses" -> coursesPage.assertAt();
            case "blog" -> blogPage.assertAt();
            case "contact" -> contactPage.assertAt();
            default -> throw new IllegalArgumentException("Unsupported page: " + pageName);
        }
    }
}
