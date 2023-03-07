package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BrowseRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8" +
            "UCCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9" +
            "PlTxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqH" +
            "pu5aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getRecommendations_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("seed_artists","3GDW9IVihALy2ArcOI2HLZ")
                .queryParam("seed_tracks","72bz6jRhRr22PQY16hRyKU")
                .when()
                .get("https://api.spotify.com/v1/recommendations?seed_genres=soul");
        response.prettyPrint();
    }
    @Test
    public void getNewRelease_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");
        response.prettyPrint();
    }
    @Test
    public void getFeaturedPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        response.prettyPrint();
    }
    @Test
    public void getCategoryPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParams("category_id","dinner")
                .when()
                .get("https://api.spotify.com/v1/browse/categories/{category_id}/playlists");
        response.prettyPrint();
    }
    @Test
    public void getSingleBrowseCategoryPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParams("category_id","sleep")
                .when()
                .get("https://api.spotify.com/v1/browse/categories/{category_id}/playlists");
        response.prettyPrint();
    }
    @Test
    public void getSeveralBrowseCategoryPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        response.prettyPrint();
    }
    @Test
    public void getAvailableGenreSeeds_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        response.prettyPrint();
    }
}
