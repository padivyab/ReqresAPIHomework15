package com.reqres.reqresdata;

import com.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DELETEData extends TestBase {

    @Test
    public void delete() {
        Response response = given()
                .when()
                .delete("/api/users/932");
        response.then().statusCode(204); //200
        response.prettyPrint();

    }
}
