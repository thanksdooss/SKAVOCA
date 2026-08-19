package com.skavoca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CONFUSING_DISTRACTORS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ConfusingDistractor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distractors_seq")
    @SequenceGenerator(name = "distractors_seq", sequenceName = "distractors_seq", allocationSize = 1)
    @Column(name = "distractor_id")
    private Long distractorId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    private Word word;
    
    @Column(name = "wrong_input", nullable = false, length = 100)
    private String wrongInput;
    
    @Column(name = "feedback_explanation", nullable = false, columnDefinition = "TEXT")
    private String feedbackExplanation;
    
    @Column(name = "is_ai_generated")
    private Boolean isAiGenerated;
}
