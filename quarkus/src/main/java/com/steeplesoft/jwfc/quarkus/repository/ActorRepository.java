package com.steeplesoft.jwfc.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.steeplesoft.jwfc.quarkus.model.Actor;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {
    public Uni<Actor> findByFirstName(String firstName){
        return find("firstName", firstName).firstResult();
    }
}
