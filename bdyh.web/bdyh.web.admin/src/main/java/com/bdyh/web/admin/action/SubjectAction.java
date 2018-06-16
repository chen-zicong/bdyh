package com.bdyh.web.admin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.Clazz;
import com.bdyh.entity.Subject;
import com.bdyh.service.ClazzService;
import com.bdyh.service.SubjectService;

/**
 * 科目管理
 * 2018年2月8日
 * @author cxs
 */

@Controller
@RequestMapping(value="subject")
public class SubjectAction {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ClazzService clazzService;
	
	@RequestMapping(value="clazzList")
	public String clazzList(Model model){
		//TODO 从缓存里取数据
		List<Clazz> clazzList=clazzService.findAllClazz();
		model.addAttribute("clazzList", clazzList);
		return "subject/clazz-list";
	}
	
	
	@RequestMapping(value="subjectList/{clazzId}")
	public String subjectList(Model model,@PathVariable("clazzId") Integer clazzId){
		//TODO 从缓存里取数据
		List<Subject> subjectList=subjectService.findSubjectByClazzId(1);
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("clazzId", clazzId);
		return "subject/subject-list";
	}
}
