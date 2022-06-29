package xyz.pokoed.chargerpinserver.auth.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userId;
    private String userPassword;
    private String userName;
}
