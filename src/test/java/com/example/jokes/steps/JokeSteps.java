package com.example.jokes.steps;

import com.example.jokes.client.JokeApiClient;
import com.example.jokes.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

import static org.hamcrest.Matchers.hasKey;

public class JokeSteps {

    private final JokeApiClient client = new JokeApiClient();
    private final TestContext context = new TestContext();

    // ==============================
    // Scenario A - Random Joke
    // ==============================

    @When("I request a random joke")
    public void i_request_a_random_joke() {
        context.setResponse(client.getRandomJoke());
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatus) {
        context.getResponse()
                .then()
                .statusCode(expectedStatus);
    }

    @Then("the response should contain the following fields:")
    public void the_response_should_contain_the_following_fields(DataTable dataTable) {
        List<String> expectedFields = dataTable.asList();

        for (String field : expectedFields) {
            context.getResponse()
                    .then()
                    .body("$", hasKey(field));
        }
    }

    // ==============================
    // Scenario B - Joke by ID
    // ==============================

    @When("I request a joke with id {int}")
    public void i_request_a_joke_with_id(Integer id) {
        context.setResponse(client.getJokeById(id));
    }

    @And("the joke id in response should be {int}")
    public void the_joke_id_in_response_should_be(Integer expectedId) {
        context.getResponse()
                .then()
                .body("id", org.hamcrest.Matchers.equalTo(expectedId));
    }

    // ==============================
    // Scenario C - random_ten
    // ==============================

    @Given("the Joke API is available")
    public void the_joke_api_is_available() {
        // Could add health check here if needed
    }

    @When("I request ten random jokes")
    public void i_request_ten_random_jokes() {
        context.setResponse(client.getRandomTen());
    }

    @Then("each joke should contain the following fields:")
    public void each_joke_should_contain_the_following_fields(DataTable dataTable) {
        List<String> expectedFields = dataTable.asList();

        int size = context.getResponse().jsonPath().getList("$").size();

        for (int i = 0; i < size; i++) {
            for (String field : expectedFields) {
                context.getResponse()
                        .then()
                        .body("[" + i + "]", hasKey(field));
            }
        }
    }
}
