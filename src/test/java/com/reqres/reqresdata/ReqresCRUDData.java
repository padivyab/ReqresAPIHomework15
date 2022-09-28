package com.reqres.reqresdata;

import com.reqres.model.ReqresPojo;
import com.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresCRUDData extends TestBase {

    @Test
    public void GetAllReqresData()
    {
        Response response = given()
                .when()
                .get("/api/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void CreateNewData()
    {
        ReqresPojo reqresPojo =new ReqresPojo();
        reqresPojo.setEmail("div12345@reqres.in");
        reqresPojo.setFirstname("Jaya");
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
    @Test
    public void UpdateData()
    {
        ReqresPojo reqresPojo =new ReqresPojo();
        reqresPojo.setEmail("divya567@reqres.in");
        reqresPojo.setFirstname("Kinjal");
        reqresPojo.setLastname("parmar");
        reqresPojo.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .patch("/api/users/338");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void delete() {
        Response response = given()
                .when()
                .delete("/api/users/932");
        response.then().statusCode(204); //200
        response.prettyPrint();

    }
    @Test
    public void GetDeleteData()
    {
        Response response= given()
                .when()
                .get("/api/users/932");
        response.then().statusCode(404);
        response.prettyPrint();
    }

}
