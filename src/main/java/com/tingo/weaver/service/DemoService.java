package com.tingo.weaver.service;

import com.tingo.weaver.jersey.DemoRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tengfei on 2016/7/29.
 */
@Service("demoService")
public class DemoService {
    @Autowired
    private DemoRemoteService demoRemoteService;

    public String getDemoResult() {
        return demoRemoteService.getDemoResult("test");
    }
}
