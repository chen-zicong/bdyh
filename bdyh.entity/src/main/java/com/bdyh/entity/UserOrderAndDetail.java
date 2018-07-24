package com.bdyh.entity;

import java.util.List;

public class UserOrderAndDetail extends UserOrder {
    private List<OrderDetail> orderDetail;

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
