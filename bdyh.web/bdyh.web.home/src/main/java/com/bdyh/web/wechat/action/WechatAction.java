package com.bdyh.web.wechat.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bdyh.web.wechat.utils.CheckUtil;
import com.bdyh.web.wechat.utils.MessageUtil;

/**
 * 微信公众号交互
 * 2018年1月7日
 * @author cxs
 */
@Controller
@RequestMapping("/wechat")
public class WechatAction {
	
	/**
	 * 接入验证
	 * @throws IOException 
	 */
	/*private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		PrintWriter out=response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}*/
	@RequestMapping(value="/access",method={RequestMethod.GET})
	public void access(HttpServletResponse response,String signature,String timestamp,String nonce,String echostr) throws IOException{
		PrintWriter out=response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}
	/**
	 * 消息的接收与响应
	 * @throws IOException 
	 */
	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message=null;
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				if("1".equals(content)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					message=MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("3".equals(content)){
					message=MessageUtil.initImageMessage(toUserName, fromUserName);
				}else if("4".equals(content)){
					message=MessageUtil.initMusicMessage(toUserName, fromUserName);
				}
			}else if(MessageUtil.MESSAGE_EVNET.equals(msgType)){
				String eventType=map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}
			}else if(MessageUtil.MESSAGE_LOCATION.equals(msgType)){
				String label=map.get("Label");
				message=MessageUtil.initText(toUserName, fromUserName, label);
			}
			out.print(message);
			System.out.println(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}*/
	@RequestMapping(value="/access",method={RequestMethod.POST})
	public void access(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message=null;
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				if("1".equals(content)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					message=MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("3".equals(content)){
					message=MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("4".equals(content)){
					message=MessageUtil.initNewsMessage(toUserName, fromUserName);
				}
			}else if(MessageUtil.MESSAGE_EVNET.equals(msgType)){
				String eventType=map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}
			}else if(MessageUtil.MESSAGE_LOCATION.equals(msgType)){
				String label=map.get("Label");
				message=MessageUtil.initText(toUserName, fromUserName, label);
			}
			out.print(message);
			System.out.println(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
