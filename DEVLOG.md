# DEVLOG –  QA Automation example

### Project Initialization

- Created Maven project using Java 17.
- Added dependencies: RestAssured, JUnit 5, Cucumber.
- Configured JUnit Platform runner for Cucumber.
- Verified project builds and executes via `mvn clean test`.

### Decision:
Chose Maven for simplicity and clarity in dependency management.
Used JUnit 5 + Cucumber JUnit Platform Engine for modern test execution.



### Implemented:

`JokeApiClient` – encapsulates API calls.

`RequestSpecFactory` – centralizes base URI configuration.

`TestContext` – shared state between Cucumber steps.

Clean separation between client layer and step definitions.

### Design Rationale:

I separated API client logic from step definitions to:

Improve readability.

Avoid duplication.

Allow easy future extension (authentication, headers, logging).

The `TestContext` class was introduced to:
Avoid using global variables.

Enable scalable structure if multiple step classes are added.

## Cucumber Scenarios Implementation

### Scenario A – Plain Scenario
- Retrieve random joke.
- Validate HTTP 200.
- Validate response fields.

### Scenario B – Scenario Outline + Examples
- Parameterized test for multiple joke IDs.
- Avoids duplication.
- Demonstrates data-driven testing.

### Scenario C – Background + DataTable
- Uses Background for shared setup.
- Uses DataTable for flexible field validation.
- Validates structure of list response from `/random_ten`.

### Decision:
Used different Cucumber techniques to demonstrate understanding of BDD capabilities:
- Scenario
- Scenario Outline
- Examples
- Background
- DataTable

---

## Challenges & Solutions

###  JUnit Version Conflict
Encountered `NoSuchMethodError` due to JUnit Platform version mismatch.
Resolved by aligning all JUnit dependencies to compatible versions.

###  Maven Not Installed
Installed Maven and configured correct Java 17 version to match assignment requirements.

###  Improving Failure Readability
Enhanced assertions with custom failure messages and conditional response logging.

---

## AI Usage Transparency

AI tools were used for:
- Dependency alignment guidance
- Cucumber runner configuration clarification
- Minor structural improvement suggestions

All architectural decisions, debugging steps, and final implementation were manually reviewed and understood.

No code was blindly copied without analysis.


## Final Thoughts

This implementation focuses on:

- Clean architecture
- Readability
- Proper use of Cucumber techniques
- Maintainable structure
- Professional setup and documentation
