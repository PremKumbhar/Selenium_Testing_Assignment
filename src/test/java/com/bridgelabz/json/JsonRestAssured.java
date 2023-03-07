package com.bridgelabz.json;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonRestAssured {

    @Test
    public void getFromLocalJsonServer_Posts(){
        given()
                .get("http://localhost:3000/posts")
                .then().log().all().statusCode(200);
    }
    @Test
    public void createPostFromLocalJsonServer_Posts(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"id\": 6,\n" +
                        "    \"name\": \"Prem\",\n" +
                        "    \"email\": \"premk123@gmail.com\"\n" +
                        "  }")
                .when()
                .post("http://localhost:3000/posts");
    }
    @Test
    public void getSpecificPostsFromLocalJsonServer_Posts(){
        given()
                .get("http://localhost:3000/posts/3")
                .then().log().all().statusCode(200);
    }
    @Test
    public void updateDataFromLocalJsonServer_Posts(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Prem\",\n" +
                        "    \"email\": \"premk123456789@gmail.com\"\n" +
                        "  }")
                .pathParam("id","1")
                .when()
                .put("http://localhost:3000/posts/{id}")
                .then().log().all().statusCode(200);
    }
    @Test
    public void updateSpecificDataFromLocalJsonServer_Posts(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "   \"email\": \"premk123@gmail.com\"\n" +
                        "}")
                .when()
                .patch("http://localhost:3000/posts/5")
                .then().log().all().statusCode(200);
    }
    @Test
    public void deleteIdFromLocalJsonServer_Posts(){
        given()
                .delete("http://localhost:3000/posts/6")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getCommentFromLocalJsonServer_Comments(){
        given()
                .get("http://localhost:3000/comments")
                .then().log().all().statusCode(200);
    }
    @Test
    public void createNewComment_Comments(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"body\": \"some comment\",\n" +
                        "    \"postId\": 2\n" +
                        "  }")
                .when()
                .post("http://localhost:3000/comments");

    }
    @Test
    public void getSpecificCommentFromLocalJsonServer_Comments(){
        given()
                .get("http://localhost:3000/comments/2")
                .then().log().all().statusCode(200);
    }
    @Test
    public void updateDataFromLocalJsonServer_Comments(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"body\": \"Hello\",\n" +
                        "    \"postId\": 2\n" +
                        "  }")
                .when()
                .put("http://localhost:3000/comments/2")
                .then().log().all().statusCode(200);
    }
    @Test
    public void updateSpecificDataFromLocalJsonServer_Comments(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\"body\": \"Hello Prem\"}")
                .when()
                .patch("http://localhost:3000/comments/2")
                .then().log().all().statusCode(200);
    }
    @Test
    public void deleteCommentsFromLocalJsonServer_Comments(){
        given()
                .delete("http://localhost:3000/comments/3")
                .then().log().all().statusCode(200);
    }
    @Test
    public void getFromLocalJsonServer_Profile(){
        given()
                .get("http://localhost:3000/profile")
                .then().log().all().statusCode(200);
    }
    @Test
    public void postFromLocalJsonServer_Profile(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"name\": \"Prem\",\n" +
                        "  \"postId\": 2\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
    }
    @Test
    public void updateDataFromLocalJsonServer_Profile(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": \"Prem Kumbhar\",\n" +
                        "  \"postId\": 1\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile")
                .then().log().all().statusCode(200);
    }
    @Test
    public void updateSpecificDataFromLocalJsonServer_Profile(){
        given().contentType("application/json")
                .accept("application/json")
                .body("{\"name\": \"Prem D Kumbhar\"}")
                .when()
                .patch("http://localhost:3000/profile")
                .then().log().all().statusCode(200);
    }



}
