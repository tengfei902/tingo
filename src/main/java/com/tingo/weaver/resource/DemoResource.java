package com.tingo.weaver.resource;

import com.sun.jersey.api.core.InjectParam;
import com.tingo.weaver.jersey.DemoRemoteService;
import com.tingo.weaver.service.DemoService;
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
    @InjectParam
    private DemoService demoService;
    @InjectParam
    private DemoRemoteService demoRemoteService;

    @GET
    @Path("/test")
    @Produces("application/json")
    public String testDemo(@QueryParam("param")String param) {
        return "hello"+param;
    }

    @GET
    @Path("testGet")
    @Produces("application/json")
    public String testGet() {
        return demoService.getDemoResult();
    }
}
