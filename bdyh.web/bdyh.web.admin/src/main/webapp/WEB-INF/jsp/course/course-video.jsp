<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>播放视频</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
  </head>
  
  <body>
    <!-- <video width="85%" height="80%" src="http://bdpak.cn:8080/home/video/renshiyuandedingyi.mp4" controls="controls">
	</video> -->
	<video width="85%" height="80%" src="http://bdpak.cn:8080/home/video/${video.videoPath }" controls="controls">
	</video>
  </body>
</html>
