package com.example.automation.core;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {

        String browser = System.getProperty(
                        "browser",
                        "chrome")
                .toLowerCase(Locale.ROOT);

        boolean headless = Boolean.parseBoolean(
                System.getProperty(
                        "headless",
                        "false"));

        WebDriver driver;

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver(
                        getChromeOptions(headless));
                break;

            case "edge":
                driver = new EdgeDriver(
                        getEdgeOptions(headless));
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ZERO);

        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        return driver;
    }

    private static ChromeOptions getChromeOptions(
            boolean headless) {

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        return options;
    }

    private static EdgeOptions getEdgeOptions(
            boolean headless) {

        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}