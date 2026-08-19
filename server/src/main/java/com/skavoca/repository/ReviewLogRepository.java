package com.skavoca.repository;

import com.skavoca.entity.ReviewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewLogRepository extends JpaRepository<ReviewLog, Long> {
    List<ReviewLog> findByUser_UserIdOrderByReviewedAtDesc(Long userId);
    boolean existsByUser_UserIdAndWord_WordIdAndReviewedAtAfter(Long userId, Long wordId, java.time.LocalDateTime startOfDay);
    java.util.Optional<ReviewLog> findByLocalLogId(String localLogId);

}
