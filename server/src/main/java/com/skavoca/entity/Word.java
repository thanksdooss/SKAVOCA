package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import java.time.LocalDateTime;

@Entity
@Table(name = "WORDS")
@Where(clause = "is_active = true")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Word {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words_seq")
    @SequenceGenerator(name = "words_seq", sequenceName = "words_seq", allocationSize = 1)
    @Column(name = "word_id")
    private Long wordId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CurriculumCourse course;
    
    @Column(nullable = false, length = 100)
    private String term;
    
    @Column(name = "full_term", length = 200)
    private String fullTerm;
    
    @Column(name = "pronunciation_kr", length = 100)
    private String pronunciationKr;
    
    @Column(name = "pronunciation_ssml", columnDefinition = "TEXT")
    private String pronunciationSsml;
    
    @Column(name = "easy_meaning", nullable = false, columnDefinition = "TEXT")
    private String easyMeaning;
    
    @Column(name = "context_sentence", nullable = false, columnDefinition = "TEXT")
    private String contextSentence;
    
    @Column(length = 20)
    private String difficulty;
    
    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    
    @Builder.Default
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}

