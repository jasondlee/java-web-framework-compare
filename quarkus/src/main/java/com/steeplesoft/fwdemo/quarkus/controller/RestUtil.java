package com.steeplesoft.fwdemo.quarkus.controller;

import javax.ws.rs.core.Response;

public class RestUtil {
    public static Response buildResponse(Object entity) {
        return (entity != null) ?
                Response.ok(entity).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
}
