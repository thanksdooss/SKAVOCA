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

    @org.springframework.data.jpa.repository.Query("SELECT new com.skavoca.dto.DifficultWordDto(" +
            "w.term, w.pronunciationKr, c.courseName, AVG(up.easinessFactor), CAST(SUM(up.totalLapses) AS double)) " +
            "FROM UserProgress up " +
            "JOIN up.word w " +
            "JOIN w.course c " +
            "WHERE up.user.cohort = :cohort OR :cohort IS NULL " +
            "GROUP BY w.wordId, w.term, w.pronunciationKr, c.courseName " +
            "ORDER BY AVG(up.easinessFactor) ASC")
    List<com.skavoca.dto.DifficultWordDto> findDifficultWords(@org.springframework.data.repository.query.Param("cohort") Integer cohort, org.springframework.data.domain.Pageable pageable);
}
