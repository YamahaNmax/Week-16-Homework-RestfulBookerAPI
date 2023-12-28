package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void createBooking() {
        String jsonData = "{\n" +
                "    \"firstname\" : \"Express\",\n" +
                "    \"lastname\" : \"Agent\",\n" +
                "    \"totalprice\" : 4444,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2018-01-01\",\n" +
                "    \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonData);
        response = requestSpecification.post();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", equalTo("Express"));
        validatableResponse.body("booking.lastname", equalTo("Agent"));

    }
}
