package io.github.tpalucki.grammati.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    private Instant createdAt;
    private String email;
    private boolean enabled;

}
