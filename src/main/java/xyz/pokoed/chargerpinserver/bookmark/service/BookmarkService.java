package xyz.pokoed.chargerpinserver.bookmark.service;

import org.springframework.http.ResponseEntity;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkResponse;

public interface BookmarkService {
    public ResponseEntity<BookmarkResponse> add(BookmarkRequest request);
    public ResponseEntity<BookmarkResponse> delete(BookmarkRequest request);
}
