package com.bdyh.wechat.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdyh.common.APIResponse;
import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
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
     * @return Map<String               String>
     * @description 获取开通vip服务的支付提交订单
     * @auhtor qwc 2018年2月22日 下午5:10:33
     */
    @RequestMapping(value = "wechatPay")
    public Map<String, String> vipPayReq(HttpServletRequest request, String orderId) throws IOException {


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
    public void Pay() {

    }

    /**
     * 微信支付后的回调
     * 支付成功后微信会访问这个url
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws DocumentException
     */
    @RequestMapping(value = "wechatPayRes")
    public void wechatPayRes(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        Map<String, String> map = WXPayUtil.xmlToMapByWechat(request);

        //获取微信回调给我的参数中的openid还有订单号 查找数据库是否存在这一条订单
//        UserCourse userCourse = courseService.findUserCourseByOpenIdAndCourseId(map.get("openid"), map.get("out_trade_no"));
        UserOrder order = orderService.findByOpenIdAndOrderId(map.get("openid"), map.get("out_trade_no"));
        if (order == null) {
            throw new BdyhException(ResultEnum.ORDER_NOT_EXIST);

        }
        APIResponse finish = orderService.finish(order);

//        if (userCourse.getPay() == 1) {
//            return;
//        }

//        userCourse.setPay(1);


//        courseService.updataUserCourse(userCourse);
        //告诉微信 朕收到了你的回调
        String xml = "<xml> <return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        response.getWriter().write(xml);


    }
}
