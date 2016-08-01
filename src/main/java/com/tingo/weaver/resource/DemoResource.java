package com.tingo.weaver.resource;

import com.sun.jersey.api.core.InjectParam;
import com.tingo.core.utils.GSONHelper;
import com.tingo.weaver.dto.DebtSaleDTO;
import com.tingo.weaver.jersey.DemoRemoteService;
import com.tingo.weaver.service.DemoService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @POST
    @Path("/testPost")
    public String testPost(@FormParam("debtSaleId")String debtSaleId) {
        DebtSaleDTO debtSaleDTO = demoService.findSaleDto(Long.parseLong(debtSaleId));
        if(null == debtSaleDTO) {
            return "DebtSale not found";
        }
        return GSONHelper.toJson(debtSaleDTO);
    }
}
