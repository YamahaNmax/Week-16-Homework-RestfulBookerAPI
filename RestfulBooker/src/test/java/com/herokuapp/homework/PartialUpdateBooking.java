package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class PartialUpdateBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void partialUpdateBooking() {
        String jsonData = "{\n" +
                "    \"firstname\" : \"Bond\",\n" +
                "    \"lastname\" : \"KFC\"\n" +
                "}";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/48";
        requestSpecification = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=ba47b91e3b0dda6");
        requestSpecification.body(jsonData);
        response = requestSpecification.patch();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", equalTo("Bond"));
        validatableResponse.body("lastname", equalTo("KFC"));

    }
}
