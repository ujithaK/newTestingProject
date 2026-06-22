package com.example.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.automation.core.BaseTest;

public class ExampleSmokeTest extends BaseTest {
    @Test
    public void shouldOpenExampleDotCom() {
        driver.get("https://example.com");

        assertEquals(driver.getTitle(), "Example Domain");
    }
}
