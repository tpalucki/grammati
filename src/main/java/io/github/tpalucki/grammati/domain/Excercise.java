package io.github.tpalucki.grammati.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
//@Entity
@RequiredArgsConstructor
public class Excercise {

//    @Id
    private Long id;
    private String question;
    private List<String> answers;
}
