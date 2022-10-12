package com.steeplesoft.jwfc.quarkus.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;

import com.steeplesoft.jwfc.quarkus.repository.ActorRepository;
import io.smallrye.mutiny.Uni;

@RequestScoped
public class ActorsResource {
    @Inject
    ActorRepository repository;

    @GET
    public Uni<Long> count() {
        return repository.count();
    }
}
