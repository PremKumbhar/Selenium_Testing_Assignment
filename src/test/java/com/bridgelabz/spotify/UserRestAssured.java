package com.bridgelabz.spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserRestAssured {
    String token = "Bearer BQCT119uAC3XiZ-br3332qJV1L5KJ972KYztD4iVvSWMymt-apFUEzl-glGNjSJes0GmxYK8U" +
            "CCQ9t5vJi-8-yaIh0uDC1l8fIiI8dKiDJG3xCn6BkXQM-9dCeacoHBcLlnktkcDWqG8L4hTsBgdWLYmai7Nm9Pl" +
            "TxRsSvFZbSsGb1Pkz1m51HFtSa1Pv8VO2nALXth3xm1yk9rpxs51sInKbUn5l0N_g5-HE12ygZC3i5s7eiqHpu5" +
            "aBIWX3J6WTwldz7O5ytW8i2Xb1w9JC7jxwcN6RVsfWbmx7lZOj_ikNFv96TyK1bDEHI5TYB9d2oIap6FNug73sA";
    String userID = "31ynvrngrtfr5hclliqstvnpkttq";


    @Test
    public void getCurrentUserProfileApiExecution_ReturnSuccess(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me")
                .then().log().all().statusCode(200);
    }
    @Test
    public void getCurrentUser_Id(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        String userId = response.path("id");
        System.out.println("UserID : "+userId);

        String displayName = response.path("display_name");
        System.out.println("Display Name : "+displayName);
    }
    @Test
    public void getUserProfileApiExecution_ReturnSuccess(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/users/userId");
        response.prettyPrint();
    }
}
