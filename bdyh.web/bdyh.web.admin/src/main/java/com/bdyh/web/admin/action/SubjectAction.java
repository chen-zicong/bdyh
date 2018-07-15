package com.bdyh.web.admin.action;

import java.util.List;

import com.bdyh.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.Clazz;
import com.bdyh.entity.Subject;
import com.bdyh.service.ClazzService;
import com.bdyh.service.SubjectService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 科目管理
 * 2018年2月8日
 *
 * @author cxs
 */

@Controller
@RequestMapping(value = "subject")
public class SubjectAction {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ClazzService clazzService;

    @RequestMapping(value = "clazzList")
    public String clazzList(Model model) {
        //TODO 从缓存里取数据
        List<Clazz> clazzList = clazzService.findAllClazz();
        model.addAttribute("clazzList", clazzList);
        return "subject/clazz-list";
    }


    @RequestMapping(value = "subjectList/{clazzId}")
    public String subjectList(Model model, @PathVariable("clazzId") Integer clazzId) {
        //TODO 从缓存里取数据
        List<Subject> subjectList = subjectService.findSubjectByClazzId(clazzId);
        model.addAttribute("subjectList", subjectList);
        model.addAttribute("clazzId", clazzId);
        return "subject/subject-list";
    }

    /**
     * 开启该课程的科目
     *
     * @param subjectId
     * @return
     */
    @RequestMapping(value = "subjectStart")
    @ResponseBody
    public APIResponse subjectStart(Integer subjectId) {
        return subjectService.updateStatusById(subjectId, 1);
    }

    /**
     * 关闭改课程的科目
     *
     * @param subjectId
     * @return
     */
    @RequestMapping(value = "subjectDown")
    @ResponseBody
    public APIResponse subjectDown(Integer subjectId) {
        return subjectService.updateStatusById(subjectId, 0);
    }

    @RequestMapping("addSubject")
    @ResponseBody
    public APIResponse addSubject(Subject subject) {
        if (subject == null) {
            return APIResponse.fail("参数错误");
        }
        return subjectService.addSubject(subject);

    }

    @RequestMapping("addSubjectPage/{clazzId}")

    public String addSubjectPage(@PathVariable("clazzId") Integer clazzId,Model mode)
    {
        mode.addAttribute("clazzId",clazzId);
        return "subject/subject-add";
    }
}
