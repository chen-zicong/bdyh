package com.bdyh.wechat.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdyh.entity.*;
import com.bdyh.service.CourseService;
import com.bdyh.service.OrderService;
import com.bdyh.service.TeacherService;
import com.bdyh.wechat.pay.utils.WXPayUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdyh.wechat.pay.service.WechatPayService;
import com.bdyh.wechat.pay.utils.GetIpAdrr;

/**
 * @author qwc
 * @description 微信支付 开通vip服务操作类
 */
@RestController
@RequestMapping(value = "vipPay")
public class OpenVipWechatPayAction {
    @Resource
    WechatPayService wechatPayService;

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    OrderService orderService;

    /**
     * @param request
     * @return Map<String       String>
     * @description 获取开通vip服务的支付提交订单
     * @auhtor qwc 2018年2月22日 下午5:10:33
     */
    @RequestMapping(value = "wechatPay")
    public Map<String, String> vipPayReq(HttpServletRequest request,String orderId) throws IOException {


        Map<String, String> paramMap = new HashMap<String, String>();
        // 获取客户端Ip地址，考虑到需要req ， 就在外面获取了。
        paramMap.put("ipAddr", GetIpAdrr.getIpAddr(request));
        Map<String, String> reqMap = wechatPayService.gtVipPay(paramMap, orderId);

        return reqMap;
    }

    /**
     * 使用微信支付SDK
     */
    @RequestMapping("/pay")
    public void  Pay(){

    }

    /**
     *  微信支付后的回调
     *  支付成功后微信会访问这个url
     * @param request
     * @param response
     * @throws IOException
     * @throws DocumentException
     */
    @RequestMapping(value = "wechatPayRes")
    public void wechatPayRes(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        Map<String, String> map = WXPayUtil.xmlToMapByWechat(request);
        TeacherIncome teacherIncome;
        //获取微信回调给我的参数中的openid还有订单号 查找数据库是否存在这一条订单
        UserCourse userCourse = courseService.findUserCourseByOpenIdAndCourseId(map.get("openid"), map.get("out_trade_no"));
        UserOrder order = orderService.findByOpenIdAndOrderId(map.get("openid"), map.get("out_trade_no"));
        if(order!=null){
            order.setPay(1);

        }

        if (userCourse.getPay() == 1) {
            return;
        }

        userCourse.setPay(1);
        Course course = courseService.findCourseById(userCourse.getCourseId());
        teacherIncome = teacherService.findTeacherIncome(userCourse.getCourseId(), course.getTeacherId());
        if (teacherIncome == null) {
            teacherIncome = new TeacherIncome();
            teacherIncome.setCourseId(userCourse.getCourseId());
            teacherIncome.setTeacherId(course.getTeacherId());
            teacherIncome.setIncome(Float.valueOf(map.get("total_fee")) / 100);
            teacherIncome.setCount(1);
            teacherService.addTeacherIncome(teacherIncome);

        } else {
            teacherIncome.setCount(teacherIncome.getCount() + 1);
            teacherIncome.setIncome(teacherIncome.getIncome() + Float.valueOf(map.get("total_fee")) / 100);
            teacherService.updateTeacherIncome(teacherIncome);
        }

        courseService.updataUserCourse(userCourse);
        //告诉微信 朕收到了你的回调
        String xml = "<xml> <return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        response.getWriter().write(xml);

        return;
    }
}
