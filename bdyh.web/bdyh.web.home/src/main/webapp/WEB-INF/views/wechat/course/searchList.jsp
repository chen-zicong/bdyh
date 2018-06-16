<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<ul class="am-list">
		<c:forEach items="${courseList }" var="course">
			<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
			<div onclick=checkPay(${course.courseId},${course.coursePrice})>
				<div class="am-u-sm-4 am-list-thumb">
				  <%--<a href="${pageContext.request.contextPath}/course/courseDetails/${course.courseId}" class="">--%>
				    <img src="http://bdpak.cn:8080/home/courseImg/${course.courseImg }"/>
				  <%--</a>			--%>
				</div>
				
				<div class=" am-u-sm-8 am-list-main">
				    <h3 class="am-list-item-hd">
						<%--<a href="${pageContext.request.contextPath}/course/courseDetails/${course.courseId}" >${course.courseName }</a>--%>
					</h3>
				    <div class="am-list-item-text">${course.courseDesc }</div>
				    <div class="am-list-item-text">
						<span style="color:#f37b1d;">
							<c:choose>
								<c:when test="${course.coursePrice eq 0 }">
									免费
								</c:when>
								<c:otherwise>
									${course.coursePrice }元
								</c:otherwise>
							</c:choose>
						</span>
						<span class="am-list-news-lesson-amount am-fr">共${course.lessionNum }节课</span>		
			        </div>
			        <!-- <div class="am-list-item-text">
						<span class="am-list-news-lesson-amount ">10000人已学</span>
			        </div>	 -->
				</div>
			</div>
			</li>
		</c:forEach>
	</ul>
