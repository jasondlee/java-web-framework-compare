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

import com.steeplesoft.fwdemo.shared.model.Staff;
import com.steeplesoft.fwdemo.quarkus.service.StaffService;

@Path("/staff")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class StaffResource {
    @Inject
    protected StaffService staffService;

    @GET
    public List<Staff> getStaff() {
        return staffService.findAll();
    }

    @Path("{id}")
    @GET
    public Response getStaff(@PathParam("id") Long id) {
        return buildResponse(staffService.find(id));
    }

    @POST
    public Response create(Staff staff) {
        staffService.create(staff);
        return Response.created(URI.create("/staff/" + staff.getId())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Staff staff, @PathParam("id") @NotNull Long id) {
        if (staff == null || staff.getId() == null || !Objects.equals(staff.getId(), id)) {
            throw new BadRequestException("Missing/invalid staff");
        }

        staffService.update(staff);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        staffService.delete(id);
        return Response.ok().build();
    }
}
