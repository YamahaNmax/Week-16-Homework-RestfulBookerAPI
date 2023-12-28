package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void updateBooking() {
        String jsonData = "{\n" +
                "    \"firstname\" : \"KFC\",\n" +
                "    \"lastname\" : \"Bond\",\n" +
                "    \"totalprice\" : 5555,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2018-01-01\",\n" +
                "    \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/48";
        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=c91041e395b028a");
        requestSpecification.body(jsonData);
        response = requestSpecification.put();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", equalTo("KFC"));
        validatableResponse.body("lastname", equalTo("Bond"));

    }
}
