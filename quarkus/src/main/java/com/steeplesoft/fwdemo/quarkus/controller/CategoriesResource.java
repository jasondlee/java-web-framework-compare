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

import com.steeplesoft.fwdemo.quarkus.model.Category;
import com.steeplesoft.fwdemo.quarkus.service.CategoriesService;

@Path("categories")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CategoriesResource {

    @Inject
    protected CategoriesService categorieservice;

    @GET
    public List<Category> getcategories() {
        return categorieservice.findAll();
    }

    @GET
    @Path("{id}")
    public Response getcategory(@PathParam("id") @NotNull Long id) {
        return buildResponse(categorieservice.find(id));
    }

    @POST
    public Response create(Category category) {
        categorieservice.create(category);
        return Response.created(URI.create("/categories/" + category.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Category category, @PathParam("id") @NotNull Long id) {
        if (category == null || category.getId() == null || !Objects.equals(category.getId(), id)) {
            throw new BadRequestException("Missing/invalid category");
        }

        categorieservice.update(category);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        categorieservice.delete(id);
        return Response.ok().build();
    }
}
