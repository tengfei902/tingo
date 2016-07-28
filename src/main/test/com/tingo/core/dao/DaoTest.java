package com.tingo.core.dao;

import com.tingo.core.BaseAppTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by tengfei on 2016/7/22.
 */
public class DaoTest extends BaseAppTest {
    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sessionFactory;

    @Test
    public void testQuery() {
        SqlSession session = sessionFactory.openSession();
        String statement  = "";
        Object parameter = null;
        List list = session.selectList(statement,parameter);
    }

    @Test
    public void testInsert() {
        SqlSession session = sessionFactory.openSession();
        String statement  = "";
        Object parameter = null;
        session.insert(statement,parameter);
    }
}
