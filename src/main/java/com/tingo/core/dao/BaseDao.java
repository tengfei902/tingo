package com.tingo.core.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by tengfei on 2016/7/22.
 */
@Repository
public class BaseDao extends AbstractBaseDao {
    @Qualifier("sessionFactory")
    private SqlSessionFactory sessionFactory;
    @Override
    protected SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
