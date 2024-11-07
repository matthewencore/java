package org.example.OOP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Base64;


enum Link1CApi{
    ONE_C_ITS("client-program-access/search/login"),
    ONE_C_PROGRAM("client-program-access/search/login");
    private final String choice;

    Link1CApi(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}

abstract class Portal1CAPI{
    final private String url = "https://partner-api.1c.ru/api/";
    String user;
    String password;

    abstract void connect(String requestBody) throws URISyntaxException, IOException, InterruptedException;

    String getData(String user,String password){
        String catData = user + ":" + password;
        return Base64.getEncoder().encodeToString(catData.getBytes(StandardCharsets.UTF_8));
    }

    String getUrl(Link1CApi link1CApi){
         return url + link1CApi.getChoice();
    }
}

public class Inheritance extends Portal1CAPI  {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = "{\"login\": \"trina\"}"; // Запрос

        Portal1CAPI portal1CAPI = new Inheritance();
        portal1CAPI.connect(requestBody);
    }

    @Override
    void connect(String requestBody) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(super.getUrl(Link1CApi.ONE_C_ITS)))
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .header("Content-Type","application/json")
                .header("Authorization","Basic " + super.getData("api-login-61544","dba0190aee8149"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());

    }


}
