package com.cbatest.Tests;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import com.cbatest.Data.config;

public class superVillainTest 
{
        
    String userName = RandomStringUtils.randomAlphabetic(10);
    String score = RandomStringUtils.randomNumeric(4);

    @Test
    public void GetUser() {
        given()
                .baseUri(config.BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
        .when()
                .get()
        .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void AddNewUser()
    {
        Map<String,Object> addUserPayload = new HashMap<String,Object>();
        addUserPayload.put("username", userName);
        addUserPayload.put("score", score);

        given()
                .baseUri(config.BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(addUserPayload)
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(201)
                .body("status", equalTo("success"))
                .body("message", equalTo("User added."))
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();             
    }

    @Test
    public void UpdateUser()
    {
        Map<String,Object> addUserPayload = new HashMap<String,Object>();
        addUserPayload.put("username", "Jenna36");
        addUserPayload.put("score", score);

        given()
                .baseUri(config.BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(addUserPayload)
        .when()
                .put()
        .then()
                .assertThat()
                .statusCode(204);        
    }

}
