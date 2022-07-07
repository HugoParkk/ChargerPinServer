package xyz.pokoed.chargerpinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import xyz.pokoed.chargerpinserver.model.UserBookmarkChargerEntity;

import java.util.List;

public interface UserBookmarkChargerRepository extends JpaRepository<UserBookmarkChargerEntity, Long> {
    @Transactional
    @Modifying
    @Query("delete from UserBookmarkChargerEntity u where u.userId = ?1")
    void deleteByUserId(String userId);

    @Transactional
    @Modifying
    @Query("select u from UserBookmarkChargerEntity u where u.userId = ?1")
    List<UserBookmarkChargerEntity> findByUserId(String userId);
}
