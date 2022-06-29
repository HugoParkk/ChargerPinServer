package xyz.pokoed.chargerpinserver.auth.service;

import org.springframework.http.ResponseEntity;
import xyz.pokoed.chargerpinserver.auth.model.UserRequest;
import xyz.pokoed.chargerpinserver.auth.model.UserResponse;
import xyz.pokoed.chargerpinserver.model.UserEntity;

public interface AuthService {
    public ResponseEntity<UserResponse> join (UserRequest user);
    public ResponseEntity<UserResponse> login (UserRequest user);
}
