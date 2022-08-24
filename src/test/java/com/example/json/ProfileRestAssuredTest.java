package com.example.json;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class ProfileRestAssuredTest {
    @Test
    public void aPostRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 28,\n" +
                        "    \"name\": \"Pranali Sanjay Rane\",\n" +
                        "    \"Address\" : \"Shram Safalya , Jalgaon\",\n" +
                        "    \"Email\" : \"ranepranali@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void bGetRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void cPutRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 33,\n" +
                        "    \"name\": \"Pranali Sanjay Rane\",\n" +
                        "    \"Address\" : \"Sanjivani Nagar, plot no.4015, Nashik\",\n" +
                        "    \"Email\" : \"prashi2805@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile/33");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void dDeleteRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/profile/28");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
