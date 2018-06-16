package com.bdyh.web.home.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
/**
 * 测试生成静态html
 * 2018年1月10日
 * @author cxs
 */
@Controller
public class FreeMarkerAction {
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@RequestMapping("/createHtml")
	public String createHtml() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		//生成静态页面
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		Template template = configuration.getTemplate("html/hello.html");
		Map data = new HashMap<>();
		data.put("hello", "spring freemarke");
		String filePath=System.getProperty("path.webapp");
		System.out.println(filePath);
		Writer out = new FileWriter(new File(filePath+"\\WEB-INF\\views\\html\\hello.html"));
		template.process(data, out);
		out.close();
		//返回结果
		return "wechat/hello";
	}
}
