package io.petstoreAPI.stepDef;

import io.cucumber.java.en.*;
import io.petstoreAPI.pojoClasses.PetStatus;
import io.petstoreAPI.pojoClasses.Petstore;
import io.petstoreAPI.request.GetRequest;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.response.Response;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

@Slf4j
public class StepDefinitions {

    Response response;
    GetRequest getRequest = new GetRequest();
    int countOfValue;
    public static boolean mockFlag= false;

    Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    @Given("User send GET request to {string} endpoint")
    public void userSendGETRequestToEndpoint(String endPoint) {

        logger.info("TESTTTTTTTTTTTTTTT");

       response= getRequest.getWithEndPoint(endPoint);

    }

    @Given("User send GET request to {string} MOCK endpoint")
    public void userSendGETRequestToMockEndpoint(String endPoint) {

        mockFlag = true;
        response= getRequest.getWithEndPoint(endPoint);

    }

    @Then("Verify that response status code is {int} and content type is {string}")
    public void verifyThatResponseStatusCodeIsAndContentTypeIs(int statusCode, String contentType) {
        response.then().assertThat().statusCode(statusCode).contentType(contentType);
    }

    @When("User send a request for {string} pets status with query param")
    public void userSendARequestForPetsStatusWithQueryParam(String status) {
        Assert.assertEquals("Server is down!",200,response.getStatusCode());
        try {
            response = getRequest.getPetsByStatus(PetStatus.valueOf(status));

        } catch (IllegalArgumentException e) {
            Assert.fail("Wrong Pet Status value entered! Check your pet status!");
        }

    }

    @And("User fetches pets quantity which {string} is {string}")
    public void userFetchesPetsQuantityWhichIs(String key, String value) {

         Petstore[] allPets = response.body().as(Petstore[].class);

        for (Petstore pet : allPets) {
            if(pet.getName().equals(value)){
                countOfValue++;
            }
        }

    }
    @Then("Verify that correct pets quantity {int} should be present in the response")
    public void verify_that_correct_pets_quantity_should_be_present_in_the_response(int expectedCount) {
        Assert.assertTrue("!! Query returned that There is No Available Pets which names is 'doggie' in the result !!",countOfValue>0);

        Assert.assertEquals("--Expected Count is not same with actual one, because of the 'Varying Pet Store Live Service'!-- ",expectedCount,countOfValue);

    }


}
