package com.example.json;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class CommmentsRestAssuredTest {
    @Test
    public void aPostRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "    \"id\": 11,\n" +
                        "    \"body\": \"Hello\",\n" +
                        "    \"postId\": 2\n" +
                        "\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": 12,\n" +
                        "    \"body\": \"Welcome\",\n" +
                        "    \"postId\": 4\n" +
                        "}\n" +
                        "]")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void bGetRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void cPutRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"body\": \"Username is Pranali\",\n" +
                        "        \"postId\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"body\": \"Username is Akshay\",\n" +
                        "        \"postId\": 2\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/comments/1");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void dDeleteRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/comments/11");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}
