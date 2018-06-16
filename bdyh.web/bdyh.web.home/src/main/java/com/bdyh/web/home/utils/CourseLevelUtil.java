package com.bdyh.web.home.utils;

/**
 * 根据字符串转出年级
 * 比如：一年级=1
 * 2018年1月21日
 * @author cxs
 */
public class CourseLevelUtil {
	
	public static int getCourseLevel(String courseLevel){
		int level=0;
		switch (courseLevel) {
			case "一年级":
				level=1;break;
			case "二年级":
				level=2;break;
			case "三年级":
				level=3;break;
			case "四年级":
				level=4;break;
			case "五年级":
				level=5;break;
			case "六年级":
				level=6;break;
			case "初一":
				level=7;break;
			case "初二":
				level=8;break;
			case "初三":
				level=9;break;
			case "高一":
				level=10;break;
			case "高二":
				level=11;break;
			case "高三":
				level=12;break;
			}
		return level;
	}
}
