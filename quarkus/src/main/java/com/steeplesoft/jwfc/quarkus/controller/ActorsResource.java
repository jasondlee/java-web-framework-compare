package com.steeplesoft.jwfc.quarkus.controller;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.steeplesoft.jwfc.quarkus.model.Actor;
import com.steeplesoft.jwfc.quarkus.service.ActorService;

@Path("actors")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ActorsResource {

    @Inject
    private ActorService actorService;

    @GET
    public List<Actor> getActors() {
        return actorService.findActors();
    }

    @GET
    @Path("{id}")
    public Actor getActor(Long id) {
        return actorService.getActor(id);
    }

    @POST
    public Response create(Actor actor) {
        actorService.createActor(actor);
        return Response.created(URI.create("/actors/" + actor.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Actor actor) {
        if (actor == null || actor.getId() == null) {
            throw new WebApplicationException("Actor ID was not set on request.", 422);
        }

        actorService.update(actor);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(Long id) {
        actorService.delete(id);
        return Response.ok().build();
    }
}
