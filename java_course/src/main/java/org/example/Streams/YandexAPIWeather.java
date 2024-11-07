package org.example.Streams;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@JsonIgnoreProperties(ignoreUnknown = true)
class YandexAPIJSONStruct_Parts_Day_TempAvg {
    @JsonProperty("temp_avg")
    int temp_avg;

    public int getTemp_avg() {
        return temp_avg;
    }

    public YandexAPIJSONStruct_Parts_Day_TempAvg setTemp_avg(int temp_avg) {
        this.temp_avg = temp_avg;
        return this;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class YandexAPIJSONStruct_Parts {
    @JsonProperty("day")
    YandexAPIJSONStruct_Parts_Day_TempAvg day;

    public YandexAPIJSONStruct_Parts_Day_TempAvg getDay() {
        return day;
    }

    public YandexAPIJSONStruct_Parts setDay(YandexAPIJSONStruct_Parts_Day_TempAvg day) {
        this.day = day;
        return this;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class YandexAPIJSONStruct_Forecast {
    @JsonProperty("parts")
    YandexAPIJSONStruct_Parts parts;

    public YandexAPIJSONStruct_Parts getParts() {
        return parts;
    }

    public YandexAPIJSONStruct_Forecast setParts(YandexAPIJSONStruct_Parts parts) {
        this.parts = parts;
        return this;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class YandexAPIJSONStruct_Fact{
    @JsonProperty("temp")
    int temp;
    @JsonProperty("feels_like")
    int feels_like;
    @JsonProperty("temp_water")
    int temp_water;
    @JsonProperty("condition")
    String condition;

    public int getTemp() {
        return temp;
    }

    public YandexAPIJSONStruct_Fact setTemp(int temp) {
        this.temp = temp;
        return this;
    }

    public int getFeels_like() {
        return feels_like;
    }

    public YandexAPIJSONStruct_Fact setFeels_like(int feels_like) {
        this.feels_like = feels_like;
        return this;
    }

    public int getTemp_water() {
        return temp_water;
    }

    public YandexAPIJSONStruct_Fact setTemp_water(int temp_water) {
        this.temp_water = temp_water;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public YandexAPIJSONStruct_Fact setCondition(String condition) {
        this.condition = condition;
        return this;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class YandexAPIJSONStruct{
    String now_dt;
    @JsonProperty("fact")
    YandexAPIJSONStruct_Fact fact;
    @JsonProperty("forecasts")
    List<YandexAPIJSONStruct_Forecast> forecasts;

    public List<YandexAPIJSONStruct_Forecast> getForecasts() {
        return forecasts;
    }

    public YandexAPIJSONStruct setForecasts(List<YandexAPIJSONStruct_Forecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }


    public String getNow_dt() {
        return now_dt;
    }

    public YandexAPIJSONStruct setNow_dt(String now) {
        this.now_dt = now;
        return this;
    }
}

class YandexWeatherAPI {

    private final String urlAPI = "https://api.weather.yandex.ru/v2/";
    private String apiKey;

    //Блок гетеров и сетторов
    public String getUrlAPI() {
        return urlAPI;
    }

    public YandexWeatherAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getURL(double lat, double lon) {
        return String.format("%sforecast?lat=%s&lon=%s",getUrlAPI(),lat,lon);
    }
    //Конец блока

    String weatherReport(double lat, double lon) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(getURL(lat,lon)))
                .header("Content-Type","application/json")
                .header("X-Yandex-Weather-Key",getApiKey())
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
        }


    YandexAPIJSONStruct deserializeJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        YandexAPIJSONStruct yandexWeatherAPI = null;

        yandexWeatherAPI = objectMapper.readValue(json,YandexAPIJSONStruct.class);

        return yandexWeatherAPI;
    }

    }

public class YandexAPIWeather {
    public static void main(String[] args) {
        YandexWeatherAPI yandex = new YandexWeatherAPI("32a17e21-e0a3-46f0-ba5b-6ff5f3c590fa");
        String jsonResponse = "";
        try {
            jsonResponse = yandex.weatherReport(1,9);
            System.out.println(jsonResponse);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            System.err.printf("Произошла ошибка, подробности ниже \n |--> %s",e.getMessage());
        }

        try {
            YandexAPIJSONStruct struct = yandex.deserializeJson(jsonResponse);
            Instant instant = Instant.parse(struct.getNow_dt());
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
            String dateFormat = String.format("%s-%s-%s",dateTime.getDayOfMonth(),dateTime.getMonth(),dateTime.getYear());

            YandexAPIJSONStruct_Forecast forecast = new YandexAPIJSONStruct_Forecast();
            forecast.parts.day.setTemp_avg(0);

            if (!struct.forecasts.isEmpty()){
                forecast = struct.forecasts.get(0);
            } else {
                System.out.println(" | Де-сериализация: Возникла ошибка, объект forecast пуст ");
            }


            System.out.printf(
                    "Текущая дата: %s\nТемпература: %s\nСредняя температура: %s",
                    dateFormat,
                    struct.fact.getTemp(),
                    struct.forecasts.getFirst().parts.day.getTemp_avg()
            );

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
