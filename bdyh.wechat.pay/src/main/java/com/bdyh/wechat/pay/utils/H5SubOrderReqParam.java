package com.bdyh.wechat.pay.utils;

import java.util.HashMap;
import java.util.Map;

public class H5SubOrderReqParam {
	// 公众账号ID
	public String appid;

	public String prepayid;
	
	// 随机字符串
	public String nonceStr;

	public String timeStamp;
	
	public String signType;
	
	public String paySign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}
	
	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public Map<String, String> getAppReqMap() {
		Map<String, String> retMap = new HashMap<String, String>();

		if (this.appid != null) {
			retMap.put("appId", this.appid);
		}

		retMap.put("package", "prepay_id="+this.prepayid);

		retMap.put("nonceStr", WXPayUtil.generateNonceStr());

		retMap.put("timeStamp",
				String.valueOf(WXPayUtil.getCurrentTimestamp()));
		
		retMap.put("signType", this.signType);
		
		return retMap;
	}
}
