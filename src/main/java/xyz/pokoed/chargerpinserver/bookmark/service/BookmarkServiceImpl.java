package xyz.pokoed.chargerpinserver.bookmark.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkResponse;
import xyz.pokoed.chargerpinserver.model.UserBookmarkChargerEntity;
import xyz.pokoed.chargerpinserver.repository.UserBookmarkChargerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {
    private UserBookmarkChargerRepository userBookmarkChargerRepository;

    @Override
    public ResponseEntity<BookmarkResponse> add(BookmarkRequest request) {
        if (userBookmarkChargerRepository.existsByChargerIdAndUserId(request.getChargerId(), request.getUserId())) {
            return ResponseEntity.badRequest().body(new BookmarkResponse(0, "즐겨찾기에 존재하는 충전기아이디입니다."));
        }
        UserBookmarkChargerEntity bookmarkChargerEntity = UserBookmarkChargerEntity.builder()
                .chargerName(request.getChargerName())
                .chargerId(request.getChargerId())
                .userId(request.getUserId())
                .build();
        userBookmarkChargerRepository.save(bookmarkChargerEntity);
        return ResponseEntity.ok(new BookmarkResponse(1, "ok"));
    }

    @Override
    public ResponseEntity<List<UserBookmarkChargerEntity>> read(String userId) {
        List<UserBookmarkChargerEntity> bookmarkList = userBookmarkChargerRepository.findByUserId(userId);
//        bookmarkList.stream().forEach(e -> {
//            System.out.println(e.getChargerName());
//        });

        return ResponseEntity.ok(bookmarkList);
    }

    @Override
    public ResponseEntity<BookmarkResponse> update(BookmarkRequest request) {
        if (!userBookmarkChargerRepository.existsByChargerIdAndUserId(request.getChargerId(), request.getUserId())) {
            return ResponseEntity.badRequest().body(new BookmarkResponse(0, "즐겨찾기에 존재하지 않는 충전기입니다."));
        }
        UserBookmarkChargerEntity bookmarkChargerEntity = UserBookmarkChargerEntity.builder()
                .chargerName(request.getChargerName())
                .chargerId(request.getChargerId())
                .userId(request.getUserId())
                .build();
        userBookmarkChargerRepository.save(bookmarkChargerEntity);
        return ResponseEntity.ok(new BookmarkResponse(1, "ok"));
    }

    @Override
    public ResponseEntity<BookmarkResponse> delete(Long id) {
        userBookmarkChargerRepository.deleteById(id);
        return ResponseEntity.ok(new BookmarkResponse(1, "ok"));
    }
}
