package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;
    private String reference;

    @OneToMany(mappedBy = "quiz")
    private List<Task> tasks = new ArrayList<>();
}
