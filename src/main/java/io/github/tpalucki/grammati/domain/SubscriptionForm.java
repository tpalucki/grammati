package io.github.tpalucki.grammati.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription")
public class SubscriptionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long subscriptionId;
    private String name;
    private String email;
    private boolean active = false;
}
