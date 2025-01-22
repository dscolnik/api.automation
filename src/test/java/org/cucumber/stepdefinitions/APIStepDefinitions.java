package org.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.api.RestAssuredRequests;
import org.testng.Assert;

public class APIStepDefinitions extends RestAssuredRequests {

    @Given("the base URI is set to {string}")
    public void theBaseURIIsSetTo(String baseURI) {
        setBaseURI(baseURI);
    }

    @Given("the path parameter is set to {string}")
    public void thePathParameterIsSetTo(String pathParameter) {
        setPathParameter(pathParameter);
    }

    @When("I send GET request")
    public void sendGETRequest() {
        getRequest();
    }

    @When("I send POST request with new user details {string}")
    public void sendPOSTRequest(String JSONBody) {
        postRequestFromJSONFile(JSONBody);
    }

    @When("I send PUT request with new user details {string}")
    public void sendPUTRequest(String JSONBody) {
        putRequestFromJSONFile(JSONBody);
    }

    @When("I send PATCH request with new user details {string}")
    public void sendPATCHRequest(String JSONBody) {
        patchRequestFromJSONFile(JSONBody);
    }

    @When("I send DELETE request with new user details")
    public void sendDELETERequest() {
        deleteRequest();
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeSHouldBe(Integer statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the title of the second post should be {string}")
    public void titleOfSecondPostShouldbe(String title) {
        Assert.assertEquals(response.jsonPath().getString("title[1]"), title);
    }

    @Then("the Title should be {string}")
    public void titleSHouldBe(String title) {
        Assert.assertEquals(response.jsonPath().getString("title"), title);
    }

    @Then("the Body should be {string}")
    public void bodyShouldBe(String body) {
        Assert.assertEquals(response.jsonPath().getString("body"), body);
    }

    @Then("the User shoould be {string}")
    public void userShouldBe(String user) {
        Assert.assertEquals(response.jsonPath().getString("userId"), user);
    }

    @Then("the ID should be {string}")
    public void idShouldBe(String id) {
        Assert.assertEquals(response.jsonPath().getString("id"), id);
    }
}
