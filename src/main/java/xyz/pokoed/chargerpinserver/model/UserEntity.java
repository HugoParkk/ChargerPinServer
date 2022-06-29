package xyz.pokoed.chargerpinserver.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String name;
}
