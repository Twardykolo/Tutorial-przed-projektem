package com.tutorial.sandbox.Controller;

import com.tutorial.sandbox.DTO.Response.WeatherResponse;
import com.tutorial.sandbox.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{miasto}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable("miasto") String miasto){
        return ResponseEntity.ok(weatherService.getForecast(miasto));
    }
}
