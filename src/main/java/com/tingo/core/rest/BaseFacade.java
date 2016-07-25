package com.tingo.core.rest;

import com.google.gson.Gson;
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

    }

    private String getClientResponse(FacadeParams param) {
        JerseyServiceInstance instance = getJerseyService().getInstance(param.getUri());
        instance.invokeJersey().
    }

    private String postClientResponse(FacadeParams param) {

    }
}
