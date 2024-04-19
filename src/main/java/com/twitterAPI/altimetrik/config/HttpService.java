package com.twitterAPI.altimetrik.config;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class HttpService {

    public HttpService() throws IOException {
    }
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://weatherapi-com.p.rapidapi.com/current.json?q=56%2C-0.17")
            .get()
            .addHeader("X-RapidAPI-Key", "d124fd807emshf091d20ba0b384bp19f223jsn524d7f07cada")
            .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
            .build();

    Response response = client.newCall(request).execute();

}
