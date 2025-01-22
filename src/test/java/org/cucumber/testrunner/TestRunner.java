package org.cucumber.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.cucumber.drivers.InitializeDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@CucumberOptions(
        features = "src//test//java//org//cucumber//resources//features",
        glue = {"org.cucumber.stepdefinitions"},
        plugin = {"pretty", "html:output/html-report.html"},
        tags = "@ExecuteAll_API",
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeTest
    @Parameters({"Mode", "BrowserType"})
    public void setUp(String mode, String browserType) throws MalformedURLException {
        System.out.println("Run Mode id: " + mode + " : Run Broswer Type is: " + browserType);
        if(!mode.equals("API")) {
            driver = InitializeDrivers.setDriver(mode, browserType);
        }
    }

    @AfterTest
    public void generateExtendReport() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
