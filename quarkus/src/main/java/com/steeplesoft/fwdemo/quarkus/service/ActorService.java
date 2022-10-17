package com.steeplesoft.fwdemo.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.fwdemo.quarkus.model.Actor;
import com.steeplesoft.fwdemo.quarkus.repository.ActorRepository;

@ApplicationScoped
public class ActorService {
    @Inject
    ActorRepository repository;

    public List<Actor> findAll() {
        return repository.listAll();
    }

    public Actor find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Actor actor) {
        repository.persist(actor);
    }

    @Transactional
    public void update(Actor actor) {
        Actor entity = find(actor.getId());

        if (entity != null) {
            entity.setFirstName(actor.getFirstName())
                    .setLastName(actor.getLastName());
        } else {
            throw new NotFoundException();
        }

    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
