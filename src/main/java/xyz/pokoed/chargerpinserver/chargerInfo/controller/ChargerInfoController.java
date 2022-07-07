package xyz.pokoed.chargerpinserver.chargerInfo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.pokoed.chargerpinserver.chargerInfo.api.ChargerInfoClient;
import xyz.pokoed.chargerpinserver.chargerInfo.model.ChargerInfoRequest;
import xyz.pokoed.chargerpinserver.chargerInfo.service.ChargerInfoServiceImpl;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/charger")
public class ChargerInfoController {
    private ChargerInfoServiceImpl chargerInfoService;
    private ChargerInfoClient chargerInfoClient;

    @PostMapping("/info")
    public Object searchCharger(@RequestBody ChargerInfoRequest request) {
        log.debug("/info start");

//        log.info("{}", request.getKeyword());

        // 위치, 이름 모두 됨
        return chargerInfoService.searchInfo(request.getKeyword());
    }
}
