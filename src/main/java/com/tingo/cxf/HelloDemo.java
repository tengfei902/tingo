package com.tingo.cxf;

import javax.jws.WebService;

/**
 * Created by user on 16/11/25.
 */
@WebService
public interface HelloDemo {
    String sayHi(String name);
}
