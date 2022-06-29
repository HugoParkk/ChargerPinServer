package xyz.pokoed.chargerpinserver.chargerInfo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.pokoed.chargerpinserver.model.UserEntity;

@Slf4j
@RestController
public class ChargerInfoController {
    @PostMapping("/info")
    public Object searchCharger() {
        log.debug("/info start");

        UserEntity user = new UserEntity();
        user.setUserId("asdfasdf");
        user.setName("test");
        user.setPassword("afdsfsadf");

        log.info("return {}", user.toString());
        return user;
    }
}
