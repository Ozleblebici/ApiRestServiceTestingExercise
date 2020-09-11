package io.petstoreAPI.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.petstoreAPI.baseUtilies.ConfigurationReader;
import io.petstoreAPI.mock.WireMockStub;
import io.restassured.RestAssured;

public class Hooks {

    public static WireMockStub wireMockStub = new WireMockStub();

    @Before
    public void setup(){
        RestAssured.baseURI= ConfigurationReader.get("base_uri");
        RestAssured.basePath= ConfigurationReader.get("base_path");
    }
    @After
    public void tearDown(){

    }

    @Before("@wireMock")
    public void setupWireMock(){

        wireMockStub.setup();
    }


    @After ("@wireMock")
    public void tearDownWireMock(){

        wireMockStub.teardown();
    }



}
