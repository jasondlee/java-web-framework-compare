package com.steeplesoft.jwfc.quarkus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Actor extends BaseModel {
    @Id
    @GeneratedValue(generator = "actor_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="actor_seq", sequenceName = "actor_actor_id_seq")
    @Column(name = "actor_id")
    public Long id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
}
