#  QA Automation – Example

##  Overview

This project implements a lightweight REST API automation framework using:

- Java 17
- Maven
- JUnit 5
- RestAssured
- Cucumber (BDD)

The target API is the **Official Joke API**:

https://official-joke-api.appspot.com

The framework demonstrates clean architecture, reusable API client design, and multiple Cucumber techniques.

---

##  Tech Stack

| Tool | Version |
|------|---------|
| Java | 17 |
| Maven | 3.9.x |
| JUnit | 5.10.2 |
| Cucumber | 7.15.0 |
| RestAssured | 5.4.0 |

---

## 📂 Project Structure

src
├── test
│ ├── java/com/example/jokes
│ │ ├── client/ → API client layer
│ │ ├── config/ → Request configuration
│ │ ├── context/ → Shared test context
│ │ ├── runners/ → Cucumber runner
│ │ └── steps/ → Step definitions
│ │
│ └── resources/features
│ ├── random_joke.feature
│ ├── joke_by_id_outline.feature
│ └── jokes_list_background_datatable.feature


---

##  Implemented Scenarios

###  Scenario A — Plain Scenario
Retrieve a random joke

Verify HTTP 200

Validate response structure (id, type, setup, punchline)

### Scenario B — Scenario Outline + Examples
Retrieve joke by multiple IDs

Parameterized using `Examples` table

### Scenario C — Background + Data Table
Verify `/random_ten` endpoint

Use `Background`

Validate fields using DataTable



## How to Run

###  Run All Tests

```bash
mvn clean test
  
