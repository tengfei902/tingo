package com.tingo.core.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by tengfei on 2016/7/22.
 */
@Repository
public abstract class AbstractBaseDao implements IDao {

    protected abstract SqlSessionFactory getSessionFactory();

    public Integer insert(String statement, Object parameter) {
        SqlSession session = getSessionFactory().openSession();
        try {

        } catch (Exception e) {

        } finally {
            session.close();
        }
        return 1;
    }

    public Integer update(String statement, Object parameter) {
        return null;
    }

    public Object queryForObject(String statement, Object parameter) {
        return null;
    }

    public List query(String statement, Object parameter) {
        return null;
    }
}
