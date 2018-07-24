package com.bdyh.web.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("base")
public class BaseController {

    @RequestMapping("toUrl/{one}/{tow}")
    public String toUrl(@PathVariable("one") String one, @PathVariable("tow") String tow) {
        return one + "/" + tow;

    }
}
