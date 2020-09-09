package io.petstoreAPI.request;

import io.petstoreAPI.mock.WireMockStub;
import io.petstoreAPI.pojoClasses.PetStatus;
import io.petstoreAPI.stepDef.Hooks;
import io.petstoreAPI.stepDef.StepDefinitions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.net.ConnectException;

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
        }

        return response;
    }



    public Response getPetsByStatus(PetStatus petStatus) {


        if (StepDefinitions.mockFlag) {
            response = Hooks.wireMockStub.getStubbedResponse(petStatus, endPoint);
        } else {
            response = given().param("status", petStatus.toString()).when()
                    .get(endPoint);

        }
        return response;
    }



}
