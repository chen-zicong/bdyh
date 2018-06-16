package com.bdyh.web.wechat.po;
/**
 * 文本信息
 * 2018年1月7日
 * @author cxs
 */
public class TextMessage extends BaseMessage{
	private String Content;
	private String MsgId;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
