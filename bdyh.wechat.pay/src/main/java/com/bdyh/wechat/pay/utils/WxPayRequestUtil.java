package com.bdyh.wechat.pay.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.bdyh.wechat.pay.config.WXPayConfig;
import com.bdyh.wechat.pay.config.WXPayConfig.SignType;

import net.sf.json.JSONObject;



public class WxPayRequestUtil {
	/**
	 * @description 关闭微信支付订单接口
	 *
	 * @auhtor qwc 2018年12月22日 下午1:26:29
	 * @param param
	 * @return Map<String,String>
	 * @throws Exception
	 */
	public static Map<String, String> closeOrderReq(Map<String, String> param)
			throws Exception {
		// 签名算法
		SignType signType = SignType.HMACSHA256;
		// 生成带签名的xml形式的请求参数
		String reqXmString = WXPayUtil.generateSignature(param,
				WXPayConfig.KEY, signType);

		// 执行微信支付订单关闭操作
		String repXmlString = HttpUrlConnectionUtil.urlPostWeChatPay(
				WXPayConfig.PROTOCOL+
				WXPayConfig.DOMAIN_API
						+ WXPayConfig.CLOSEORDER_URL_SUFFIX,
				reqXmString, WXPayConfig.Charset);

		// 将微信支付服务端返回的xml形式的查询结果转换成Map
		Map<String, String> repMap = WXPayUtil.xmlToMap(repXmlString);
		// 判断查询结果
		if (repMap.get("return_code").equals("SUCCESS")) {
			// 对订单查询的返回结果进行验签【这一步很重要，不可缺】
			if (WXPayUtil.isSignatureValid(repMap, WXPayConfig.KEY)) {
				// 验签通过返回查询结果
				return repMap;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * @description 统一下单请求
	 *
	 * @auhtor qwc 2018年12月21日 下午9:37:37
	 * @param param
	 * @return
	 * @throws Exception Map<String,String>
	 */
	public static Map<String, String> unifiedorderReqApp(
			Map<String, String> param) throws Exception {
		SignType signType = SignType.HMACSHA256;
		// 生成带签名的xml形式的请求参数

		String reqXmString = WXPayUtil.generateSignedXml(param,
				WXPayConfig.KEY, signType);
		System.out.println("reqXmString" + reqXmString);
		String respXmlString = HttpUrlConnectionUtil.urlPostWeChatPay(
				WXPayConfig.PROTOCOL+
				WXPayConfig.DOMAIN_API
						+ WXPayConfig.UNIFIEDORDER_URL_SUFFIX,
				reqXmString, WXPayConfig.Charset);

		// 将微信支付服务端返回的xml数据转换成Map
		Map<String, String> repMap = WXPayUtil.xmlToMap(respXmlString);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+repMap);
		String prepayId =  repMap.get("prepay_id");
		System.out.println("respXmlString"+respXmlString);
		System.out.println("repMa"+JSONObject.fromObject(repMap).toString());
		if (repMap.get("return_code").equals("SUCCESS")) {
			if (WXPayUtil.isSignatureValid(repMap, WXPayConfig.KEY,
					signType)) {// 进行验签
				// Map<String, String> appReqMap = new HashMap<String,
				// String>();
				H5SubOrderReqParam appReqParam = new H5SubOrderReqParam();
				appReqParam.setAppid(WXPayConfig.APP_ID);// 设置应用ID，必填
				appReqParam.setPrepayid(prepayId);// 设置预支付交易会话ID，必填
				appReqParam.setSignType("HMAC-SHA256");
				/*
				 * appReqParam.setNoncestr(WXPayUtil.generateNonceStr());//
				 * 设置随机字符串,必填 appReqParam.setTimestamp(String.valueOf(WXPayUtil.
				 * getCurrentTimestamp()));//设置时间戳，必填
				 */
				// 返回app 请求参数
				return WXPayUtil.generateSignedMap(appReqParam.getAppReqMap(),
						WXPayConfig.KEY, signType);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	/**
	 * @description 微信支付订单查询
	 *
	 * @auhtor qwc 2018年1月27日 下午4:59:08
	 * @param param
	 * @return
	 * @throws Exception
	 * @return Map<String,String>
	 */
	public static Map<String, String> OrderqueryReq(Map<String, String> param)
			throws Exception {
		// 签名算法
		SignType signType = SignType.HMACSHA256;
		// 生成带签名的xml形式的请求参数
		String reqXmString = WXPayUtil.generateSignature(param,
				WXPayConfig.KEY, signType);

		// 执行微信支付订单查询操作
		String repXmlString = HttpUrlConnectionUtil.urlPostWeChatPay(
				WXPayConfig.PROTOCOL+
				WXPayConfig.DOMAIN_API
						+ WXPayConfig.ORDERQUERY_URL_SUFFIX,
				reqXmString, WXPayConfig.Charset);

		// 将微信支付服务端返回的xml形式的查询结果转换成Map
		Map<String, String> repMap = WXPayUtil.xmlToMap(repXmlString);
		// 判断查询结果
		if (repMap.get("return_code").equals("SUCCESS")) {
			// 对订单查询的返回结果进行验签【这一步很重要，不可缺】
			if (WXPayUtil.isSignatureValid(repMap, WXPayConfig.KEY)) {
				// 验签通过返回查询结果
				return repMap;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
