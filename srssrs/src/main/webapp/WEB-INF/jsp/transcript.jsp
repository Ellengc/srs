<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/easyui/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-form.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/json2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<div class="orders-items">
	<div class="container">
	
		<table class="table" style="height: 300px">
			<thead>
				<tr>
					<td>课程名称</td>
					<td>成绩</td>
					<td>时间</td>
					<td>绩点</td>
				</tr>
			</thead>
			<c:forEach items="${transcripts}" var="transcript" varStatus="idx">
			
				<tr>
					<td>${transcript.name}</td>
					<td>${transcript.grade}</td>
					<td>${transcript.time}</td>
					<td>${transcript.credits}</td>

				</tr>

			</c:forEach>
		</table>
		<div id="tc"></div>
		<table id="enrolledstu"></table>
	</div>
</div>