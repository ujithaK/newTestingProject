package com.example.automation.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.automation.pages.BasePage;

public class HeaderComponent extends BasePage {

    private static final By HOME_LINK =
            By.xpath("//a[normalize-space()='Home']");

    private static final By PRACTICE_LINK =
            By.xpath("//a[normalize-space()='Practice']");

    private static final By COURSES_LINK =
            By.xpath("//a[normalize-space()='Courses']");

    private static final By BLOG_LINK =
            By.xpath("//a[normalize-space()='Blog']");

    private static final By CONTACT_LINK =
            By.xpath("//a[normalize-space()='Contact']");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickHome() {
        click(HOME_LINK);
    }

    public void clickPractice() {
        click(PRACTICE_LINK);
    }

    public void clickCourses() {
        click(COURSES_LINK);
    }

    public void clickBlog() {
        click(BLOG_LINK);
    }

    public void clickContact() {
        click(CONTACT_LINK);
    }
}