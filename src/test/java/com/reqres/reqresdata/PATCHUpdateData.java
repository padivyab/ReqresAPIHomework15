package com.reqres.reqresdata;

import com.reqres.model.ReqresPojo;
import com.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PATCHUpdateData extends TestBase {

    @Test
    public void UpdateData()
    {
        ReqresPojo reqresPojo =new ReqresPojo();
        reqresPojo.setEmail("div1234@reqres.in");
        reqresPojo.setFirstname("jay");
        reqresPojo.setLastname("Patel");
        reqresPojo.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .patch("/api/users/932");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
