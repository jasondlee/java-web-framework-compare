package com.steeplesoft.jwfc.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.steeplesoft.jwfc.quarkus.model.Actor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {
    public Actor findByFirstName(String firstName){
        return find("firstName", firstName).firstResult();
    }
}
