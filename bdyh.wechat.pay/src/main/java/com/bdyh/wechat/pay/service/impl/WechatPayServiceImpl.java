package com.bdyh.wechat.pay.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.bdyh.entity.UserWechat;
import org.springframework.stereotype.Service;

import com.bdyh.wechat.pay.config.WXPayConfig;
import com.bdyh.wechat.pay.service.WechatPayService;
import com.bdyh.wechat.pay.utils.GetIpAdrr;
import com.bdyh.wechat.pay.utils.H5UnifiedorderReqParam;
import com.bdyh.wechat.pay.utils.WXPayUtil;
import com.bdyh.wechat.pay.utils.WxPayRequestUtil;

@Service
public class WechatPayServiceImpl implements WechatPayService {

	/**
	 * @description 获取vip支付的提交订单
	 */
	@Override
	public Map<String, String> gtVipPay(Map<String, String> paramMap, UserWechat user,int coursePrice,String randeNo) {
		// TODO Auto-generated method stub
		H5UnifiedorderReqParam h5UnifiedorderReqParam = new H5UnifiedorderReqParam();
		h5UnifiedorderReqParam.setAppid(WXPayConfig.APP_ID);
		h5UnifiedorderReqParam.setMch_id(WXPayConfig.PARTNERID);
		h5UnifiedorderReqParam.setNonce_str(WXPayUtil.generateNonceStr());
		h5UnifiedorderReqParam.setSign_type(WXPayConfig.SIGNTYPE);
		h5UnifiedorderReqParam.setBody("ceshi");
		h5UnifiedorderReqParam.setOut_trade_no(randeNo);
		// 支付金额，单位为分
	h5UnifiedorderReqParam.setTotal_fee(coursePrice*100);
	//	h5UnifiedorderReqParam.setTotal_fee(1);

		// 客户端ip地址
		h5UnifiedorderReqParam.setSpbill_create_ip(paramMap.get("ipAddr"));
		// 用户的openId
		h5UnifiedorderReqParam.setOpenid(user.getOpenid());
		//h5UnifiedorderReqParam.setOpenid("ofiiht1Kqdf7iZWWh9nPX6Ef2iCY");

		//交易类型
		// JSAPI : 公众号支付
		h5UnifiedorderReqParam.setTrade_type("JSAPI");
		// 异步通知地址
		h5UnifiedorderReqParam.setNotify_url(
				"http://bdpak.cn/bdyh.web.home/vipPay/wechatPayRes/");
		Map<String, String> reqMap = new HashMap<String, String>();
		try {
			reqMap = WxPayRequestUtil
					.unifiedorderReqApp(h5UnifiedorderReqParam.gtReqMap());
			//第一次签名的时候，key是sign，现在是paySign 替换一下
			reqMap.put("paySign",reqMap.get("sign"));
			reqMap.remove("sign");
			System.out.println("reqMap" + reqMap.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqMap;
	}

}
