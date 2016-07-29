package com.tingo.weaver.dao;

import com.tingo.weaver.dto.DebtSaleDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tengfei on 2016/7/29.
 */
@Component
public class DebtSalesDao extends InvestDao<DebtSaleDTO> {
    public DebtSaleDTO findDebtSaleById(Long id) {
        Map<String,Long> conditions = new HashMap<String, Long>();
        conditions.put("id",id);
        return super.queryForObject("DebtSale.queryDebtSaleById",conditions);
    }
}
