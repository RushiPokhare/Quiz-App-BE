package org.example.quizapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotBlank(message = "Question Can't Be Blank")
    @Column(name = "Question_Text", nullable = false)
    private String questionText;

    @Column(name = "Option_A")
    private String optionA;

    @Column(name = "Option_B")
    private String optionB;

    @Column(name = "Option_C")
    private String optionC;

    @Column(name = "Option_D")
    private String optionD;

    @NotBlank(message = "Correct Answer Must be Provide")
    @Column(name = "Correct_Answer")
    private String correctAnswer;

    @Column(name = "Difficulty_Level")
    private String difficultyLevel;
}
