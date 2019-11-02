package me.whiteship.ksug2019.study;

import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberServiceClient {

    private RestTemplate restTemplate;

    public MemberServiceClient(RestTemplateBuilder restTemplateBuilder, AppProperties appProperties) {
        this.restTemplate = restTemplateBuilder
                .rootUri(appProperties.getMemberServiceRootUri()).build();
    }

    public void validate(String username) {
        ResponseEntity<String> response = restTemplate.getForEntity("/{username}", String.class, username);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("wrong member username '" + username + "'");
        }
    }
}
