package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserOrder {
    private String orderId;

    private String openId;

    private BigDecimal price;

    private Integer pay;

    private Date date;

    public UserOrder(String orderId, String openId, BigDecimal price, Integer pay, Date date) {
        this.orderId = orderId;
        this.openId = openId;
        this.price = price;
        this.pay = pay;
        this.date = date;
    }

    public UserOrder() {
        super();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}