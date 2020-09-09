package io.petstoreAPI.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.petstoreAPI.baseUtilies.ConfigurationReader;
import io.restassured.RestAssured;

public class Hooks {



    @Before
    public void setup(){
        RestAssured.baseURI= ConfigurationReader.get("base_uri");
        RestAssured.basePath= ConfigurationReader.get("base_path");


    }

    @After
    public void tearDown(){

    }

}
