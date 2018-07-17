package com.bdyh.wechat.pay.service;
/**
 * @description
 * @author qwc
 */

import com.bdyh.entity.UserWechat;

import java.util.Map;

/**
 * @description 微信支付接口
 *
 * @author qwc
 */
public interface WechatPayService {
    /**
     * @description 获取vip支付的提交订单
     *
     * @auhtor qwc 2018年2月11日 下午10:11:39
     * @param paramMap
     * @return Map<String , String>
     */
    public Map<String, String> gtVipPay(Map<String, String> paramMap, String orderId);
}
