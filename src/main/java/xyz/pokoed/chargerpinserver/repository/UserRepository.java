package xyz.pokoed.chargerpinserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pokoed.chargerpinserver.model.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByUserIdBetweenOrderByUserIdDesc(String testSample70, String testSample80);
    Page<UserEntity> findByUserIdBetween(String from, String to, Pageable pageable);

    void deleteUserByUserIdLessThan(String start);
}
