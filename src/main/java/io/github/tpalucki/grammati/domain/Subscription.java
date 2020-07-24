package io.github.tpalucki.grammati.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Subscription {

    @Id
    private Long id;
//    private Instant createdAt;
    private String email;

}
