package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AlbumRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0Gmx" +
            "YK8UCCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYm" +
            "ai7Nm9PlTxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC" +
            "3i5s7eiqHpu5aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getAlbum_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","6LWZ330atfYF43nk7m3pKW")
                .when()
                .get("https://api.spotify.com/v1/albums/{id}");
        response.prettyPrint();
    }
    @Test
    public void getSeveralAlbum_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","6LWZ330atfYF43nk7m3pKW","ids","0mNU7NPXsBH6NiWilJOz3c")
                .when()
                .get("https://api.spotify.com/v1/albums");
        response.prettyPrint();
    }
    @Test
    public void getAlbumTrack_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","6LWZ330atfYF43nk7m3pKW")
                .when()
                .get("https://api.spotify.com/v1/albums/{id}/tracks");
        response.prettyPrint();
    }
}
