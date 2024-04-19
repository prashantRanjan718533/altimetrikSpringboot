package com.twitterAPI.altimetrik.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class WeatherService {

    @Value("${api.key}")
    private String apiKey;
    private final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "https://weatherapi-com.p.rapidapi.com";
    private static final String API_HOST = "weatherapi-com.p.rapidapi.com";

    public String getCurrentWeather(String query) {

        return callWeatherAPI("/current.json", query);
    }

    public String getFutureWeather(String cityname) {
        return callWeatherAPI("/forecast.json", "q="+ cityname);
    }

    public String getWeatherByIP(String ip) {
        System.out.printf("getWeatherByIP=== "+ ip);
        return callWeatherAPI("/ip.json", "ip=" + ip);
    }

    private String callWeatherAPI(String endpoint, String queryParam) {
        String url = BASE_URL + endpoint + "?" + queryParam;
        System.out.printf("final url : "+url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", API_HOST)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.printf("Request failed: %s (HTTP %d)%n", response.message(), response.code());
                return "{\"error\": \"Error fetching weather data: " + response.message() + "\"}";
            }
            // Directly return the JSON string
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Error executing weather data request\"}";
        }
    }
}
