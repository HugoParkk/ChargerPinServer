package xyz.pokoed.chargerpinserver.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userId;
    private String userPassword;
    private String userName;
}
