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

import com.steeplesoft.fwdemo.quarkus.model.Customer;
import com.steeplesoft.fwdemo.quarkus.service.CustomerService;

@Path("customers")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CustomerResource {
    @Inject
    protected CustomerService customerService;

    @GET
    public List<Customer> getCustomer() {
        return customerService.findAll();
    }

    @Path("{id}")
    @GET
    public Response getCustomer(@PathParam("id") Long id) {
        return buildResponse(customerService.find(id));
    }

    @POST
    public Response create(Customer customer) {
        customerService.create(customer);
        return Response.created(URI.create("/customer/" + customer.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Customer customer, @PathParam("id") @NotNull Long id) {
        if (customer == null || customer.getId() == null || !Objects.equals(customer.getId(), id)) {
            throw new BadRequestException("Missing/invalid customer");
        }

        customerService.update(customer);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        customerService.delete(id);
        return Response.ok().build();
    }
}
