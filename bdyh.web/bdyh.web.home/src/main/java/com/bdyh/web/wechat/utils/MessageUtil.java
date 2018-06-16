package com.bdyh.web.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.bdyh.web.wechat.po.News;
import com.bdyh.web.wechat.po.NewsMessage;
import com.bdyh.web.wechat.po.TextMessage;
import com.thoughtworks.xstream.XStream;
/**
 * 解析信息和发送信息的工具类
 * 2018年1月7日
 * @author cxs
 */
public class MessageUtil {
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	
	public static final String GET_CODE_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	/*private static final String URL="http://cxs.nat300.top/bdyh.web.home/user/getUser";
	private static final String NATAPPURL="http://cxs.nat300.top";*/
	
	private static final String URL="http://bdpak.cn/bdyh.web.home/user/getUser";
	private static final String NATAPPURL="http://bdpak.cn";
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text=new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n");
		sb.append("1、小蝌蚪在线课堂介绍\n");
		sb.append("2、小蝌蚪在线课堂\n");
		sb.append("3、小蝌蚪在线课堂\n");
		sb.append("4、小蝌蚪在线课堂\n");
		sb.append("回复？调出此菜单。");
		return sb.toString();
	}
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪小蝌蚪");
		return sb.toString();
	}
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String initNewsMessage(String toUserName,String fromUserName) throws UnsupportedEncodingException{
		String message=null;
		List<News> newsList=new ArrayList<News>();
		NewsMessage newsMessage=new NewsMessage();
		
		News news=new News();
		news.setTitle("在线课堂介绍");
		news.setDescription("小蝌蚪在线课堂");
		news.setPicUrl(NATAPPURL+"/bdyh.web.home/image/slideshow4.jpg");
		String url=URLEncoder.encode(URL, "UTF-8");
		String StringURL=GET_CODE_URL.replace("APPID", WechatUtil.APPID).replace("REDIRECT_URI",url).replace("SCOPE", "snsapi_userinfo");
		news.setUrl(StringURL);
		newsList.add(news);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message=newsMessageToXml(newsMessage);
		return message;
	}
	/**
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xStream=new XStream();
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item", new News().getClass());
		return xStream.toXML(newsMessage);
	}
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	/*public static String initImageMessage(String toUserName,String fromUserName){
		String message=null;
		Image image=new Image();
		image.setMediaId("5MkWgMTuEY4c2zuFU4IRAOAkozhzqcWoeyX_BK0KMB8jmowq19TA7rG4x1TBDZIv");
		ImageMessage imageMessage=new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setImage(image);
		message=imageMessageToXml(imageMessage);
		return message;
	}*/
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	/*public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xStream=new XStream();
		xStream.alias("xml", imageMessage.getClass());
		return xStream.toXML(imageMessage);
	}*/
	
	/**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	/*public static String musicMessageToXml(MusicMessage musicMessage){
		XStream xStream=new XStream();
		xStream.alias("xml", musicMessage.getClass());
		return xStream.toXML(musicMessage);
	}*/
	/**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	/*public static String initMusicMessage(String toUserName,String fromUserName){
		String message=null;
		Music music=new Music();
		music.setThumbMediaId("uuxjpBRRl8nW1TSW4qvftzFci8ub0UcLtHMjnR6jVaGIRihxkhm4eZkzLTdahlZc");
		music.setTitle("see you again");
		music.setDescription("shin.....");
		music.setMusicUrl("http://56xdsi.natappfree.cc/bdyh.web.home/resource/See You Again.mp3");
		music.setHQMusicUrl("http://56xdsi.natappfree.cc/bdyh.web.home/resource/See You Again.mp3");
		MusicMessage musicMessage=new MusicMessage();
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setMusic(music);
		message=musicMessageToXml(musicMessage);
		return message;
	}*/
}
