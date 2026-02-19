Feature: Retrieve multiple jokes

  Background:
    Given the Joke API is available

  Scenario: Verify random_ten endpoint returns valid joke structure
    When I request ten random jokes
    Then the response status code should be 300
    And each joke should contain the following fields:
      | id        |
      | type      |
      | setup     |
      | punchline |
