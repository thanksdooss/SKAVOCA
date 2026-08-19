package com.skavoca.repository;

import com.skavoca.entity.ConfusingDistractor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ConfusingDistractorRepository extends JpaRepository<ConfusingDistractor, Long> {
    Optional<ConfusingDistractor> findByWord_WordIdAndWrongInput(Long wordId, String wrongInput);
    List<ConfusingDistractor> findAllByWord_WordId(Long wordId);
}
