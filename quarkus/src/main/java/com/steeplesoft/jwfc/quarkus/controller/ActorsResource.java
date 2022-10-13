package com.steeplesoft.jwfc.quarkus.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.steeplesoft.jwfc.quarkus.model.Actor;
import com.steeplesoft.jwfc.quarkus.repository.ActorRepository;
import io.smallrye.mutiny.Uni;

@Path("actors")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ActorsResource {
    @Inject
    ActorRepository repository;

    @GET
    @Path("count")
    public Uni<Long> count() {
        return repository.count();
    }

    @GET
    public Uni<List<Actor>> getActors() {
        return repository.listAll();
    }
}
