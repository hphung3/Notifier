package com.harrisonphung.Notifier.config;

import com.harrisonphung.Notifier.message.Messenger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by harrisonphung on 1/4/19.
 */
@Configuration
public class AppConfig {

    @Bean
    public Messenger getTwilioMessenger(TwilioConfiguration twilioConfiguration){
        return new Messenger(twilioConfiguration);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/users").allowedOrigins("http://localhost:9090");
            }
        };
    }
}
