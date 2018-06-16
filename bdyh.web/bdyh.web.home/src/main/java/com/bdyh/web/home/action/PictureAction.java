package com.bdyh.web.home.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**|
 * 轮播图管理
 * 2018年2月2日
 * @author cxs
 */

@Controller
@RequestMapping(value="picture")
public class PictureAction {
	
	@GetMapping(value="pictureList")
	public String pictureList(){
		//TODO 更改微信端首页的轮播图
		return null;
	}
}
