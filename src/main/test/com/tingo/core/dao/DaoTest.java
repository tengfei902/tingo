package com.tingo.core.dao;

import com.google.gson.Gson;
import com.tingo.core.BaseAppTest;
import com.tingo.weaver.dao.DebtSalesDao;
import com.tingo.weaver.dto.DebtSaleDTO;
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
    @Autowired
    private DebtSalesDao debtSalesDao;

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

    @Test
    public void testQueryObject() {
        DebtSaleDTO debtSaleDTO = debtSalesDao.findDebtSaleById(4L);
        System.out.println(new Gson().toJson(debtSaleDTO));
    }
}
