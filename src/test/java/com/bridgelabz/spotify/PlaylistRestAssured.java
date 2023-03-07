package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlaylistRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8" +
            "UCCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9" +
            "PlTxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqH" +
            "pu5aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void createPlaylistApiExecution_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"My Favourite\",\n" +
                        "  \"description\": \"Added new playlist\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31ynvrngrtfr5hclliqstvnpkttq/playlists");
        response.then().assertThat().statusCode(201);
    }
    @Test
    public void addItemsToPlaylistApiExecution_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"uris\": [\n" +
                        "    \"spotify:track:3HiobOOpSpMsi95WBKPBYk\",\n" +
                        "    \"spotify:track:4km0RUkMMFdx8iDuq36o2w\"\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/tracks");
        response.then().assertThat().statusCode(201);
    }
    @Test
    public void getCurrentUserPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/playlists");
                response.prettyPrint();
    }
    @Test
    public void getPlaylistCoverImage_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/images");
        response.prettyPrint();
    }
    @Test
    public void getPlaylistItems_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/tracks?market=ID");
        response.prettyPrint();
    }
    @Test
    public void getPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv?market=ID");
        response.prettyPrint();
    }
    @Test
    public void getUsersPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/users/31ynvrngrtfr5hclliqstvnpkttq/playlists");
        response.prettyPrint();
    }
    @Test
    public void updatePlaylistItems_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .put("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/tracks");
        response.prettyPrint();
    }
    @Test
    public void changePlaylistDetails_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"Prem's My Favourite\",\n" +
                        "  \"description\": \"Update Playlist\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv");
    }
    @Test
    public void deletePlaylistItems_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{ \"tracks\": [{ \"uri\": \"spotify:track:3HiobOOpSpMsi95WBKPBYk\" }] }")
                .when()
                .put("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/tracks");
    }

}
