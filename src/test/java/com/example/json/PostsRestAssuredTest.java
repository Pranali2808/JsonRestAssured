package com.example.json;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class PostsRestAssuredTest {
    @Test
    public void aPostRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Pranali\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Akshay\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .post("http://localhost:3000/posts");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void bGetRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void cputRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Kanchan\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Soham\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/posts/1");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void dDeleteRequestForPosts() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/posts/3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}