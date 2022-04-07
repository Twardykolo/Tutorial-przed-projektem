package com.tutorial.sandbox.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.sandbox.Config.YAMLConfiguration;
import com.tutorial.sandbox.DTO.Response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class WeatherService {

    @Autowired
    private YAMLConfiguration ymlCfg;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate;

    public WeatherResponse getForecast(String miasto){
        restTemplate = restTemplateBuilder.build();
        URI url = new UriTemplate(ymlCfg.getWeather().getUrl()).expand(miasto,ymlCfg.getWeather().getKey(),"metric","pl");
        System.out.println(url.toString());
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return responseTranslator(response);
    }

    private WeatherResponse responseTranslator(ResponseEntity<String> response){
        try{
            JsonNode root = objectMapper.readTree(response.getBody());
            return new WeatherResponse(
                    root.path("weather").get(0).path("main").asText(),
                    root.path("weather").get(0).path("description").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()));
        }catch (Exception e){
            System.out.println("JSON spadł z rowerka");
            return null;
        }
    }
}
