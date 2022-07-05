package xyz.pokoed.chargerpinserver.chargerInfo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.pokoed.chargerpinserver.chargerInfo.api.ChargerInfoClient;
import xyz.pokoed.chargerpinserver.chargerInfo.service.ChargerInfoServiceImpl;
import xyz.pokoed.chargerpinserver.model.UserEntity;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/charger")
public class ChargerInfoController {
    private ChargerInfoServiceImpl chargerInfoService;
    private ChargerInfoClient chargerInfoClient;

    @PostMapping("/info")
    public Object searchCharger() {
        log.debug("/info start");


//        log.info("return {}", );
        return chargerInfoClient.getChargerInfo("");
    }
}
