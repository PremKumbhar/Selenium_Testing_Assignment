package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LibraryRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8UCCQ9t5v" +
            "Ji-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9PlTxRsSvFZbSsGb" +
            "1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqHpu5aBIWX3J6WTwldz7O5ytW" +
            "8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void saveTracksForCurrentUser_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("[\"0brUwLxgvZUEyddRDfcb2Z\", \"4km0RUkMMFdx8iDuq36o2w\"]")
                .when()
                .put("https://api.spotify.com/v1/me/tracks");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void saveShowsForCurrentUser_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=2xZfhdq5uzPC4yFPY7VycG");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void saveEpisodesForCurrentUser_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("[\"10sjdR9g64IAaygyFKr9pQ\",\"4BywAgqYvLbdx9FxvQFmN0\"]")
                .when()
                .put("https://api.spotify.com/v1/me/episodes");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void saveAlbumForCurrentUser_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("[\"6LWZ330atfYF43nk7m3pKW\",\"0mNU7NPXsBH6NiWilJOz3c\"]")
                .when()
                .put("https://api.spotify.com/v1/me/albums");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void getUserSavedTrack_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        response.prettyPrint();
    }
    @Test
    public void getUserSavedShows_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        response.prettyPrint();
    }
    @Test
    public void getUserSavedEpisodes_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        response.prettyPrint();
    }
    @Test
    public void getUserSavedAlbums_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        response.prettyPrint();
    }
    @Test
    public void checkUserSavedTracks_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","0brUwLxgvZUEyddRDfcb2Z",
                        "ids","4km0RUkMMFdx8iDuq36o2w")
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains")
                .then().log().all().statusCode(200);
    }
    @Test
    public void checkUserSavedShows_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","2xZfhdq5uzPC4yFPY7VycG",
                        "ids","0WNSp9Hf6E8BNrtmgl9mV7")
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains")
                .then().log().all().statusCode(200);
    }
    @Test
    public void checkUserSavedEpisodes_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","10sjdR9g64IAaygyFKr9pQ",
                        "ids","4BywAgqYvLbdx9FxvQFmN0")
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains")
                .then().log().all().statusCode(200);
    }
    @Test
    public void checkUserSavedAlbums_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","6LWZ330atfYF43nk7m3pKW",
                        "ids","0mNU7NPXsBH6NiWilJOz3c")
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains")
                .then().log().all().statusCode(200);
    }
    @Test
    public void removeUserSavedTracks_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("ids","0brUwLxgvZUEyddRDfcb2Z")
                .when()
                .delete("https://api.spotify.com/v1/me/tracks")
                .then().log().all().statusCode(200);
    }
    @Test
    public void removeUserSavedShows_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("ids","2xZfhdq5uzPC4yFPY7VycG")
                .when()
                .delete("https://api.spotify.com/v1/me/shows")
                .then().log().all().statusCode(200);
    }
    @Test
    public void removeUserSavedEpisodes_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("ids","10sjdR9g64IAaygyFKr9pQ")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes")
                .then().log().all().statusCode(200);
    }
    @Test
    public void removeUserSavedAlbums_ReturnOkStatus(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("ids","6LWZ330atfYF43nk7m3pKW")
                .when()
                .delete("https://api.spotify.com/v1/me/albums")
                .then().log().all().statusCode(200);
    }
}
