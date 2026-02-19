package com.example.jokes.client;

import com.example.jokes.config.RequestSpecFactory;
import io.restassured.response.Response;

public class JokeApiClient {

    public Response getRandomJoke() {
        return RequestSpecFactory.request()
                .when()
                .get("/random_joke");
    }

    public Response getJokeById(int id) {
        return RequestSpecFactory.request()
                .when()
                .get("/jokes/" + id);
    }

    public Response getRandomTen() {
        return RequestSpecFactory.request()
                .when()
                .get("/random_ten");
    }

}
