Feature: Get Joke By ID

  Scenario Outline: Retrieve joke by id and verify structure
    When I request a joke with id <id>
    Then the response status code should be 200
    And the joke id in response should be <id>
    And the response should contain the following fields:
      | id        |
      | type      |
      | setup     |
      | punchline |

    Examples:
      | id  |
      | 1   |
      | 5   |
      | 10  |
