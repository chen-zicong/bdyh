package com.bdyh.wechat.pay.config;
/**
 * @description 微信公众号支付常用静态变量
 *
 * @author 
 */
public class WXPayConfig {
	public static final String Charset = "UTF-8";
	
	// 公众账号ID
	//public static final String APP_ID = "wx35cc7fa0895e13aa";
	//public static final String APP_ID = "wx889eda281d723087";
	public static final String APP_ID = "wx889eda281d723087";
	// 商户号
	public static final String PARTNERID = "1499391742";

	public static final String KEY = "acsac6s654c56as44as5c4sac45a465x";

	public enum SignType {
		MD5, HMACSHA256
	}
	public static final String SIGNTYPE ="HMAC-SHA256";
    
	public static final String PROTOCOL = "https://";
	public static final String DOMAIN_API = "api.mch.weixin.qq.com";
	public static final String DOMAIN_API2 = "api2.mch.weixin.qq.com";
	public static final String DOMAIN_APIHK = "apihk.mch.weixin.qq.com";
	public static final String DOMAIN_APIUS = "apius.mch.weixin.qq.com";

	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";
	public static final String HMACSHA256 = "HMAC-SHA256";
	public static final String MD5 = "MD5";

	public static final String FIELD_SIGN = "sign";
	public static final String FIELD_SIGN_TYPE = "sign_type";

	public static final String MICROPAY_URL_SUFFIX = "/pay/micropay";
	public static final String UNIFIEDORDER_URL_SUFFIX = "/pay/unifiedorder";
	public static final String ORDERQUERY_URL_SUFFIX = "/pay/orderquery";
	public static final String REVERSE_URL_SUFFIX = "/secapi/pay/reverse";
	public static final String CLOSEORDER_URL_SUFFIX = "/pay/closeorder";
	public static final String REFUND_URL_SUFFIX = "/secapi/pay/refund";
	public static final String REFUNDQUERY_URL_SUFFIX = "/pay/refundquery";
	public static final String DOWNLOADBILL_URL_SUFFIX = "/pay/downloadbill";
	public static final String REPORT_URL_SUFFIX = "/payitil/report";
	public static final String SHORTURL_URL_SUFFIX = "/tools/shorturl";
	public static final String AUTHCODETOOPENID_URL_SUFFIX = "/tools/authcodetoopenid";

	// sandbox
	public static final String SANDBOX_MICROPAY_URL_SUFFIX = "/sandboxnew/pay/micropay";
	public static final String SANDBOX_UNIFIEDORDER_URL_SUFFIX = "/sandboxnew/pay/unifiedorder";
	public static final String SANDBOX_ORDERQUERY_URL_SUFFIX = "/sandboxnew/pay/orderquery";
	public static final String SANDBOX_REVERSE_URL_SUFFIX = "/sandboxnew/secapi/pay/reverse";
	public static final String SANDBOX_CLOSEORDER_URL_SUFFIX = "/sandboxnew/pay/closeorder";
	public static final String SANDBOX_REFUND_URL_SUFFIX = "/sandboxnew/secapi/pay/refund";
	public static final String SANDBOX_REFUNDQUERY_URL_SUFFIX = "/sandboxnew/pay/refundquery";
	public static final String SANDBOX_DOWNLOADBILL_URL_SUFFIX = "/sandboxnew/pay/downloadbill";
	public static final String SANDBOX_REPORT_URL_SUFFIX = "/sandboxnew/payitil/report";
	public static final String SANDBOX_SHORTURL_URL_SUFFIX = "/sandboxnew/tools/shorturl";
	public static final String SANDBOX_AUTHCODETOOPENID_URL_SUFFIX = "/sandboxnew/tools/authcodetoopenid";

}
