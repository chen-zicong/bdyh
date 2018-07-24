package com.bdyh.web.route.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
import com.bdyh.entity.Course;
import com.bdyh.entity.OrderVo;
import com.bdyh.service.CourseService;
import com.bdyh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.common.redis.RedisCacheUtil;
import com.bdyh.entity.UserWechat;
import com.bdyh.wechat.pay.config.WXPayConfig;
import com.bdyh.wechat.pay.utils.GetIpAdrr;
import com.bdyh.wechat.pay.utils.H5UnifiedorderReqParam;
import com.bdyh.wechat.pay.utils.WXPayUtil;
import com.bdyh.wechat.pay.utils.WxPayRequestUtil;

@Controller
@RequestMapping(value = "routeW")
public class RouteAction {
    @Autowired
    private RedisCacheUtil<Object> redisCache;
    @Autowired
    private CourseService courseService;

    @Autowired
    private OrderService orderService;
    // @ExceptionHandler(GlobalExceptionHandler.class)

    /**
     * @param request
     * @return 跳转到主页面
     * String
     * @author qwc
     * 2017年12月10日下午4:56:56
     */
    @GetMapping(value = "index")
    public String index(HttpServletRequest request) {
        // redis示例
        request.setAttribute("hello", "hello Word!");
        redisCache.setCacheObject("tt", "我被缓存了");
        return "wechat/home";
    }

    @RequestMapping("Goto/{one}/{tow}")
    public String route(@PathVariable("one") String one, @PathVariable("tow") String tow) {
        return "wechat/"+one+"/"+tow+"";

    }

    /**
     * @param request
     * @return 跳转到搜索列表页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "courseList")
    public String courseList(HttpServletRequest request) {
        return "wechat/course/list";
    }

    /**
     * @param request
     * @return 跳转到搜索列表页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "lessonList")
    public String jobList(HttpServletRequest request) {
        return "wechat/course/list";
    }

    /**
     * @param request
     * @return 跳转到搜索列表页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "home")
    public String home(HttpServletRequest request) {
        return "wechat/home";
    }

    /**
     * @param request
     * @return 跳转到个人中心页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "center")
    public String center(HttpServletRequest request) {
        return "wechat/person/center";
    }

    /**
     * @param request
     * @return 跳转到我的课程页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "myCourse")
    public String myCourse(HttpServletRequest request) {
        return "wechat/course/myCourse";
    }

    /**
     * @param request
     * @return 跳转到课程详情页面
     * String
     * @author qwc
     * 2017年12月10日下午5:01:42
     */
    @GetMapping(value = "courseDetails")
    public String courseDetails(HttpServletRequest request) {
        return "wechat/course/details";
    }

    /**
     * @param request
     * @return 跳转到我的足迹页面
     * String
     * @author qwc
     * 2017年12月14日下午4:36:09
     */
    @GetMapping(value = "footList")
    public String footPrint(HttpServletRequest request) {
        return "wechat/foot-print/list";
    }

    /**
     * @param request
     * @return 跳转到收藏课程页面
     * String
     * @author qwc
     * 2017年12月14日下午4:36:09
     */
    @GetMapping(value = "colCourseList")
    public String collectCourse(HttpServletRequest request) {
        return "wechat/collect-course/list";
    }

    /**
     * @param request
     * @return 跳转到讲师收藏页面
     * String
     * @author qwc
     * 2017年12月14日下午4:41:10
     */
    @GetMapping(value = "lecturerList")
    public String collectLecturer(HttpServletRequest request) {
        return "wechat/lecturer/list";
    }

    /**
     * @param request
     * @return 跳转到添加意见页面
     * String
     * @author qwc
     * 2017年12月14日下午4:41:10
     */
    @GetMapping(value = "opinion")
    public String opinion(HttpServletRequest request) {
        return "wechat/opinion/opinion";
    }

    /**
     * @param request
     * @return 跳转到VIP界面
     * String
     * @author qwc
     * 2017年12月14日下午4:41:10
     */
    @GetMapping(value = "vip")
    public String openVip(HttpServletRequest request, Model model) {
//		H5UnifiedorderReqParam h5UnifiedorderReqParam = new H5UnifiedorderReqParam();
//		h5UnifiedorderReqParam.setAppid(WXPayConfig.APP_ID);
//		h5UnifiedorderReqParam.setMch_id(WXPayConfig.PARTNERID);
//		h5UnifiedorderReqParam.setNonce_str(WXPayUtil.generateNonceStr());
//		h5UnifiedorderReqParam.setSign_type("HMAC-SHA256");
//		h5UnifiedorderReqParam.setBody("ceshi");
//		h5UnifiedorderReqParam.setOut_trade_no(WXPayUtil.generateNonceStr());
//		h5UnifiedorderReqParam.setTotal_fee(1);
//		h5UnifiedorderReqParam
//				.setSpbill_create_ip(GetIpAdrr.getIpAddr(request));
//
//		/*UserWechat userWechat=(UserWechat)request.getSession().getAttribute("user");
//
//		h5UnifiedorderReqParam.setOpenid(userWechat.getOpenid());*/
//
//		h5UnifiedorderReqParam.setOpenid("ofiiht1Kqdf7iZWWh9nPX6Ef2iCY");
//		h5UnifiedorderReqParam.setNotify_url(
//				"https://127.0.0.1/bdyh.wechat.pay/vipPay/wechatPay");
//		try {
//			Map<String, String> reqMap = WxPayRequestUtil
//					.unifiedorderReqApp(h5UnifiedorderReqParam.gtReqMap());
//			System.out.println("reqMap"+reqMap.toString());
//			System.out.println(reqMap);
//			model.addAttribute("prepay", reqMap.get("package"));
//			model.addAttribute("reqMap", reqMap);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        return "wechat/vip/vipList";
    }

    /**
     * 跳转到订单页面
     *
     * @param model
     * @param courseId
     * @param
     * @return
     */
    @GetMapping(value = "orderPage")
    public String orderPage(Model model, int coursePrice, String tradeNo, int courseId) {
        Course course = courseService.findCourseById(courseId);
        if (course != null) {
            model.addAttribute("course", course);
        }
        model.addAttribute("coursePrice", coursePrice);
        model.addAttribute("tradeNo", tradeNo);
        model.addAttribute("courseId", courseId);
        return "wechat/order/orderPage";
    }

    @RequestMapping("createOrder")
    @Transactional
    public String CreateOrder(@Param("courseId") Integer courseId, @Param("videosId") Integer[] videosId, HttpSession session, Model model) {
        UserWechat userWechat = (UserWechat) session.getAttribute("user");
        if (userWechat == null) {
            throw new BdyhException(ResultEnum.USER_NOT_EXIST);
        }
        if (courseId == null || videosId == null) {
            throw new BdyhException(ResultEnum.PROPERTY_ERROR);
        }


        OrderVo order = orderService.createOrder(courseId, videosId, userWechat);

        model.addAttribute("order", order);
        return "wechat/course/Pay";


    }

}
