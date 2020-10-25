package io.github.tpalucki.grammati.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"answers", "quiz"})
@ToString(exclude = "answers")
@Entity
@Table(name = "QUESTION")
@NoArgsConstructor
@AllArgsConstructor
public class Question {

  @Id @GeneratedValue private Long id;

  private String question;

  @OneToMany(fetch = FetchType.LAZY)
  private Set<Answer> answers = new HashSet<>();

//  @ManyToOne(fetch = FetchType.LAZY)
//  private Quiz quiz;

  private String tip;

  public String formattedTip() {
    return "Tip: " + tip;
  }
}
