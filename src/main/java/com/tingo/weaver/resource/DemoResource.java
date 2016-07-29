package com.tingo.weaver.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by tengfei on 2016/7/29.
 */
@Path("/demo")
public class DemoResource {

    @GET
    @Path("/test")
    @Produces("application/json")
    public String testDemo(@QueryParam("param")String param) {
        return "hello"+param;
    }
}
