package com.skavoca.repository;

import com.skavoca.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    Optional<UserProgress> findByUser_UserIdAndWord_WordId(Long userId, Long wordId);
    List<UserProgress> findByUser_UserIdAndNextPracticeDateLessThanEqual(Long userId, LocalDateTime now);
    List<UserProgress> findAllByUser_UserId(Long userId);
}
