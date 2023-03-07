package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ArtistsRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes" +
            "0GmxYK8UCCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hT" +
            "sBgdWLYmai7Nm9PlTxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N" +
            "_g5-HE12ygZC3i5s7eiqHpu5aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv9" +
            "6TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getSeveralArtists_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","4YRxDV8wJFPHPTeXepOstw","ids","4rgPItfFsz5c623LYz1OMA")
                .when()
                .get("https://api.spotify.com/v1/artists");
        response.prettyPrint();
    }
    @Test
    public void getArtists_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","4YRxDV8wJFPHPTeXepOstw")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}");
        response.prettyPrint();
    }
    @Test
    public void getArtistsTopTrack_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .when()
                .get("https://api.spotify.com/v1/artists/4YRxDV8wJFPHPTeXepOstw/top-tracks?market=ID");
        response.prettyPrint();
    }
    @Test
    public void getArtistsRelatedArtist_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","4YRxDV8wJFPHPTeXepOstw")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}/related-artists");
        response.prettyPrint();
    }
    @Test
    public void getArtistsRelatedAlbums_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","4YRxDV8wJFPHPTeXepOstw")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}/albums");
        response.prettyPrint();
    }
}
