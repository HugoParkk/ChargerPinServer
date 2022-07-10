package xyz.pokoed.chargerpinserver.bookmark.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkResponse;

@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    @Override
    public ResponseEntity<BookmarkResponse> add(BookmarkRequest request) {

        return ResponseEntity.ok(new BookmarkResponse());
    }

    @Override
    public ResponseEntity<BookmarkResponse> delete(BookmarkRequest request) {
        return ResponseEntity.ok(new BookmarkResponse());
    }
}
