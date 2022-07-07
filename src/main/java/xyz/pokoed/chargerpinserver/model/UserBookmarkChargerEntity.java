package xyz.pokoed.chargerpinserver.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_bookmark")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBookmarkChargerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @Column(nullable = false)
    private String chargerName;

    @Column(nullable = false)
    private String userId;
}
