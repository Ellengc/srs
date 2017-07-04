//js
$(function() {
	$(".usermenuleft a").click(function() {		
		var menu = $(this).text()
		$(".usermenuleft .active").removeClass("active")
		$(this).addClass("active")
		$(".panel-title").text(menu)
        index.switchMenu(menu)	
	
	})



})

function queryEnrolledStudents(sectionNo){
	$('#stu').dialog({
		title: '已选学生',
	    width: 400,
	    height: 500,
	    closed: false,
	    cache: false,
	    modal: true
	}) ;
	$('#enrolledstu').datagrid({    
	    url:'queryEnrolledStudents?sectionNo='+sectionNo,  
	    fitColumns:true,	//自动适应列
       	fit:true,			//表格宽高自适应
        nowrap:false,
        striped:true,		//斑马线效果
		singleSelect:true,	//单行选中
        loadmsg:'请等待...',	//加载等待时显示
        height:100,
        closed:false,
        /* toolbar:'#btn', */	
        columns:[[    
	        {field:'ssn',title:'学号',width:100,hidden:true}, 
	        {field:'name',title:'姓名',width:100},
	        {field:'degree',title:'年级',width:100}, 
	        {field:'major',title:'专业',width:100}
		]]
	});  
	
}

function selectSection(sectionNo,name){
	var text="确定选择"+name+"这门课程吗？"
	$("#tc").text(text)
	$('#tc').dialog({
		title: '选课确认',
	    width: 300,
	    height: 150,
	    closed: false,
	    cache: false,
	    modal: true,
	    buttons:[{
			text:'确定',
			iconCls:'icon-ok',
			handler:function(){
				$.ajax({
				      url:'selectSection',
				      data:{'sectionNo':sectionNo}, 
				      method:'POST',
				      success:function(res){
				    	  console.log(res)
				    	  $('#tc').dialog('close')
				    	  $("#dg").datagrid("reload");
				    	  $.messager.alert('提示信息',res); 
				      }						    
				})
			}					

		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){$('#tc').dialog('close');}
		}]
	}) 
};

function addProfessor(){
	$('#name').textbox('setValue','');
	$('#ssn').textbox('setValue','');
	$('#ssn').textbox('textbox').attr('readonly',false);
	$('#title').combobox('setValue','教授');//一定要先value后text,否则text与value值会相同全为value值  
	$('#title').combobox('setText', '教授');  
	$('#department').combobox('setValue','能源、材料与物理学部');//一定要先value后text,否则text与value值会相同全为value值  
	$('#department').combobox('setText', '能源、材料与物理学部');
	$('#zsg').dialog({
		title:'增加教师',
		width:400,
		height: 400,
		closed: false,    
	    cache: false,
	    modal:true,
	    buttons:[{
	    	text:'保存',
	    	iconCls:'icon-ok',
	    	handler:function(){
	    		var name=$("#name").val();
	    		var ssn = $("#ssn").val();
	    		var title=$("#title").val();
	    		var department=$("#department").val();
	    		if(name==""){
	    			$.messager.alert('警告','姓名不可为空');
	    		}else if(ssn==""){
	    			$.messager.alert('警告','工号不可为空');	
	    		}else if(title==""){
	    			$.messager.alert('警告','职称不可为空');	
	    		}else if(department==""){
	    			$.messager.alert('警告','学院不可为空');	
	    		}else{
	                $("#professor").ajaxSubmit({
	                	url: 'addProfessor', 
	                    type: "post", 
	                    dataType: "json",
	                    success: function () {
	                    	$('#zsg').dialog({closed: true});
	                    	$.messager.alert('完成','添加成功！');	
	                    	$('#dg').datagrid( 'reload'); 
	                    }
	                   
	                });
	    		}
	    	}
	    },{
	    	text:'关闭',
	    	iconCls:'icon-cancel',
	    	handler:function(){
	    		$('#zsg' ).dialog({closed: true});
	    	}
	    }]
	})
	};
function deleteProfessor(){
	var row = $('#dg').datagrid('getSelected');
	if(row){
		$('#delete').dialog({
			title: '删除',
		    width: 300,
		    height: 150,
		    closed: false,
		    cache: false,
		    modal: true,
		    buttons:[{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					$.ajax({
					      url:'<%=request.getContextPath()%>/deleteProfessor',
					      data:{'ssn':row.ssn},
					      method:'POST',
					      success:function(){
					    	  $('#delete').dialog('close')
					    	   $("#dg").datagrid("reload");
					    	  $.messager.alert('提示信息','删除成功');
					      }						    
					})
				}					

			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){$('#delete').dialog('close');}
			}]
		})
	}
};
function editProfessor(){
	var row = $('#dg').datagrid('getSelected');
	
	$('#name').textbox('setValue',row.name);
	$('#ssn').textbox('setValue',row.ssn);
	$('#ssn').textbox('textbox').attr('readonly',true);
	$('#title').combobox('setValue',row.title);//一定要先value后text,否则text与value值会相同全为value值  
	$('#title').combobox('setText', row.title);  
	$('#department').combobox('setValue',row.department);//一定要先value后text,否则text与value值会相同全为value值  
	$('#department').combobox('setText', row.department);
	$('#zsg').dialog({
		title:'修改教师资料',
		width:400,
		height: 400,
		closed: false,    
	    cache: false,
	    modal:true,
	    buttons:[{
	    	text:'保存',
	    	iconCls:'icon-ok',
	    	handler:function(){
	    		var name=$("#name").val();
	    		var ssn = $("#ssn").val();
	    		var title=$("#title").val();
	    		var department=$("#department").val();
	    		if(name==""){
	    			$.messager.alert('警告','姓名不可为空');
	    		}else if(ssn==""){
	    			$.messager.alert('警告','工号不可为空');	
	    		}else if(title==""){
	    			$.messager.alert('警告','职称不可为空');	
	    		}else if(department==""){
	    			$.messager.alert('警告','学院不可为空');	
	    		}else{
	                $("#professor").ajaxSubmit({
	                	url: 'updateProfessor', 
	                    type: "post", 
	                    success: function (data) {
	                    	console.log(data)
	                    	$('#zsg').dialog({closed: true});
	                    	$.messager.alert('完成','修改成功！');	
	                    	$('#dg').datagrid( 'reload'); 
	                    }
	                   
	                });
	    		}
	    	}
	    },{
	    	text:'关闭',
	    	iconCls:'icon-cancel',
	    	handler:function(){
	    		$('#zsg' ).dialog({closed: true});
	    	}
	    }]
	})
}
var index = {

	URL : {


	usermenu:function(){
		return "changeMenu";
	},



    },
		
	switchMenu:function(menu){	
    	var url=""
      switch (menu){
      case "选课":
    	  url='section'
    	  break
      case "成绩查询"	 :
    	  url="transcript"
    	  break
      case "教师管理":
    	  url="professorManager"
    			  break
      case "课程管理"	:
    	  url="courseManager"
    	  break
      }	
	  $(".panel-body").load(url)
	
	 },
}