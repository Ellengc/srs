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
					<td>编号</td>
					<td>教师名称</td>
					<td>职称</td>
					<td>学院</td>
				</tr>
			</thead>
			<c:forEach items="${professors}" var="transcript" varStatus="idx">
			
				<tr>
					<td>${transcript.ssn}</td>
					<td>${transcript.name}</td>
					<td>${transcript.title}</td>
					<td>${transcript.department}</td>

				</tr>

			</c:forEach>
		</table>
	<button class="btn add" onclick="addProfessor()">添加</button>

	</div>
<script type="text/javascript">
	$(function(){
	$('#zsg').dialog({
		closed:'true'
	});
	$('#name').textbox({       
			label: '姓名:',
			labelPosition: 'left',
			prompt: '请输入教师姓名'      
		});
	$('#ssn').textbox({    
			label: '工号:',
			labelPosition: 'left',
			prompt: '请输入教师工号' 
	}); 
	})

</script>
	<div id="zsg">
		<form  id="professor">
    	<table>
			<tr><td><input id="name" type="text" name="name" style="width:300px"></td></tr>    	
			<tr><td><input type="text"  name="ssn" style="width:300px" id="ssn"></input></td></tr> 
			<tr><td>
				<select id="title" class="easyui-combobox"  data-options="label:'职称',labelPosition: 'left',prompt: '请选择职称'" name="title" style="width:300px;">   
				    <option value="教授">教授</option>   
				    <option>副教授</option>   
				    <option>讲师</option>   
				    <option>助教</option>   
				</select>
			</td></tr> 
			<tr><td>
				<select id="department" class="easyui-combobox"  data-options="label:'学院',labelPosition: 'left',prompt: '学院'" name="department" style="width:300px;">   
				    <option value="能源、材料与物理学部">能源、材料与物理学部</option>   
				    <option>矿业工程学院</option>   
				    <option>安全工程学院</option>   
				    <option>力学与土木工程学院</option>
				    <option>机电工程学院</option>
				    <option>信息与控制工程学院</option>
				    <option>资源与地球科学学院</option>
				    <option>化工学院</option>
				    <option>环境与测绘学院</option>
				    <option>电气与动力工程学院</option>
				    <option>数学学院</option>
				    <option>计算机科学与技术学院</option>
				    <option>管理学院</option>
				    <option>公共管理学院</option>
				    <option>马克思主义学院</option>
				    <option>外国语言文化学院</option>
    				<option>建筑与设计学院</option>
    				<option>体育学院</option>
    				<option>孙越崎学院</option>
    				<option>国际学院  </option>
				</select>
			</td></tr> 
    	</table>
    </form>
	</div>

</div>