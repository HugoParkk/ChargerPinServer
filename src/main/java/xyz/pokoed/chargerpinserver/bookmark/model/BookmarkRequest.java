package xyz.pokoed.chargerpinserver.bookmark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkRequest {
    private Long bookmarkId;
    private String chargerName;
    private int chargerId;
    private String userId;
}
