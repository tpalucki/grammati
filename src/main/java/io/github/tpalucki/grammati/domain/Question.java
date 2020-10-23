package io.github.tpalucki.grammati.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"answers", "quiz"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

  @Id @GeneratedValue private Long id;

  private String question;

  //    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @OneToMany(fetch = FetchType.LAZY)
  private Set<Answer> answers = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  private Quiz quiz;

  private String tip;

  public String formattedTip() {
    return "Tip: " + tip;
  }
}
