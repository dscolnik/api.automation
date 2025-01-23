@ExecuteAll_API
Feature: Validate API Requests Methods

  @API_GET
  Scenario Outline: Verify the status code and the title of the GET request
    Given the base URI is set to "<BaseURI>"
    And the path parameter is set to "<PathParameter>"
    When I send GET request
    Then the response status code should be <ExpectedStatusCode>
    And the title of the second post should be "<ExpectedTitle>"

    Examples:
      | BaseURI                              | PathParameter | ExpectedStatusCode | ExpectedTitle |
      | https://jsonplaceholder.typicode.com | /posts        | 200                | qui est esse  |


  @API_POST
  Scenario Outline: Verify whether the new user is created successfully
    Given the base URI is set to "<BaseURI>"
    And the path parameter is set to "<PathParameter>"
    When I send POST request with new user details "<JSONBody>"
    Then the response status code should be <ExpectedStatusCode>
    And the Title should be "<Title>"
    And the Body should be "<Body>"
    And the User shoould be "<UserID>"
    And the ID should be "<ID>"

    Examples:
      | BaseURI                              | PathParameter | ExpectedStatusCode | JSONBody                                                           | Title | Body | UserID | ID  |
      | https://jsonplaceholder.typicode.com | /posts        | 201                | src//test//java//org//cucumber//resources//testdata//postBody.json | foo   | bar  | 120789 | 101 |


  @API_PUT
  Scenario Outline: Verify whether the existing user details updated successfully
    Given the base URI is set to "<BaseURI>"
    And the path parameter is set to "<PathParameter>"
    When I send PUT request with new user details "<JSONBody>"
    Then the response status code should be <ExpectedStatusCode>
    And the Title should be "<Title>"
    And the Body should be "<Body>"
    And the User shoould be "<UserID>"
    And the ID should be "<ID>"

    Examples:
      | BaseURI                              | PathParameter | ExpectedStatusCode | JSONBody                                                          | Title | Body | UserID | ID |
      | https://jsonplaceholder.typicode.com | /posts/1      | 200                | src//test//java//org//cucumber//resources//testdata//putBody.json | foo   | baz  | 120789 | 1  |


  @API_PATCH
  Scenario Outline: Verify whether the existing user specific field details updated successfully
    Given the base URI is set to "<BaseURI>"
    And the path parameter is set to "<PathParameter>"
    When I send PATCH request with new user details "<JSONBody>"
    Then the response status code should be <ExpectedStatusCode>
    And the Title should be "<Title>"
    And the Body should be "<Body>"
    And the User shoould be "<UserID>"
    And the ID should be "<ID>"

    Examples:
      | BaseURI                              | PathParameter | ExpectedStatusCode | JSONBody                                                            | Title | Body | UserID | ID |
      | https://jsonplaceholder.typicode.com | /posts/1      | 200                | src//test//java//org//cucumber//resources//testdata//patchBody.json | foo   | bax  | 120789 | 1  |


  @API_DELETE
  Scenario Outline: Verify whether the user able to delete a post from the server
    Given the base URI is set to "<BaseURI>"
    And the path parameter is set to "<PathParameter>"
    When I send DELETE request with new user details
    Then the response status code should be <ExpectedStatusCode>

    Examples:
      | BaseURI                              | PathParameter | ExpectedStatusCode |
      | https://jsonplaceholder.typicode.com | /posts/1      | 200                |