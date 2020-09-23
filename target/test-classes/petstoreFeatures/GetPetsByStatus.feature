@petStoreApi
Feature: Validate how many pets have the status “available” and the name “doggie”

    @liveApi
  Scenario: Validate pets quantity with getPetsByStatus method in live Api server
    Given User send GET request to "pet/findByStatus" endpoint
    Then Verify that response status code is 200 and content type is "application/json"
    When User send a request for "available" pets status with query param
    And User fetches pets quantity which "name" is "doggie"
    Then Verify that correct pets quantity 157 should be present in the response



    @wireMock
  Scenario: Validate pets quantity with getPetsByStatus method in WireMock server
    Given User send GET request to "pet/findByStatus" MOCK endpoint
    Then Verify that response status code is 200 and content type is "application/json"
    When User send a request for "available" pets status with query param
    And User fetches pets quantity which "name" is "doggie"
    Then Verify that correct pets quantity 10 should be present in the response





#    TODO json file read u can add
#    If for any reason the swagger service was down, please use the json response file included
#with this pack and instead of a client that calls a REST API make the client just read the file
#and return contents as a JSON string. The test can then perform the same validation as
#described above.

