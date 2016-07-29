package com.tingo.weaver.jersey;

import com.tingo.core.rest.BaseFacade;
import com.tingo.core.rest.FacadeParams;
import com.tingo.core.rest.JerseyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by tengfei on 2016/7/29.
 */
@Service
public class DemoRemoteService extends BaseFacade {

    @Qualifier("demoJersey")
    @Autowired
    private JerseyService jerseyService;

    @Override
    protected JerseyService getJerseyService() {
        return jerseyService;
    }

    public String getDemoResult(String param) {
        FacadeParams params = new FacadeParams().withUri("/service/demo/test").buildQueryParam("test",param);
        return super.get(params,String.class);
    }
}
