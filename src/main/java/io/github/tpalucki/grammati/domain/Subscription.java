package io.github.tpalucki.grammati.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
//@Builder
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Subscription {

    @Id
    private Long id;
//    private Instant createdAt;
    private String email;

}
