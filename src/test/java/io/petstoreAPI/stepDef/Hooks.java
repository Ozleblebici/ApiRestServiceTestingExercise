package io.petstoreAPI.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.petstoreAPI.baseUtilies.ConfigurationReader;
import io.petstoreAPI.mock.WireMockStub;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;

public class Hooks {

    public static WireMockStub wireMockStub = new WireMockStub();

    private final static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void setup(){
        RestAssured.baseURI= ConfigurationReader.get("base_uri");
        RestAssured.basePath= ConfigurationReader.get("base_path");
        logger.info("Before Setup Started");
    }
    @After
    public void tearDown(){

        logger.info("After TearDown");

    }

    @Before("@wireMock")
    public void setupWireMock(){
        logger.info("Before Setup Started with WireMock");
        wireMockStub.setup();
    }


    @After ("@wireMock")
    public void tearDownWireMock(){

        logger.info("After TearDown with WireMock");
        wireMockStub.teardown();
    }



}
