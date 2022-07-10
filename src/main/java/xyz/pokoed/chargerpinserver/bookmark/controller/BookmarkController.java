package xyz.pokoed.chargerpinserver.bookmark.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/delete")
    public Object deleteBookmark(@RequestBody BookmarkRequest request) {
        log.info("/bookmark/delete start");

        return bookmarkService.delete(request);
    }
}
