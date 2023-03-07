package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ShowRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8UCCQ9t" +
            "5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9PlTxRsSvFZbS" +
            "sGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqHpu5aBIWX3J6WTwldz7" +
            "O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";

    @Test
    public void getShow_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/shows/2xZfhdq5uzPC4yFPY7VycG");
        response.prettyPrint();
    }
    @Test
    public void getShowEpisodes_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/shows/2xZfhdq5uzPC4yFPY7VycG/episodes?market=ID");
        response.prettyPrint();
    }
    @Test
    public void getSeveralShows_ReturnOkStatus(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/shows?ids=2xZfhdq5uzPC4yFPY7VycG%2C0WNSp9Hf6E8BNrtmgl9mV7");
        response.prettyPrint();
    }
}
