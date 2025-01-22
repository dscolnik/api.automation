package org.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.testrunner.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebStepDefinitions extends TestRunner {

    @Given("launch application singup page")
    public void launchApplicationSingUpPage() {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @Given("enter username {string}")
    public void enterUsername(String userName) {
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys(userName);
    }

    @Given("enter password {string}")
    public void enterPassword(String password) {
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
    }

    @When("I click submit button")
    public void clickSubmitButton() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        WebElement errorMsg = driver.findElement(By.id("error"));
        boolean assertionflag = errorMsg.getText().equals(errorMessage) ? true : false;
        Assert.assertEquals(assertionflag, true);
    }
}
