package com.bdyh.web.home.action;

import com.bdyh.entity.*;
import com.bdyh.service.CourseService;
import com.bdyh.service.OrderService;
import com.bdyh.service.TeacherService;
import com.bdyh.service.VideoService;
import junit.framework.TestCase;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring.xml", "classpath:spring/springmvc.xml", "classpath:mybatis/mybatis.xml","classpath:mybatis/mybatis-trans.xml"})
public class CourseActionTest {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private VideoService videoService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testCourseDetails() {
        int courseId = 1;
        String openId = "o3_ld1tMjNZm2OUBrem_k0z6qanw";
        Course course = courseService.findCourseById(courseId);
        Teacher teacher = teacherService.findTeacherById(course.getTeacherId());
        List<Video> videoList = videoService.findVideoByCourseId(courseId);
        List<UserOrder> userOrdersPay = orderService.findBoughtByOpenIdandCourseId(openId, courseId);
        List<UserOrder> userOrdersUnPay = orderService.findUnBoughtByOpenIdandCourseId(openId, courseId);


        List<Video> boughtVideo = null;
        if (userOrdersPay.size() > 0) {
            for (UserOrder order : userOrdersPay) {
                List<Integer> videosId = orderService.findOrderDetailByOrderId(order.getOrderId());
                boughtVideo = videoService.findBoughtVideo(videosId);

            }
        }


        List<Video> unboughtVide = null;
        if (userOrdersUnPay.size() > 0) {
            for (UserOrder order : userOrdersUnPay) {
                List<Integer> videosId = orderService.findOrderDetailByOrderId(order.getOrderId());
                unboughtVide = videoService.findBoughtVideo(videosId);

            }
        }

        List<VideosVo> videosVoList = new ArrayList<>();
        VideosVo videosVo = null;
        for (Video video : videoList) {
            videosVo = new VideosVo();
            try {
                BeanUtils.copyProperties(video, videosVo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            videosVo.setPaystatus(0);
            for (Video payVideo : boughtVideo) {
                if (payVideo.getCourseId().equals(payVideo.getCourseId())) {
                    videosVo.setPaystatus(1);
                    break;
                }
            }
            for (Video unpayVide : unboughtVide) {
                if (unpayVide.getCourseId().equals(unpayVide.getCourseId())) {
                    videosVo.setPaystatus(-1);
                    break;
                }
            }
            videosVoList.add(videosVo);
        }
    }
}