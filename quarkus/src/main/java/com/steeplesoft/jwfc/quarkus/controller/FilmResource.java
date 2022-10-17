package com.steeplesoft.jwfc.quarkus.controller;

import static com.steeplesoft.jwfc.quarkus.controller.RestUtil.buildResponse;

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

import com.steeplesoft.jwfc.quarkus.model.Film;
import com.steeplesoft.jwfc.quarkus.service.FilmService;

@Path("/films")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FilmResource {
    @Inject
    protected FilmService service;

    @GET
    public List<Film> getFilm() {
        return service.findAll();
    }

    @Path("{id}")
    @GET
    public Response getFilm(@PathParam("id") Long id) {
        return buildResponse(service.find(id));
    }

    @POST
    public Response create(Film staff) {
        service.create(staff);
        return Response.created(URI.create("/staff/" + staff.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Film film, @PathParam("id") @NotNull Long id) {
        if (film == null || film.getId() == null || !Objects.equals(film.getId(), id)) {
            throw new BadRequestException("Missing/invalid film");
        }

        service.update(film);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        service.delete(id);
        return Response.ok().build();
    }
}
