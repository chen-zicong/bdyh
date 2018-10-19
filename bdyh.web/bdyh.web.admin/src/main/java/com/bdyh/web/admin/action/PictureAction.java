package com.bdyh.web.admin.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdyh.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bdyh.entity.HomePicture;
import com.bdyh.service.PictureService;

/**
 * banner图
 * 2018年2月2日
 *
 * @author cxs
 */


@Controller
@RequestMapping(value = "picture")
public class PictureAction {

    @Autowired
    private PictureService pictureService;

    /**
     * 显示所有图片
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "pictureList")
    public String pictureList(Model model) {
        //查询所有的轮播图,包括停用的
        List<HomePicture> homePictureList = pictureService.findAllHomePicture();
        //传递参数到picture-list.jsp页面
        model.addAttribute("homePictureList", homePictureList);
        return "home_picture/picture-list";
    }

    /**
     * 跳转到添加轮播图页面
     *
     * @return
     */
    @GetMapping(value = "pictureAddPage")
    public String pictureAddPage() {
        return "home_picture/picture-add";
    }

    /**
     * 上传图片
     *
     * @param file
     * @param request
     * @param response
     * @throws IOException
     * @throws IllegalStateException
     */
    @PostMapping(value = "uploadPicture")
    public void uploadPicture(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        //课程的图片
        File picture = null;

        //获取tomcat所在的目录
		/*System.out.println(System.getProperty("catalina.base"));
		String path=System.getProperty("catalina.base");*/

        //TODO 这两个字符串应该配置起来
        //必须存在该文件夹结构，不然会报错，这里确定是存在该结构的
        /*String newPath=path.replace("tomcat8-2", "nginx/html/home/home_picture");*/
        String path = "/usr/local/nginx/html/home/home_picture/";
        //获取文件名
        String fileName = file.getOriginalFilename();
        //文件后缀名
        int i = fileName.lastIndexOf(".");
        String suffix = fileName.substring(i, fileName.length());
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        picture = new File(path, "teacher" + date + suffix);

        //开始上传
        file.transferTo(picture);
        //设置访问权限
        Runtime.getRuntime().exec("chmod 755 " + path + picture.getName());


        //保存该记录到数据库
        HomePicture homePicture = new HomePicture();
        homePicture.setPictureName(picture.getName());
        homePicture.setPicturePath(picture.getName());
        homePicture.setStatus(0);
        pictureService.saveHomePicture(homePicture);

        System.out.println(fileName + "上传成功");
    }

    /**
     * 图片下架
     *
     * @param pictureId
     */
    @GetMapping(value = "pictureLayDown")
    public void pictureLayDown(Integer pictureId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //根据pictureId查询课程对象
            HomePicture homePicture = pictureService.findHomePictureById(pictureId);
            //下架课程，把表的status置为0
            homePicture.setStatus(0);
            //跟新数据库，并删除redis缓存
            pictureService.updateHomePicture(homePicture);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片发布
     *
     * @param pictureId
     */
    @GetMapping(value = "pictureLayUp")
    public void pictureLayUp(Integer pictureId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //根据pictureId查询课程对象
            HomePicture homePicture = pictureService.findHomePictureById(pictureId);
            //申请课程上线，把表的status置为1
            homePicture.setStatus(1);
            //跟新数据库，并删除redis缓存
            pictureService.updateHomePicture(homePicture);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片删除
     *
     * @param pictureId
     * @param response
     */
    @GetMapping(value = "pictureDelete")
    public void pictureDelete(Integer pictureId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //跟新数据库，并删除redis缓存
            pictureService.deleteCourseByCourseId(pictureId);

            //TODO 删除硬盘上的图片文件

            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //批量删除轮播图
    @RequestMapping("batchDeletePicture")
    @ResponseBody
    public APIResponse batchDeletePicture(int [] pictureIds) {
        System.out.println(pictureIds.length);
        int result = pictureService.batchDeletePicture(pictureIds);
        if (result > 0) {
            return APIResponse.success();
        } else {
            return APIResponse.fail("删除失败");
        }


    }
}
