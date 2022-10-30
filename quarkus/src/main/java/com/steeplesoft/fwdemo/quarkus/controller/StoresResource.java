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

import com.steeplesoft.fwdemo.shared.model.Store;
import com.steeplesoft.fwdemo.quarkus.service.StoreService;

@Path("stores")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class StoresResource {

    @Inject
    protected StoreService storeService;

    @GET
    public List<Store> getStores() {
        return storeService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getStore(@PathParam("id") @NotNull Long id) {
        return buildResponse(storeService.find(id));
    }

    @POST
    public Response create(Store store) {
        storeService.create(store);
        return Response.created(URI.create("/stores/" + store.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Store store, @PathParam("id") @NotNull Long id) {
        if (store == null || store.getId() == null || !Objects.equals(store.getId(), id)) {
            throw new BadRequestException("Missing/invalid store");
        }

        storeService.update(store);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        storeService.delete(id);
        return Response.ok().build();
    }
}
