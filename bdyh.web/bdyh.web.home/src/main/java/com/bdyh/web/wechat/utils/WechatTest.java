package com.bdyh.web.wechat.utils;

import java.io.IOException;

import org.apache.http.ParseException;

import com.bdyh.web.wechat.po.AccessToken;

import net.sf.json.JSONObject;
/**
 * 测试生成按钮和获取基础accesstoken
 * 2018年1月7日
 * @author cxs
 */
public class WechatTest {
	public static void main(String[] args) throws ParseException, IOException {
		
		AccessToken token=WechatUtil.getAccessToken();
		/*
		System.out.println(token.getToken());
		System.out.println(token.getExpiresIn());
		*/
		
		String menu=JSONObject.fromObject(WechatUtil.initMenu()).toString();
		int result=WechatUtil.createMenu(token.getToken(), menu);
		if(result==0){
			System.out.println("创建菜单成功");
		}else{
			System.out.println("错误码"+result);
		}
		
		/*int result=WechatUtil.deleteMenu(token.getToken());
		System.out.println(result);*/
		
		/*JSONObject jsonObject=WeixinUtil.queryMenu(token.getToken());
		System.out.println(JSONObject.fromObject(jsonObject).toString());*/
		
		/*String path="E:\\迅雷下载\\学习资料\\Before20171102\\ssh.jpg";
		String mediaId=WeixinUtil.upload(path, WeixinUtil.getAccessToken().getToken(), "thumb");
		System.out.println(mediaId);*/
		
	}
}
