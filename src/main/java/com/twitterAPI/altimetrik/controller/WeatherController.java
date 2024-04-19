package com.twitterAPI.altimetrik.controller;

import com.twitterAPI.altimetrik.config.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public String getCurrentWeather(@RequestParam String query) {
        return weatherService.getCurrentWeather(query);
    }

    @GetMapping("/future/cityname/{cityname}")
    public String getFutureWeather(@PathVariable String cityname) {
        return weatherService.getFutureWeather(cityname);
    }//sample url for test : http://localhost:8080/future/cityname/london
    // one can use any other city name insted of london , eg delhi, bangalore.

    @GetMapping("/weather/ip/{ip}")
    public String getWeatherByIP(@PathVariable String ip) {
        System.out.printf("ip=== "+ ip);
        return weatherService.getWeatherByIP(ip);
    } //sample url for test : http://localhost:8080/weather/ip/182.69.180.249
}

