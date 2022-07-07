package xyz.pokoed.chargerpinserver.chargerInfo.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.pokoed.chargerpinserver.chargerInfo.model.ChargerInfoResponse;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChargerInfoClient {

    private URI uri;

    public ResponseEntity<String> getChargerInfo(String keyword) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?ServiceKey=sd5MjLmHMkxewkmi6ycojnifRbgsYSBMJAMog7%2FmzHNQmQ0bf2jM5uAFwg9Wrm8TUmvCdB2WnWCKHF6D%2BbVCdA%3D%3D";
        url += "&pageNo=1";
        url += "&numOfRows=10";

        if (!keyword.isEmpty()) {
            url+= String.format("&addr=%s", keyword).replace(" ", "%20");
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
