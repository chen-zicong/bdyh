package com.bdyh.wechat.pay.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.bdyh.entity.UserOrder;
import com.bdyh.service.OrderService;
import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.wechat.pay.config.WXPayConfig;
import com.bdyh.wechat.pay.service.WechatPayService;
import com.bdyh.wechat.pay.utils.H5UnifiedorderReqParam;
import com.bdyh.wechat.pay.utils.WXPayUtil;
import com.bdyh.wechat.pay.utils.WxPayRequestUtil;

@Service
public class WechatPayServiceImpl implements WechatPayService {

    /**
     * @description 获取vip支付的提交订单
     */

    @Autowired
    private OrderService orderService;
    @Override
    public Map<String, String> gtVipPay(Map<String, String> paramMap ,String orderId) {

        UserOrder order = orderService.findUserOrder(orderId);
        if(order==null){
            throw new BdyhException(ResultEnum.ORDER_NOT_EXIST);
        }
        H5UnifiedorderReqParam h5UnifiedorderReqParam = new H5UnifiedorderReqParam();
        h5UnifiedorderReqParam.setAppid(WXPayConfig.APP_ID);
        h5UnifiedorderReqParam.setMch_id(WXPayConfig.PARTNERID);
        h5UnifiedorderReqParam.setNonce_str(WXPayUtil.generateNonceStr());
        h5UnifiedorderReqParam.setSign_type(WXPayConfig.SIGNTYPE);
        h5UnifiedorderReqParam.setBody("小科斗微课堂");
        h5UnifiedorderReqParam.setOut_trade_no(order.getOrderId());
        // 支付金额，单位为分 ，收到的是元 做一下乘法
        h5UnifiedorderReqParam.setTotal_fee(order.getPrice().multiply(new BigDecimal(100)).intValue());
        //	h5UnifiedorderReqParam.setTotal_fee(1);

        // 客户端ip地址
        h5UnifiedorderReqParam.setSpbill_create_ip(paramMap.get("ipAddr"));
        // 用户的openId
        h5UnifiedorderReqParam.setOpenid(order.getOpenId());
        //h5UnifiedorderReqParam.setOpenid("ofiiht1Kqdf7iZWWh9nPX6Ef2iCY");

        //交易类型
        // JSAPI : 公众号支付
        h5UnifiedorderReqParam.setTrade_type("JSAPI");
        // 异步通知地址
        h5UnifiedorderReqParam.setNotify_url(
                WXPayConfig.THECALLBACKADDRESS);
        Map<String, String> reqMap = new HashMap<String, String>();
        try {
            reqMap = WxPayRequestUtil
                    .unifiedorderReqApp(h5UnifiedorderReqParam.gtReqMap());
            //第一次签名的时候，key是sign，现在是paySign 替换一下
            reqMap.put("paySign", reqMap.get("sign"));
            reqMap.remove("sign");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reqMap;
    }

}
