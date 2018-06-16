package com.bdyh.web.admin.utils;

public class ChineseToPinyinUtil {
	
	public static String getPinyin(String courseType){
		String Pinyin=null;
		switch (courseType) {
			case "语文":
				Pinyin="yuwen";break;
			case "数学":
				Pinyin="shuxue";break;
			case "英语":
				Pinyin="yingyu";break;
			case "物理":
				Pinyin="wuli";break;
			case "生物":
				Pinyin="shengwu";break;
			case "化学":
				Pinyin="huaxue";break;
			case "地理":
				Pinyin="dili";break;
			case "政治":
				Pinyin="zhengzhi";break;
			case "历史":
				Pinyin="lisi";break;
			}
		return Pinyin;
	}
}
