package com.workstation.demo.source;

import com.workstation.demo.config.UrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@Component
@Slf4j
public class MockSource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UrlConfig urlConfig;

    public List<Character> getAvengers() {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlConfig.getAvengers());
            log.info("calling mockey service to get avengers details");
            ResponseEntity<List<Character>> response = restTemplate.exchange(builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Character>>() {
                    });
          log.info("calling mockey service was successful");
            return response.getBody();

        } catch (RestClientException ex) {
            log.error("Failed to call mockey - avengers. " + ex.getMessage());
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
        }
    }
}
