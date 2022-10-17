package com.steeplesoft.fwdemo.quarkus.controller;

import static com.steeplesoft.fwdemo.quarkus.controller.RestUtil.buildResponse;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.steeplesoft.fwdemo.quarkus.model.Actor;
import com.steeplesoft.fwdemo.quarkus.service.ActorService;

@Path("actors")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ActorsResource {

    @Inject
    private ActorService actorService;

    @GET
    public List<Actor> getActors() {
        return actorService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getActor(@PathParam("id") @NotNull Long id) {
        return buildResponse(actorService.find(id));
    }

    @POST
    public Response create(Actor actor) {
        actorService.create(actor);
        return Response.created(URI.create("/actors/" + actor.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Actor actor, @PathParam("id") @NotNull Long id) {
        if (actor == null || actor.getId() == null || !Objects.equals(actor.getId(), id)) {
            throw new BadRequestException("Missing/invalid actor");
        }

        actorService.update(actor);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        actorService.delete(id);
        return Response.ok().build();
    }
}
