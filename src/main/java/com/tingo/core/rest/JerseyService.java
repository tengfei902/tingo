package com.tingo.core.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.SSLContext;

/**
 * Created by tengfei on 2016/7/25.
 */
public class JerseyService implements JerseyServiceInstance {

    private String socketTimeout;
    private String connectTimeout;
    private String threadPool;
    private String maxConnTotal;
    private String maxConnPerRoute;
    private String connectionRequestTimeout;
    private Client client;
    private String uri;

    public WebResource getResource(String extUri) {
        return getClient().resource(uri+extUri);
    }

    public JerseyServiceInstance getInstance() {
        return this;
    }

    public synchronized Client getClient() {
        if(this.client == null) {
            this.init();
        }
        return client;
    }

    private void init() {
        int connectTimeoutInt = 3*1000;
        int socketTimeoutInt = 4*60*1000;
        int maxConnTotalInt = 100;
        int maxConnPerRouteInt = 40;
        int connectionRequestTimeoutInt = 3*1000;

        DefaultClientConfig clientConfig = new DefaultClientConfig();
        if(StringUtils.isNotBlank(socketTimeout)) {
            clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT,Integer.parseInt(socketTimeout));
            socketTimeoutInt = Integer.parseInt(socketTimeout);
        }
        if(StringUtils.isNotBlank(connectTimeout)) {
            clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT,Integer.parseInt(connectTimeout));
            connectTimeoutInt = Integer.parseInt(connectTimeout);
        }
        if(StringUtils.isNotBlank(threadPool)) {
            clientConfig.getProperties().put(ClientConfig.PROPERTY_THREADPOOL_SIZE,Integer.parseInt(threadPool));
        }
        if(StringUtils.isNotBlank(maxConnTotal)) {
            maxConnTotalInt = Integer.parseInt(maxConnTotal);
        }
        if(StringUtils.isNotBlank(maxConnPerRoute)) {
            maxConnPerRouteInt = Integer.parseInt(maxConnPerRoute);
        }
        if(StringUtils.isNotBlank(connectionRequestTimeout)) {
            connectionRequestTimeoutInt = Integer.parseInt(connectionRequestTimeout);
        }


        client = new Client(new )
    }
}
