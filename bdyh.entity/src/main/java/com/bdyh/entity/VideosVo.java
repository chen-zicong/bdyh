package com.bdyh.entity;

public class VideosVo  extends  Video{
    private Integer paystatus; //判断购买的状态

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }
}
