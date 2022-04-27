# API Rest Service Testing Exercise / Instructions

#### Codes and Tests Prepared by:
**Talha OZLEBLEBICI**

*QA Test Automation Engineer / Industrial Engineer*

talha43gs@gmail.com

https://www.linkedin.com/in/talha-ozleblebici


**- Build Tool:** Maven

**- Test Framework:** Cucumber BBD (with Junit 4 Assertions)

------------
##### Api Swagger: 
`https://petstore.swagger.io`

##### Api REST Service: 
`https://petstore.swagger.io/`

##### Endpoint for Test: 
`v2/pet/findByStatus`

------------
#### QA: 
write a Cucumber BDD test that uses the method you have created to get 
the JSON response payload and validate how many pets have the status 
“available” and the name “doggie”.

------------
#### System Requirements: 
- Java 8+ SDK

------------
## Test RUN 

Notes: To run all Scenarios, use `@petStoreApi` tag in the CukesRunner class/Cucumber Options
#### 1. Way:
 - Clone the projects
 - Import maven dependencies from POM
 - Go **src -> test > java > io >  petstoreAPI > runners > CukesRunner** and RUN
 - To generate "HTML Maven Cucumber Report" ; 
    > Open Maven right side panel
    > Double Click Project's Lifecycle
    > Click "verify"
                                                  
#### 2. Way:
 - Run from command line invoke `mvn clean verify` 

------------

## Test Reports Locations
1- Cucumber HTML Plugin Reports
**target -> cucumber-html-reports > overview-steps.html** 
(Right Click and Open in any Browser )

2- When you run my project, Cucumber will create automatically online report link. You can click the link
with in the 24 hours and check the all test steps and status. I added a sample screenshot at Project level.

Link Sample:  https://reports.cucumber.io/reports/2d576248-564f-40a2-a7b6-61a682dec063 
(**ApiRestServiceTestingExercise -> CucumberOnlineReportsScreenshot.png** )

------------

## Cucumber Test Feature Scenarios:
#### 1) Validate pets quantity with getPetsByStatus method in live Api server
 a- In this Scenario, it test the endpoint with live Api server (https://petstore.swagger.io/)
 
 b- To run separately this scenario, use the `@liveApi` tag in the CukesRunner class/Cucumber Options
 
 Note: If for any reason the swagger service was down, codes automatically go on with pets.json as file a response 
 
#### 2) Validate pets quantity with getPetsByStatus method in WireMock server
 a- In this Scenario, it test the endpoint with Wire Mock server with specific port number.
 
 (To see port number and the other Uris , see the (**ApiRestServiceTestingExercise -> config.properties** ) file)
 
 b- To run separately this scenario, use the `@wireMock` tag in the CukesRunner class/Cucumber Options 
 

------------

2020 September&reg;
https://github.com/Ozleblebici

### End

------------



