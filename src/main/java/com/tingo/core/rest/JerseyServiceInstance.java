package com.tingo.core.rest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by tengfei on 2016/7/25.
 */
public interface JerseyServiceInstance {
    WebResource getResource();
    ClientResponse invokeJersey(JerseyRequestParam request);
    ClientResponse invokeJersey();
    JerseyServiceInstance withUser(String user);
    String getUri();
}
