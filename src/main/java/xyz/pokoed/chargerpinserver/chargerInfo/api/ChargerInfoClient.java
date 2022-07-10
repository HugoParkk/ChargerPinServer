package xyz.pokoed.chargerpinserver.chargerInfo.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import xyz.pokoed.chargerpinserver.chargerInfo.model.ChargerInfoResponse;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChargerInfoClient {

    @Value("${value.serviceKey}")
    private String serviceKey;

    private URI uri;


    public ResponseEntity<String> getChargerInfo(String keyword) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromUriString("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList")
                .queryParam("ServiceKey", serviceKey)
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 10)
                .build(true).encode().toString();
        if (!keyword.isEmpty()) {
            url += String.format("&addr=%s", keyword.replace(" ", "%20"));
        } else {
            return ResponseEntity.badRequest().body("0");
        }

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
