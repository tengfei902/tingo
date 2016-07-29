package com.tingo.core.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by tengfei on 2016/7/25.
 */
@Service
public class JerseyService implements JerseyServiceInstance {

    private String socketTimeout;
    private String connectTimeout;
    private String threadPoolSize;
    private String maxConnTotal;
    private String maxConnPerRoute;
    private String connectionRequestTimeout;
    private Client client;
    private String url;
    private String appName;

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(String threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public String getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(String maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    public String getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(String maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public String getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(String connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public WebResource getResource(String extUri) {
        String appUrl = String.format("http://%s/%s",url,appName);
        return getClient().resource(appUrl+extUri);
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
        int threadPoolSizeInt = 100;
        int maxConnPerRouteInt = 40;
        int connectionRequestTimeoutInt = 3*1000;

        DefaultClientConfig clientConfig = new DefaultClientConfig();
        if(StringUtils.isNotBlank(socketTimeout)) {
            socketTimeoutInt = Integer.parseInt(socketTimeout);
        }
        clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT,socketTimeoutInt);
        if(StringUtils.isNotBlank(connectTimeout)) {
            connectTimeoutInt = Integer.parseInt(connectTimeout);
        }
        clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT,connectTimeoutInt);
        if(StringUtils.isNotBlank(threadPoolSize)) {
            threadPoolSizeInt = Integer.parseInt(threadPoolSize);
        }
        clientConfig.getProperties().put(ClientConfig.PROPERTY_THREADPOOL_SIZE,threadPoolSizeInt);

        client = Client.create(clientConfig);
    }
}
