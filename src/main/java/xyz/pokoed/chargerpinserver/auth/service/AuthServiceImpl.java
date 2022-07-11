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

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    // 아래 Autowired 어노테이션 제거해도 될듯..?
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> join(UserRequest user) {
        if (userRepository.existsById(user.getUserId())) {
            return ResponseEntity.badRequest().body(new UserResponse(0, "존재하는 아이디입니다."));
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

    @Override
    public ResponseEntity<UserResponse> login(UserRequest user) {
        Optional<UserEntity> loginUser = userRepository.findById(user.getUserId());

        if (loginUser.isEmpty()) {
            return ResponseEntity.badRequest().body(new UserResponse(0, "해당 아이디의 유저가 존재하지 않습니다."));
        }
        if (!passwordEncoder.matches(user.getUserPassword(), loginUser.get().getPassword())) {
            return ResponseEntity.badRequest().body(new UserResponse(0, "비밀번호가 일치하지 않습니다."));
        }
        return ResponseEntity.ok(new UserResponse(1, "OK"));
    }

    @Override
    public ResponseEntity<UserResponse> update(UserRequest user) {
        if (!userRepository.existsById(user.getUserId())) {
            return ResponseEntity.badRequest().body(new UserResponse(0, "존재하지 않는 계정입니다."));
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
