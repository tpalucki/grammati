package io.github.tpalucki.grammati.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Quiz {

  @Id @GeneratedValue private Long id;

  @NonNull private String sessionId;

  @OneToMany(fetch = FetchType.LAZY)
  private Set<Question> questions = new HashSet<>();
}
