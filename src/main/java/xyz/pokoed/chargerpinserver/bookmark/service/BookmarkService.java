package xyz.pokoed.chargerpinserver.bookmark.service;

import org.springframework.http.ResponseEntity;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkResponse;

import java.util.List;

public interface BookmarkService {
    public ResponseEntity<BookmarkResponse> add(BookmarkRequest request);
    public List<ResponseEntity<BookmarkResponse>> read(String userId);
    public ResponseEntity<BookmarkResponse> delete(BookmarkRequest request);
}
