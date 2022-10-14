package com.steeplesoft.jwfc.quarkus.service;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.steeplesoft.jwfc.quarkus.model.Actor;
import com.steeplesoft.jwfc.quarkus.model.BaseModel;
import com.steeplesoft.jwfc.quarkus.repository.ActorRepository;

@ApplicationScoped
public class ActorService {
    @Inject
    ActorRepository repository;

    public List<Actor> findActors() {
        return repository.listAll();
    }

    public Actor getActor(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void createActor(Actor actor) {
        repository.persist(actor);
        System.out.println(actor);
        repository.flush();
    }

    @Transactional
    public void update(Actor actor) {
        Actor entity = getActor(actor.id);

        if (entity != null) {
            entity.firstName = actor.firstName;
            entity.lastName = actor.lastName;
        } else {
            throw new NotFoundException();
        }

    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
