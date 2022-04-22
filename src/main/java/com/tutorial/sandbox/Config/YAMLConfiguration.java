package com.tutorial.sandbox.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "moj-config")
@Getter
@Setter
public class YAMLConfiguration {

    private final Weather weather = new Weather();
    private final Coctail coctail = new Coctail();

    @Getter
    @Setter
    public static class Weather{
        private String url;
        private String key;
    }

    @Getter
    @Setter
    public static class Coctail{
        private String url;
        private String key;
    }
}