package xyz.pokoed.chargerpinserver.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.pokoed.chargerpinserver.auth.model.UserRequest;
import xyz.pokoed.chargerpinserver.auth.model.UserResponse;
import xyz.pokoed.chargerpinserver.model.UserEntity;
import xyz.pokoed.chargerpinserver.repository.UserRepository;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> login(UserRequest user) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> join(UserRequest user) {
        if (userRepository.existsById(user.getUserId())) {
            return ResponseEntity.badRequest().body(new UserResponse(0, "userId exists."));
        }
        String password = passwordEncoder.encode(user.getUserPassword());
        UserEntity userEntity = UserEntity.builder()
                .userId(user.getUserId())
                .password(password)
                .name(user.getUserName())
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok(new UserResponse(1, "OK"));
    }
}
