package com.example.jokes.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestSpecFactory {

    private RequestSpecFactory() {}

    private static final RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(ApiConfig.BASE_URL)
                    .setRelaxedHTTPSValidation()
                    .build();

    public static RequestSpecification request() {
        return given().spec(REQUEST_SPEC);
    }
}
