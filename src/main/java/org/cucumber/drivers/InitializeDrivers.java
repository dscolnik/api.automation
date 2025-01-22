package org.cucumber.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class InitializeDrivers {

    public static WebDriver driver = null;

    public static WebDriver setDriver(String runModule, String browser) throws MalformedURLException {

        try {
            System.out.println("Test is running on " + browser + " in " + runModule + " mode");

            switch(runModule) {
                case "Web":
                    if(browser.equalsIgnoreCase("Chrome")) {
                        driver = new ChromeDriver();
                    } else if(browser.equalsIgnoreCase("FireFox")) {
                        driver = new FirefoxDriver();
                    }

                    driver.manage().window().maximize();
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                default:
            }
        } catch(Exception e) {
            System.out.println("Error message is: " + e.getMessage());
        }

        return driver;
    }
}
