package xyz.pokoed.chargerpinserver.bookmark.service;

import org.springframework.http.ResponseEntity;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkResponse;
import xyz.pokoed.chargerpinserver.model.UserBookmarkChargerEntity;

import java.util.List;

public interface BookmarkService {
    public ResponseEntity<BookmarkResponse> add(BookmarkRequest request);
    public ResponseEntity<List<UserBookmarkChargerEntity>> read(String userId);
    public ResponseEntity<BookmarkResponse> update(BookmarkRequest request);
    public ResponseEntity<BookmarkResponse> delete(Long id);
    public ResponseEntity<BookmarkResponse> deleteByChargerId(int id, String userId);
}
