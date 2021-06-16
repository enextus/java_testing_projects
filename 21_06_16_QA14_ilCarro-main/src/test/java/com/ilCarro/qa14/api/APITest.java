package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APITest {

    String baseURL = "https://java-3-ilcarro-team-b.herokuapp.com";

    @Test
    public void loginRegisteredUserPositiveTest() throws IOException {
        String response = getAuthorizationUser(baseURL+"/user/login",
                "Authorization", "dGVzdGVyQkBiLmNvOjEyMzQ1NjdCYg==");

        System.out.println(response);

        JsonObject parsedObject = JsonParser.parseString(response).getAsJsonObject();

        JsonElement name = parsedObject.get("first_name");
        Assert.assertEquals(name.toString(),"\"TesterB\"");

        JsonElement registration_date = parsedObject.get("registration_date");
        Assert.assertEquals(registration_date.toString(),"\"2021-05-20\"");
    }

    public String getAuthorizationUser(String controller, String key, String value) throws IOException {
        return Request.Get(controller)
                .addHeader(key, value)
                .execute().returnContent().asString();
    }

    @Test
    public void loginRegisteredUserNegativeTest() throws IOException {
        int statusCode = Request.Get(baseURL + "/user/login")
                .addHeader("Authorization", "VzdGVyQkBiLmNvOjEyMzQ1NjdCYg==")
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,400);
    }

    @Test
    public void postNewUserRegistrationTest() throws IOException {
        String response = Request.Post(baseURL + "/registration")
                .addHeader("Authorization", "VGVzdHF3ZWU6VGVzdGVydGVydGVy")
                .bodyString("{\n" +
                        "  \"first_name\": \"Testqwee\",\n" +
                        "  \"second_name\": \"Testerterter\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();

        System.out.println(response);
    }

}
