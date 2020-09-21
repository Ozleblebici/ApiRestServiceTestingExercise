package io.petstoreAPI.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.petstoreAPI.baseUtilies.ConfigurationReader;
import io.petstoreAPI.baseUtilies.PetStatus;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockStub {

   WireMockServer wireMockServer;

   int port = Integer.parseInt(ConfigurationReader.get("wireMock_port_number"));

    public void setup () {
        wireMockServer = new WireMockServer(port);
        wireMockServer.start();
        setupStub();
    }

    public void setupStub() {
        wireMockServer.stubFor(get(urlEqualTo("/v2/pet/findByStatus?status=available"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBodyFile("data/pets.json")));

    }


    public Response getStubbedResponse( PetStatus petStatus, String endPoint) {
       Response response= given().
                when().
                get("http://localhost:"+port+ "/v2/"+ endPoint +"?status="+ petStatus.toString());
       return response;
    }

    public Response getStubbedResponseBasic( String endPoint) {
        Response response= given().
                when().
                get("http://localhost:"+port+ "/v2/"+ endPoint +"?status=available");
        return response;
    }

    public void teardown () {
        wireMockServer.stop();
    }
}
