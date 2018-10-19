package com.bdyh.web.admin.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bdyh.entity.Course;
import com.bdyh.entity.Video;
import com.bdyh.service.CourseService;
import com.bdyh.service.VideoService;

@Controller
@RequestMapping(value = "video")
public class VideoAction {

    @Autowired
    private CourseService courseService;

    @Autowired
    private VideoService videoService;


    /**
     * 播放视频
     *
     * @param videoId
     * @return
     */
    @GetMapping(value = "playVideo/{videoId}")
    public String playVideo(Model model, @PathVariable("videoId") Integer videoId) {
        Video video = videoService.findVideoById(videoId);
        model.addAttribute("video", video);
        return "course/course-video";
    }

    /**
     * 开始上传视频
     *
     * @param file

     * @param courseId
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value = "uploadVideo/{courseId}")
    public void uploadVideo(MultipartFile file, @PathVariable("courseId") Integer courseId,  String videoName, Double videoPrice) throws IllegalStateException, IOException {


        //获取tomcat所在的目录
        //System.out.println(System.getProperty("catalina.base"));
        //String path=System.getProperty("catalina.base");
        //TODO 这两个字符串应该配置起来
        //必须存在该文件夹结构，不然会报错，这里确定是存在该结构的
        //String newPath=path.replace("tomcat8-2", "nginx/html/home/video");

        //获取视频文件名

        //windows上传图片D:\nginx\html\home\teacherImg
        //linux上传图片/usr\local\nginx\html\home\teacherImg
        //课程的图片
        File video = null;
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //String path = "D:/nginx/html/home/teacherImg";
        String path = "/usr/local/nginx/html/home/video/";
		/*File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}*/

        //文件后缀名
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf(".");
        String suffix = fileName.substring(i, fileName.length());
        video = new File(path, courseId + "_video_" + date + suffix);


        //开始上传
     //   file.transferTo(video);
        System.out.println(video.getName());
        //设置访问权限
     //   Runtime.getRuntime().exec("chmod 755 " + path + video.getName());


        //文件名是以源文件名+courseId,防止不同教师上传相同文件名的视频覆盖其他教师的视频

        //获取文件后缀名
        //String videoSuffix=fileName.substring(fileName.lastIndexOf("."), fileName.length());
        //获取文件名，不含后缀
        //String videoName=fileName.substring(0, fileName.lastIndexOf("."));
        //重新生成视频文件名，含后缀
        //String newFileName=videoName+courseId+videoSuffix;

        //video=new File(newPath+"/",newFileName);

        //开始上传
        //file.transferTo(video);

        //查询出该课程然后更新video表
        Course course = courseService.findCourseById(courseId);


        //上传成功之后应该是添加一条video记录
        Video newVideo = new Video();
        newVideo.setCourseId(courseId);
        //使视频的缩略图与课程一致
        newVideo.setVideoImg(course.getCourseImg());
        //设置视频的名称与文件名一致，上传成功再提示修改
        newVideo.setVideoName(videoName);
        newVideo.setVideoPath(video.getName());
        //设置单个视频的价格,应该是添加课程之后的总价/lessionNum
        newVideo.setVideoPrice(videoPrice);

        videoService.saveVideo(newVideo);
        course.setLessionNum(course.getLessionNum()+1);
        course.setCoursePrice(course.getCoursePrice()+videoPrice);
        courseService.updateCourse(course);
        System.out.println(fileName + "上传成功");

    }

    /**
     * 跳转到上传视频页面
     * 传videoId参数过来
     *
     * @param model
     * @return
     */
    @GetMapping(value = "uploadVideoPage/{courseId}")
    public String uploadVideoPage(Model model, @PathVariable("courseId") Integer courseId) {
        System.out.println(courseId);
        model.addAttribute("courseId", courseId);
        return "course/video-upload";
    }
}
