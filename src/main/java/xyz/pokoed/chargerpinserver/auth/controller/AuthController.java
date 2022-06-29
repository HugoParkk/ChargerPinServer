package xyz.pokoed.chargerpinserver.auth.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.pokoed.chargerpinserver.auth.model.UserRequest;
import xyz.pokoed.chargerpinserver.auth.service.AuthService;
import xyz.pokoed.chargerpinserver.auth.service.AuthServiceImpl;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/join")
    public Object join(@RequestBody UserRequest request) {
        log.info("/auth/join start");

        return authService.join(request);
    }
}
