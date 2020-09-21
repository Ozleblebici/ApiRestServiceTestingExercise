package io.petstoreAPI.request;


import io.petstoreAPI.baseUtilies.PetStatus;
import io.petstoreAPI.stepDef.Hooks;
import io.petstoreAPI.stepDef.StepDefinitions;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class GetRequest {

    Response response;
    String endPoint;

    public Response getWithEndPoint(String endPoint) {

        this.endPoint = endPoint;

        if (StepDefinitions.mockFlag) {
             response = Hooks.wireMockStub.getStubbedResponseBasic(endPoint);
        } else{
            response = given().get(endPoint);

            // swagger service was down, app will usez the json response file included with project
            // and instead of a client that calls a REST API make the client will read the file
            // and will return contents as a JSON string
            if (response.statusCode()!=200){
                response = Hooks.wireMockStub.getStubbedResponseBasic(endPoint);
            }
        }

        return response;
    }



    public Response getPetsByStatus(PetStatus petStatus) {

        if (StepDefinitions.mockFlag) {
            response = Hooks.wireMockStub.getStubbedResponse(petStatus, endPoint);
        } else {
            response = given().queryParam("status", petStatus.toString()).when()
                    .get(endPoint);
        }
        return response;
    }



}
