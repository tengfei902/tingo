package com.tingo.weaver.dao;

import com.tingo.core.dao.AbstractBaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by tengfei on 2016/7/27.
 */
@Component
public class InvestDao<T> extends AbstractBaseDao<T> {
    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    protected SqlSessionFactory getSessionFactory() {
        return sqlSessionFactory;
    }

}
