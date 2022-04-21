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
public class YoConfig {

    private final Yo yo = new Yo();

    @Getter
    @Setter
    public static class Yo{
        private String link;
    }
}
