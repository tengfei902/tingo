package com.tingo.core.rest;

import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Created by tengfei on 2016/7/25.
 */
public class FacadeParams {
    private String uri;
    private String userId;
    private Form form = new Form();
    private MultivaluedMapImpl queryParams = new MultivaluedMapImpl();

    public String getUri() {
        return uri;
    }

    public String getUserId() {
        return userId;
    }

    public Form getForm() {
        return form;
    }

    public MultivaluedMapImpl getQueryParams() {
        return  queryParams;
    }

    public FacadeParams withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public FacadeParams withUser(String userId) {
        this.userId = userId;
        return this;
    }

    public FacadeParams buildForm(String param, Object value) {
        form.add(param,value);
        return this;
    }

    public FacadeParams buildQueryParam(String param, Object value) {
        queryParams.add(param,value);
        return this;
    }
}
