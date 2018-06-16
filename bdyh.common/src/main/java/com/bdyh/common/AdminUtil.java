package com.bdyh.common;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class AdminUtil {
    public static Object getShiroSessionByKey(String key) {
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession().getAttribute(key);
    }
}
