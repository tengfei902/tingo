package com.tingo.core.rest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Created by tengfei on 2016/7/25.
 */
public class JerseyService implements JerseyServiceInstance {

    private String readTime;
    private String connectTime;
    private String threadPool;
    private String maxConnTotal;
    private String maxConnPerRoute;

    public WebResource getResource() {
        return null;
    }

    public ClientResponse invokeJersey(JerseyRequestParam request) {
        return null;
    }

    public ClientResponse invokeJersey() {
        return null;
    }

    public JerseyServiceInstance withUser(String user) {
        return null;
    }

    public String getUri() {
        return null;
    }

    public JerseyServiceInstance getInstance(String uri) {
        return this;
    }

    private void init() {
        int connectTimeout = 3*1000;
        int socketTimeout = 4*60*1000;
        int maxConnTotalInt = 100;
        int maxConnPerRouteInt = 40;

        DefaultClientConfig clientConfig = new DefaultClientConfig();
        if()
    }
}
