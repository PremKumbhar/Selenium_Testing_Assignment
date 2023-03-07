package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TrackRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8U" +
            "CCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9Pl" +
            "TxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqHpu5" +
            "aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getTrack_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/tracks/0brUwLxgvZUEyddRDfcb2Z?market=ID");
        response.prettyPrint();
    }
    @Test
    public void getSeveralTrack_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/tracks?market=ID&ids=4km0RUkMMFdx8iDuq36o2w%2C0brUwLxgvZUEyddRDfcb2Z");
        response.prettyPrint();
    }
    @Test
    public void getTrackAudioFeatures_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/audio-features/0brUwLxgvZUEyddRDfcb2Z");
        response.prettyPrint();
    }
    @Test
    public void getTracksAudioFeatures_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/audio-features?ids=0brUwLxgvZUEyddRDfcb2Z%2C4km0RUkMMFdx8iDuq36o2w");
        response.prettyPrint();
    }

}
