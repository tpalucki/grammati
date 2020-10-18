package io.github.tpalucki.grammati.domain.example;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.*;

@Data
@Entity
public class Car {

  @Id @GeneratedValue UUID id;

  String model;

  @ManyToOne(fetch = LAZY)
  Engine engine;

  @OneToMany(fetch = LAZY)
  List<Tyre> tyres = new ArrayList<>(4);
}
