package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EpisodesRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0Gm" +
            "xYK8UCCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWL" +
            "Ymai7Nm9PlTxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12y" +
            "gZC3i5s7eiqHpu5aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getEpisodes_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .pathParam("id","10sjdR9g64IAaygyFKr9pQ")
                .when()
                .get("https://api.spotify.com/v1/episodes/{id}");
        response.prettyPrint();
    }
    @Test
    public void getSeveralEpisodes_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .queryParams("ids","10sjdR9g64IAaygyFKr9pQ","ids","4BywAgqYvLbdx9FxvQFmN0")
                .when()
                .get("https://api.spotify.com/v1/episodes");
        response.prettyPrint();
    }
}
