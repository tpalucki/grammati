package io.github.tpalucki.grammati.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    private String reference;
    private Date createdAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
