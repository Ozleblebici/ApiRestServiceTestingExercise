package io.petstoreAPI.request;

import io.petstoreAPI.pojoClasses.PetStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetRequest {

    Response response;
    String endPoint;

    public Response getWithEndPoint(String endPoint) {

        this.endPoint = endPoint;
        response = given().get(endPoint);

        if (response.getStatusCode() != 200) {
            // TODO  Set and connect getMockResponse(petStatus);
            Assert.fail("Check API Services/ Status Code");

        }

        return response;
    }

    public Response getPetsByStatus(PetStatus petStatus) {

        response = given().param("status", petStatus.toString()).when()
                .get(endPoint);

        if (response.getStatusCode() != 200) {
//         TODO  Set and connect getMockResponse(petStatus);
            Assert.fail("Check API Services/ Status Code");
        }
        return response;
    }


}
