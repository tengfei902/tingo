package com.tingo.core.rest;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.tingo.core.exception.TingoException;
import com.tingo.core.utils.GSONHelper;

import java.lang.reflect.Type;

/**
 * Created by tengfei on 2016/7/25.
 */
public abstract class BaseFacade {

    protected abstract JerseyService getJerseyService();

    public <T> T get(FacadeParams param,Class<T> clazz) {
        try {
            return GSONHelper.convert(getClientResponse(param),clazz);
        } catch (Exception e) {
            throw new TingoException(e.getMessage());
        }
    }

    public <T> T get(FacadeParams param, Type type) {
        try {
            String jsonStr = getClientResponse(param);
            Object obj = new Gson().fromJson(jsonStr,type);
            return (T)obj;
        } catch (Exception e) {
            throw new TingoException(e.getMessage());
        }
    }

    public <T> T post(FacadeParams param,Class<T> clazz) {
        try {
            return GSONHelper.convert(postClientResponse(param),clazz);
        }catch (Exception e) {
            throw new TingoException(e.getMessage());
        }
    }

    public <T> T post(FacadeParams param,Type type) {
        try {
            return GSONHelper.convert(postClientResponse(param),type);
        } catch (Exception e) {
            throw new TingoException(e.getMessage());
        }
    }

    private String getClientResponse(FacadeParams param) {
        JerseyServiceInstance instance = getJerseyService().getInstance();
        ClientResponse response = instance.getResource(param.getUri()).queryParams(param.getQueryParams()).get(ClientResponse.class);
        return response.getEntity(String.class);
    }

    private String postClientResponse(FacadeParams param) {
        JerseyServiceInstance instance = getJerseyService().getInstance();
        ClientResponse response = instance.getResource(param.getUri()).post(ClientResponse.class,param.getForm());
        return response.getEntity(String.class);
    }
}
