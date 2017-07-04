<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/icon.css">   
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>   
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<div class="orders-items">
	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<td>名称</td>
					<td>学分</td>
					<td>周次</td>
					<td>时间</td>
					<td>教室</td>
					<td>容量</td>
					<td>教师</td>
					<td>选课</td>
					<td>查看已选学生</td>
				</tr>
			</thead>
			<c:forEach items="${sections}" var="section">
				<tr>
					<td>${section.name}</td>
					<td>${section.credits}</td>
					<td>${section.day}</td>
					<td>${section.time}</td>
					<td>${section.room}</td>
					<td>${section.capacity}</td>
					<td>${section.teacher}</td>
					<td><button class="btn" style='' onclick=selectSection('${section.sectionNo}','${section.name}')>选课</button></td>
					<td><button class="btn"  style='' onclick=queryEnrolledStudents('${section.sectionNo}')>查看</button></td>
				</tr>

			</c:forEach>
		</table>
    <div id="tc"></div>
    <table id="enrolledstu"></table>
	</div>
</div>