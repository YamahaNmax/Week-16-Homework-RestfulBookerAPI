package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetAllBookingIds {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllBookingIDs() {
            RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
            requestSpecification= RestAssured.given();
            response=requestSpecification.get();
            System.out.println(response.prettyPrint());
            validatableResponse=response.then();
            validatableResponse.statusCode(200);

    }

}
