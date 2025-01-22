package org.cucumber.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class RestAssuredRequests {

    public static Response response = null;

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static void setPathParameter(String pathParameter) {
        RestAssured.basePath = pathParameter;
    }

    public static void getRequest() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();
    }

    public static void getRequestWithParam(String queryParameter, String queryParameterValue) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .param(queryParameter, queryParameterValue)
                .when()
                .get()
                .then()
                .extract().response();
    }

    public static void postRequest(String body) {
        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post()
                .then()
                .extract().response();
    }

    public static void postRequestFromJSONFile(String filePath) {
        File jsonFile = new File(filePath);

        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonFile)
                .when()
                .post()
                .then()
                .extract().response();
    }

    public static void putRequest(String body) {
        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .put()
                .then()
                .extract().response();
    }

    public static void putRequestFromJSONFile(String filePath) {
        File jsonFile = new File(filePath);

        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonFile)
                .when()
                .put()
                .then()
                .extract().response();
    }

    public static void patchRequest(String body) {
        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .patch()
                .then()
                .extract().response();
    }

    public static void patchRequestFromJSONFile(String filePath) {
        File jsonFile = new File(filePath);

        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonFile)
                .when()
                .patch()
                .then()
                .extract().response();
    }

    public static void deleteRequest() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete()
                .then()
                .extract().response();
    }
}
