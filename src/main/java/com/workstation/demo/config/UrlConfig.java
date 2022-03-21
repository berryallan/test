package com.workstation.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties("urls")
public class UrlConfig {
    private String avengers;
    private String antiHeroes;
    private String mutant;
}
