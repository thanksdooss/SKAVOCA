package com.skavoca.repository;

import com.skavoca.entity.WeeklyLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeeklyLeagueRepository extends JpaRepository<WeeklyLeague, Long> {
    List<WeeklyLeague> findByCohortAndWeekStartDateOrderByWeeklyXpDesc(Integer cohort, LocalDate weekStart);
    Optional<WeeklyLeague> findByUser_UserIdAndWeekStartDate(Long userId, LocalDate weekStart);
}
