package xyz.pokoed.chargerpinserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import xyz.pokoed.chargerpinserver.model.UserBookmarkChargerEntity;
import xyz.pokoed.chargerpinserver.model.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRequestBookmarkChargerRepositoryTests {
    @Autowired
    UserBookmarkChargerRepository userBookmarkChargerRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testClass() {
        System.out.println(userBookmarkChargerRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            String userId = "TestSample99";
            Optional<UserEntity> result = userRepository.findById(userId);
            if (result.isPresent()) {
                UserEntity user = result.get();

                UserBookmarkChargerEntity bookmark = UserBookmarkChargerEntity.builder()
                        .chargerName("bookmark" + i)
                        .userId(user.getUserId())
                        .build();
                userBookmarkChargerRepository.save(bookmark);
            }
        });
    }

    @Test
    public void testSelect() {
        Long bookmarkId = 99L;
        Optional<UserBookmarkChargerEntity> result = userBookmarkChargerRepository.findById(bookmarkId);
        System.out.println("=========================================");
        if (result.isPresent()) {
            UserBookmarkChargerEntity bookmark = result.get();
            System.out.println(bookmark);
        }
    }

    @Test
    public void testUpdate() {
        UserBookmarkChargerEntity bookmark = UserBookmarkChargerEntity.builder()
                .bookmarkId(100L)
                .chargerName("Update ChargerName")
                .userId("Update UserId")
                .build();
        System.out.println(userBookmarkChargerRepository.save(bookmark));
    }

    @Test
    public void testDelete() {
        Long bookmarkId = 100L;
        userBookmarkChargerRepository.deleteById(bookmarkId);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserBookmarkChargerEntity> result = userBookmarkChargerRepository.findAll(pageable);

        System.out.println(result);
        System.out.println("=========================================");
        System.out.println("Total Pages: " + result.getTotalPages());
        System.out.println("Total Count:" + result.getTotalElements());
        System.out.println("Current Page Number: " + result.getNumber());
        System.out.println("Page Size: " + result.getSize());
        System.out.println("has next page ?: " + result.hasNext());
        System.out.println("first page ?: " + result.isFirst());
        System.out.println("=========================================");
    }

    @Test
    public void testSort() {
        Sort sort = Sort.by("bookmarkId").descending();
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<UserBookmarkChargerEntity> result = userBookmarkChargerRepository.findAll(pageable);

        result.get().forEach(bookmark -> {
            System.out.println(bookmark);
        });
    }

    @Test
    public void testDeleteByUserId() {
        String userId = "TestSample99";
        userBookmarkChargerRepository.deleteByUserId(userId);
    }

    @Test
    public void testFindByUserId() {
        String userId = "TestSample99";
        List<UserBookmarkChargerEntity> result = userBookmarkChargerRepository.findByUserId(userId);
        System.out.println("=========================================");
        if (!result.isEmpty()) {
            result.stream().forEach(e -> {
                UserBookmarkChargerEntity bookmark = e;
                System.out.println(bookmark);
            });
        } else {
            System.out.println("Is Empty!!");
        }
    }
}
