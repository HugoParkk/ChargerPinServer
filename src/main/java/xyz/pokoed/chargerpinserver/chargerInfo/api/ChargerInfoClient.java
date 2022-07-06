package xyz.pokoed.chargerpinserver.chargerInfo.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChargerInfoClient {

    private URI uri;

    public ResponseEntity<String> getChargerInfo(String keyword) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?ServiceKey=sd5MjLmHMkxewkmi6ycojnifRbgsYSBMJAMog7%2FmzHNQmQ0bf2jM5uAFwg9Wrm8TUmvCdB2WnWCKHF6D%2BbVCdA%3D%3D"+"&pageNo=1&numOfRows=10";
        url+="&addr=서초구 우면동".replace(" ", "%20");

        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = null;
        response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response;
    }

}
