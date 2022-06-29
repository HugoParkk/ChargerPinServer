package xyz.pokoed.chargerpinserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import xyz.pokoed.chargerpinserver.model.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRequestRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testClass() {
        System.out.println(userRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            UserEntity user = UserEntity.builder()
                    .userId("TestSample" + i)
                    .password("12345678")
                    .name("user" + i)
                    .build();
            userRepository.save(user);
        });
    }

    @Test
    public void testSelect() {
        String userId = "TestSample99";
        Optional<UserEntity> result = userRepository.findById(userId);
        System.out.println("=========================================");
        if (result.isPresent()) {
            UserEntity user = result.get();
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        UserEntity user = UserEntity.builder()
                .userId("TestSample100")
                .password("Update Password")
                .name("Update Username")
                .build();
        System.out.println(userRepository.save(user));
    }

    @Test
    public void testDelete() {
        String userId = "TestSample100";
        userRepository.deleteById(userId);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserEntity> result = userRepository.findAll(pageable);

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
        Sort sort = Sort.by("userId").descending();
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<UserEntity> result = userRepository.findAll(pageable);

        result.get().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testQueryMethods() {
        List<UserEntity> list = userRepository.findByUserIdBetweenOrderByUserIdDesc("TestSample70", "TestSample80");
        // List<UserEntity> findByUserIdBetweenOrderByUserIdDesc(String from, String to);
        for (UserEntity user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryMethodWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("userId").descending());
        Page<UserEntity> result = userRepository.findByUserIdBetween("TestSample10", "TestSample40", pageable);

        result.get().forEach(user -> System.out.println(user));
    }

    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods() {
        userRepository.deleteUserByUserIdLessThan("TestSample10");
    }
}
