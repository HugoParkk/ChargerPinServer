package xyz.pokoed.chargerpinserver.chargerInfo.service;

import org.springframework.http.ResponseEntity;

public interface ChargerInfoService {
    public ResponseEntity<String> searchInfo (String keyword);

}
