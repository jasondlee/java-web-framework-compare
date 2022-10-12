package com.steeplesoft.jwfc.quarkus.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

@Entity
public class Actor extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long actorId;
    public String firstName;
    public String lastName;
    public LocalDateTime lastUpdate;

}
