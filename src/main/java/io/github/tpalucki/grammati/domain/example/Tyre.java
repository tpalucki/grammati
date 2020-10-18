package io.github.tpalucki.grammati.domain.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Tyre {

  @Id @GeneratedValue Long id;

  String producer;

  public Tyre(String producer) {
    this.producer = producer;
  }
}
