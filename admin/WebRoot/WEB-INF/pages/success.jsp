<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>潭州学院keke老师模板页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<style>

		.numicon{color:#fff;padding:1px 8px;font-weight:700}
		.c1{background:green;}
		.c2{background:red;}
		.c3{background:pink;}
		.c4{background:orange;}
		.c5{background:#111;}
		.c6{background:gray;}	
		/*css代码*/
		.wrap{color:#939da8}
		/*侧边栏*/
		.wrap .slider{width:220px;background:#2E363F;position:fixed;top:0px;left:0;height:100%;}
		.wrap .slider .logo{height:72px;background:#1F262D;line-height:72px;text-align:center;}
		
		.wrap .nav li.items{
			
			border-top: 1px solid #37414b;
			border-bottom: 1px solid #1f262d;
			font-size:12px;
			position:relative;
		}
		.wrap .nav li.items a{padding:8px 110px 8px 21px;display:inline-block;}
		/*silder bar li的样式*/
		.wrap .nav li.items:hover,.wrap .nav li.active{background:#27A9E3}
		.wrap .nav li.items:hover a,.wrap .nav li.active a{color:#fff;}
		.wrap .nav li.items .numicon{float:right;position:absolute;top:8px;right:20px;}
		.wrap .nav li.active:after{
			content:"";
			display:inline-block;
			border-top:8px solid transparent;
			border-right:8px solid #eee;
			border-bottom:8px solid transparent;
			border-left:8px solid transparent;
			float:right;
			position:absolute;
			top:16px;
			right:0px;
		}
		.wrap .nav li .fa{padding-right:10px;font-size:14px;}
		/*silder bar li的样式 里子元素的样式*/
		.wrap .nav li.items ul {background:#111;display:none;}
		.wrap .nav li.items ul li{padding-left:10px;}
		.wrap .content .header{height:36px;background:#1F262D;border-left:1px solid #000}
		/*内容区域*/
		.wrap .content{background:#f8f8f8;margin-left:220px}
		input[placeholder]{color:#e5e5e5;font-size:12px;padding-left:5px;}
		.wrap	.content .header .titems{float:left;border-right:1px solid #999;padding:0px 10px;height:36px;line-height:36px;font-size:12px;}
		.wrap	.content .header .titems a{color:#eaeaea}
		.wrap	.content .header .titems .fa{padding-right:10px;color:#fff}
		.wrap	.content .sbtn{margin-right:20px;}	
		.wrap	.content .sbtn input{height:26px;margin-top:5px;border:0;background:#666}
		.wrap	.content .sbtn a{height:26px;width:46px;display:inline-block;background:#28B779;color:#fff;margin-top:5px;text-align:center;
				font-size:16px;}
		
		.wrap .content .channel{height:36px;line-height:36px;padding-left:10px;}
		.wrap .content .cnt{background:#EEEEEE;}
		.tabwrap{padding:5px;}
		.tztab{width:100%;border-collapse:collapse;border:1px solid #ccc;}
		.tztab th,td{border-bottom:1px solid #fff;text-align:left;padding:4px 6px;font-size:12px;}
		.tztab th{padding:10px;}
		.tztab thead th{background:#2E363F;color:#f9f9f9}
		
		/*单双行渐变*/
		.tztab tbody tr:nth-child(odd){background:#eaeaea}
		.tztab tbody tr:nth-child(even){background:#f8f8f8}
		/*hover改变行的样式*/
		.tztab tbody tr:hover{background:#333;color:#fff}
		.tztab tbody tr:hover a{color:#fff}
		.tztab tbody tr:hover td:hover{background:#28B779}

		.tztab caption{background:#2E363F;color:#fff;padding:5px;font-size:18px;font-weight:700;
			caption-side:top;
			text-align:center;
		}
		.up{
			display:inline-block;
			overflow:hidden;
			border-top:4px solid transparent;
			border-right:4px solid transparent;
			border-bottom:4px solid #fff;
			border-left:4px solid transparent;
		}
		.down{
			display:inline-block;
			overflow:hidden;
			position:relative;
			top:4px;
			border-top:4px solid #fff;
			border-right:4px solid transparent;
			border-bottom:4px solid transparent;
			border-left:4px solid transparent;
		}
  </style>
 </head>
 <body>
	<div class="wrap">
		<div class="slider">
			<div class="logo">
				<a href="#"><img src="${basePath}/resources/images/logo.png"/></a>
			</div>
			<div class="nav">
				<ul>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-home"></i>首页</a></li>
					 <li class="items active"><a href="javascript:void(0);"><i class="fa fa-signal"></i>统计报表</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-th-list"></i>表单</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c5">3</span>
					 </li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-tint"></i>按钮组</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c1">5</span>
					 </li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-pencil"></i>元素</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-star"></i>Addons 5</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-file-o"></i>Error</a></li>
				</ul>
			</div>
		</div>

		<style>
			 
		</style>
		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎keke来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" value="2"   /><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="channel"> Home > Table</div>
			<div class="cnt">
				<div class="tabwrap">
					
					<!--表格-->
					<table class="tztab">
						<caption>
							2015年度一周统计报表数据
							<div class="fr sbtn">
								<input type="text"  value = "${params.keyword}" id="keyword" class="fl" /><a href="javascript:void(0);" class="fl"><i  onclick="search()"  class="fa fa-search "></i></a>
							</div>
						</caption>
						<!--头部
						<colgroup id="days">                                                                                               
							<col/>
							<col style="background:green;width:200px;"/>
							<col id="t"/>
						</colgroup>-->
						<thead>
							<tr>
								<th>ID <span class="up"></span> <span class="down"></span></th>	
								<th>标题</th>	
								<th>作者</th>	
								<th>创建时间</th>	
								<th>点击数</th>	
								<th>喜欢数</th>	
								<th>收藏数</th> 	
								<th>是否置顶</th>
								<th>是否评论</th>	
								<th>删除状态</th>
								
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody">
							<c:forEach var="content" items="${contents}">
								<tr >
									<td>${content.id}</td>	
									<td class="keys">${content.title}</td>	
									<td>${content.userName}</td>	
									<td>${XX:DFormate(content.createTime,"yyyy/MM/dd HH:mm:ss")}</td>	 	
									<td>${content.hits}</td>	
									<td>${content.loves}</td>	
									<td>${content.collections}</td>	 
									<td>
										<c:if test="${content.isTop==1}"><a href="javascript:void(0);" opid="${content.id}" mark="isTop" val="0" onclick="op(this)">是</a></c:if>
										<c:if test="${content.isTop==0}"><a href="javascript:void(0);" opid="${content.id}" mark="isTop" val="1" onclick="op(this)">否</a></c:if>
									</td>	
									<td>
										<c:if test="${content.isComment==1}"><a href="javascript:void(0);" opid="${content.id}" mark="isComment" val="0" onclick="op(this)">是</a></c:if>
										<c:if test="${content.isComment==0}"><a href="javascript:void(0);" opid="${content.id}" mark="isComment" val="1" onclick="op(this)">否</a></c:if>
									</td>	
									<td>
										<c:if test="${content.isDelete==1}"><a href="javascript:void(0);" opid="${content.id}" mark="isDelete" val="0" onclick="op(this)">是</a></c:if>
										<c:if test="${content.isDelete==0}"><a href="javascript:void(0);" opid="${content.id}" mark="isDelete" val="1" onclick="op(this)">否</a></c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			<div>
				<a  href="javascript:void(0);" onclick="addr(1)"> 上一页</a>
				<a href="javascript:void(0);"  onclick="addr(0)">下一页</a>
				<span>总页数：${allPages}</span><input type="text" id="page" name="page" /><a href="javascript:void(0);" onclick="goPage()">GO</a><span style="color:red"id="error"></span>
			</div>

		</div>
	
	</div>


	<script type="text/javascript">
	
	//修改文章属性
		var timer = null;
		function op(obj){
			var $this = $(obj);  
			var opid = $this.attr("opid");
			var mark = $this.attr("mark");
			var val = $this.attr("val");
			var param = {};
			param["id"]=opid;
			param[mark]=val; 
			//alert(JSON.stringify(param));
			//节流，针对频繁性操作，只有最后一次起作用，一进来就把之前的延时效果清掉，取消该事件
			clearTimeout(timer)
			timer = setTimeout(function(){
		//	loading("正在执行",2)
				$.ajax({
				type:"post",
				url:adminPath+"/content/update",
				data:param,
				success:function(data){
					if(data=="success"){
						$this.attr("val",val==0?1:0);
						$this.html(val==0?'否':'是');
					}else if(data=="logout"){
						alert("这边可以是弹出登陆框即可,因为没有写登陆框，所以就跳转到登录页面");
						window.location.href=basePath+"/login"
					}
				}
			}) 
			},200) 
		}
		//高亮设置    ，思想是这样的：老师是用ajax来体现查询，而我是重新加载页面，因此跟老师的一模一样方法是不能实现高亮的，因为效果会被刷新掉
		//老师的思路是：给要修改的栏目加属性，然后遍历该栏目，对其里面的数据进行替换'<span style="color=red">'+key+'</span>' 用字符串代替+正则进行处理，然后给元素的文本内容重新复制
		//在springmvc+mybatis实战的第5节 前半小时
		function highLight(key){
			if(key!=null||key!=undefined||key.length>0){
				$("#tbody").find(".keys").each(function(){
					$(this).html(key)
				})
			}
		}
		$(function(){
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
		
		function goPage(){
			var page = document.getElementById("page").value;
			if(page<=${allPages}&&page>0){  
				addr()
			}
			else{
				document.getElementById("error").innerHTML="没有该第"+page+"页，请重新输入";
				document.getElementById("page").value=""
			}
		}
		
		function search(){
			var keyword = document.getElementById("keyword").value; 
			window.location.href=adminPath+"/index?keyword="+keyword;
		//	highLight(keyword)
		} 
		
		//keyword 表示是否有模糊查询，page 表示是上下页0还是 跳转1
		function addr(near){
			var keyword = document.getElementById("keyword").value;
			var page = document.getElementById("page").value;
			//查询
			if(keyword){ 
				//跳转
				if(page)
					window.location.href =(adminPath+"/index?pageNum="+page+"&keyword="+keyword);
				else//上下页面
					//上一页
					if(near)
						window.location.href =(adminPath+"/index?pageNum="+${params.pageNum-1}+"&keyword="+keyword);
					else//下一页 
						window.location.href =(adminPath+"/index?pageNum="+${params.pageNum+1}+"&keyword="+keyword);
			}
			//不带查询
			else{
				//跳转
				if(page)
					window.location.href =(adminPath+"/index?pageNum="+page);
				else//上下页面
					//上一页
					if(near)
						window.location.href =(adminPath+"/index?pageNum="+${params.pageNum-1});
					else//下一页 
						window.location.href=(adminPath+"/index?pageNum="+${params.pageNum+1});
			}
				
		}
	</script>
 </body>
</html>