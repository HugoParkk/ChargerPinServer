package xyz.pokoed.chargerpinserver.bookmark.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.pokoed.chargerpinserver.bookmark.model.BookmarkRequest;
import xyz.pokoed.chargerpinserver.bookmark.service.BookmarkServiceImpl;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@Controller
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkServiceImpl bookmarkService;

    @PostMapping("/add")
    public Object addBookmark(@RequestBody BookmarkRequest request) {
        log.info("/bookmark/add start");

        return bookmarkService.add(request);
    }

    @GetMapping("/read/{userId}")
    public Object readBookmark(@PathVariable String userId) {
        log.info("/bookmark/read start");

        return bookmarkService.read(userId);
    }

    @PatchMapping("/update")
    public Object updateBookmark(@RequestBody BookmarkRequest request) {
        log.info("/bookmark/update start");

        return bookmarkService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteBookmark(@PathVariable Long id) {
        log.info("/bookmark/delete start");

        return bookmarkService.delete(id);
    }
}
