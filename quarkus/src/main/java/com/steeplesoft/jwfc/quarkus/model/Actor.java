package com.steeplesoft.jwfc.quarkus.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

@Entity
public class Actor extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    public Long actorId;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "last_update")
    public LocalDateTime lastUpdate;

}
