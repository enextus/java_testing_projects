package com.telran.test;

import com.jayway.restassured.RestAssured;
import com.telran.dto.AuthRequestDto;
import com.telran.dto.AuthResponceDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredTest {

    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginPositiveTest() {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("aaaa2@gmail.com")
                .password("Ku_7854$Ku_7854$")
                .build();

        // gherkins language
        AuthResponceDto responceDto = given().contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .body("token", equalsTo(token))
                .extract().response().as(AuthResponceDto.class);

        System.out.println(responceDto.getToken());
    }


    @Test
    public void loginNegativeTest() {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("aaaa@gmail.com")
                .password("Ku7854$$Ku7854") // wrong
                .build();

        String message = given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(400)
                .extract().path("message");


        System.out.println("message: " + message);
    }

    @Test
    public void addContactTest1() {
        
    }

}
