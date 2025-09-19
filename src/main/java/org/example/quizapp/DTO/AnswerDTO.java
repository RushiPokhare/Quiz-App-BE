package org.example.quizapp.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerDTO {
    private Long questionId;
    private String givenAnswer;
}
