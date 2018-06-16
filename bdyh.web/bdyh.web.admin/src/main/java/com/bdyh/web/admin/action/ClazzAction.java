package com.bdyh.web.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bdyh.entity.HomePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.Clazz;
import com.bdyh.service.ClazzService;

import javax.servlet.http.HttpServletResponse;

/**
 * 年级管理，实际上没什么好管理的，既然人家要
 * 2018年2月8日
 *
 * @author cxs
 */
@Controller
@RequestMapping(value = "clazz")
public class ClazzAction {

    @Autowired
    private ClazzService clazzService;


    @RequestMapping(value = "clazzList")
    public String clazzList(Model model) {
        //TODO 使用缓存
        List<Clazz> clazzList = clazzService.findAllClazz();
        model.addAttribute("clazzList", clazzList);
        return "clazz/clazz-list";
    }

    @RequestMapping(value = "clazzLayDown")
    public void clazzLayDown(Integer clazzId, HttpServletResponse response) {
        Clazz clazz = clazzService.findClazzById(clazzId);
        clazz.setStatus(0);
        int i = clazzService.updateClazz(clazz);
        try {
            PrintWriter out = response.getWriter();

                out.write("{\"status\":1}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "clazzLayStart")
    public void clazzLayStart(Integer clazzId, HttpServletResponse response) {
        Clazz clazz = clazzService.findClazzById(clazzId);
        clazz.setStatus(1);
        int i = clazzService.updateClazz(clazz);
        try {
            PrintWriter out = response.getWriter();

            out.write("{\"status\":1}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
