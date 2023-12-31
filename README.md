## Testing Framework: Automation Testing of Asana.com

Example of testing framework with API and UI tests

---

### 🗂️ Project Structure 🗂️

```
~/asana-e2e
├── asana-e2e-core
│   ├── src
│   │   └── main
│   │       ├── java
│   │       │   └── asana.e2e.core
│   │       │       ├──  baseTech
│   │       │       │   ├──  logger
│   │       │       │   └── readers
│   │       │       ├──  web
│   │       │       │   ├──  asserts
│   │       │       │   ├──  browsers
│   │       │       │   ├──  pages
│   │       │       │   └── webSteps.generated.steps
│   │       │       └── api
│   │       │           └── tech
│   │       │               ├── asserts
│   │       │               ├──  constructors
│   │       │               ├──  data
│   │       │               │   └── user
│   │       │               ├──  enums
│   │       │               ├──  http
│   │       │               ├──  matchers.createProject
│   │       │               │   ├── baseCreateProjectMatchers
│   │       │               │   ├── requestMatcher
│   │       │               │   └── responseMathcer
│   │       │               └── tests
│   │       │        
│   │       └── resources
│   │           └── log4j2
├── asana-e2e-integration
│   └── src
│       └── main
│           └── java
│               └── asana.e2e.integration.models
│                   ├── api
│                   │   ├── project
│                   │   └── workspace.base
│                   └── entites
│                       └── enums
├── asana-e2e-testing-api
│   └── src
│        └── main
│            └── java
│                └── ru.asana.e2e.testing.api.tests.project
├── asana-e2e-testing-ui
│   └── src
│        └── main
│            └── java
│                └── ru.asana.e2e.testing.ui.tests.project
└── pom.xml
```

#### 📂asana-e2e-core📂

The directory "asana-e2e-core" represents a part of the project structure. Inside this directory, there are source files and resources used to implement functionality related to automated testing (End-to-End) of the Asana.

#### 📂asana-e2e-integration📂

The directory "asana-e2e-integration" contains source files related to the integration testing of the Asana application. Within this directory, the Java files are organized into packages such as "asana.e2e.integration.models" and "asana.e2e.integration.models.api" which contain code for handling API-related integration testing. The "entites" package within "asana.e2e.integration.models" likely contains code for handling entities and enums used in the integration testing process.

#### 📂asana-e2e-testing-api📂

The directory "asana-e2e-testing-api" contains tests for API


__API TEST EXAMPLE__
``` java
    @Test
    @Name("TEST_1. Api. Creating. Creating project in Asana")
    public void TEST_1_Api__Creating__Creating_project_in_Asana() {

        // Step 1.1 Data preparation
        ProjectUser projectUser = DataLoaderApi.projectUser();
        ProjectRequest requestBody = new ProjectRequest()
                .setData(new Data()
                        .setName(RandomValueGenerator.randomLengthString(5, 10, ENG))
                        .setWorkspace(projectUser.getGid()));

        // Step 2.1 Send request to server
        HttpResponse<String> response = asanaApiProject.asanaExecuteCreateProject2хх(requestBody,
                projectUser);

        // Step Assert 3.1 Checking the results of sending a request
        CreateProjectMatchers.createProjectResponseDataMatcher(response)
                .gid(not(equalTo(nullValue())))
                .name(equalTo(requestBody.getData().getName()))
                .resource_type(equalTo(PROJECT.getType()))
                .workspace(createProjectResponseDataWorkspaceMatcher()
                        .gid(equalTo(projectUser.getGid()))
                        .resourceType(equalTo(WORKSPACE.getType())));
    }
```

#### 📂 asana-e2e-testing-ui📂

The directory "asana-e2e-testing-ui" contains tests for UI

__UI TEST EXAMPLE__
``` java
    @Test
    @Name("TEST_6. UI. Authorization Page. Not correct password")
    public void TEST_5_UI__Authorization__not_correct_password() {

        // Step 1.1 Arrange
        UserUi projectUser = DataLoaderUi.projectPositiveUser();
        projectUser.setPassword(randomLengthString(5, 10, ENG));

        // Step 2.1 Steps
        mainPage.click_logIn_button();
        authorizationPage.fill_email(projectUser.getMail());
        authorizationPage.click_continue_button();
        authorizationPage.fill_password(projectUser.getPassword());
        authorizationPage.click_continue_button();

        // Step 3.1 Asserts
        AssertsUi.assertMessage(authorizationPage.get_emailAddress_message(),
                UiInformation.ERRORS_PASSWORD.getMessage());
        AssertsUi.assertMessage(authorizationPage.get_alert_message(),
                UiInformation.ERRORS_PASSWORD.getError());
    }
``` 


