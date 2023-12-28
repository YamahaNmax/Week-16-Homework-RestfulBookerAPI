package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteBooking() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/22";
        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=97dc4b7197026f8");
        response = requestSpecification.delete();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(201);

    }
}
