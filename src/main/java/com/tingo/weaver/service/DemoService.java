package com.tingo.weaver.service;

import com.tingo.weaver.dao.DebtSalesDao;
import com.tingo.weaver.dto.DebtSaleDTO;
import com.tingo.weaver.jersey.DemoRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tengfei on 2016/7/29.
 */
@Service
public class DemoService {
    @Autowired
    private DemoRemoteService demoRemoteService;
    @Autowired
    private DebtSalesDao debtSalesDao;

    public String getDemoResult() {
        return demoRemoteService.getDemoResult("test");
    }

    public DebtSaleDTO findSaleDto(Long id) {
        return debtSalesDao.findDebtSaleById(id);
    }
}
