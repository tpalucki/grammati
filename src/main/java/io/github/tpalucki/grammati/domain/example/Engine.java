package io.github.tpalucki.grammati.domain.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Engine {

    @Id
    @GeneratedValue
    UUID id;

    String model;
}
