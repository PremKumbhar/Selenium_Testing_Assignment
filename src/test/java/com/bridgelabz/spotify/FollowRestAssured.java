package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FollowRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8UCCQ9t5" +
            "vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9PlTxRsSvFZbSsG" +
            "b1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqHpu5aBIWX3J6WTwldz7O5y" +
            "tW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void followPlaylistForUser_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("playlist_id","0wX1bVoQoUdEVEh4mF5Hlv")
                .when()
                .put("https://api.spotify.com/v1/playlists/{playlist_id}/followers");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void checkIfUserFollowPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/playlists/0wX1bVoQoUdEVEh4mF5Hlv/followers/contains?ids=31ynvrngrtfr5hclliqstvnpkttq");
        response.prettyPrint();
    }
    @Test
    public void getFollowedArtist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist");
        response.prettyPrint();
    }
    @Test
    public void checkIfUserFollowArtist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=4YRxDV8wJFPHPTeXepOstw");
        response.prettyPrint();
    }
    @Test
    public void unfollowPlaylist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("playlist_id","1z3nshPZJG0Ss52beN4dug")
                .when()
                .delete("https://api.spotify.com/v1/playlists/{playlist_id}/followers");
        response.prettyPrint();
    }
    @Test
    public void unfollowArtist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParam("ids","4rgPItfFsz5c623LYz1OMA")
                .when()
                .delete("https://api.spotify.com/v1/me/following?type=artist");
        response.prettyPrint();
    }
}
