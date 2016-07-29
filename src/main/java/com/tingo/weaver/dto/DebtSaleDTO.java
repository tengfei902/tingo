package com.tingo.weaver.dto;

import java.math.BigDecimal;

/**
 * Created by tengfei on 2016/7/28.
 */
public class DebtSaleDTO {
    private Long id;
    private Long userId;
    private Long boId;
    private Long vaId;
    private BigDecimal transferNum;
    private BigDecimal price;
    private BigDecimal onePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Long getVaId() {
        return vaId;
    }

    public void setVaId(Long vaId) {
        this.vaId = vaId;
    }

    public BigDecimal getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(BigDecimal transferNum) {
        this.transferNum = transferNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(BigDecimal onePrice) {
        this.onePrice = onePrice;
    }
}
