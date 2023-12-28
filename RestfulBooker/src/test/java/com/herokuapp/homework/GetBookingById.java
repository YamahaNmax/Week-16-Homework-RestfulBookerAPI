package com.herokuapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetBookingById {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getBookingById() {
        RestAssured.baseURI="https://restful-booker.herokuapp.com/booking/471";
        requestSpecification=RestAssured.given();
        response=requestSpecification.get();
        System.out.println(response.prettyPrint());
        validatableResponse=response.then();
        validatableResponse.statusCode(200);
    }

}
