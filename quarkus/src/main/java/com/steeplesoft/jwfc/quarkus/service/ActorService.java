package com.steeplesoft.jwfc.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Actor;
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
    }

    @Transactional
    public void update(Actor actor) {
        Actor entity = getActor(actor.getId());

        if (entity != null) {
            entity.setFirstName(actor.getFirstName());
            entity.setLastName(actor.getLastName());
        } else {
            throw new NotFoundException();
        }

    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
