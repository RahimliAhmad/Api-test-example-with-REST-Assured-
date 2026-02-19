Feature: Random Joke API

  Scenario: Get a random joke and verify response structure
    When I request a random joke
    Then the response status code should be 200
    And the response should contain the following fields:
      | id      |
      | type    |
      | setup   |
      | punchline |
