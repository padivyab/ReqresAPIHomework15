package com.reqres.reqresdata;

import com.reqres.model.ReqresPojo;
import com.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class POSTCreateData extends TestBase {

    @Test
    public void CreateNewData()
    {
        ReqresPojo reqresPojo =new ReqresPojo();
        reqresPojo.setEmail("div1234@reqres.in");
        reqresPojo.setFirstname("Jay");
        reqresPojo.setLastname("Patel");
        reqresPojo.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .post("/api/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
