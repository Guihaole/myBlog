<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<script src="js/jquery.min.js?v=2.1.4"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<%--<script type="text/javascript" src="js/jquery2.js"></script>--%>
<%--<script type="text/javascript" src="js/jquery2.sorted.js"></script>--%>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/ckform.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<style type="text/css">
body {font-size: 20px;
	padding-bottom: 40px;
	background-color: #e9e7ef;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
	<%--提示消息插件--%>
    <script src="js/Dream-Msg/lib/dream-msg.min.js"></script>
</head>
<script>
	//文档加载函数
	$(function(){
		getPageInfoBlog(1);
	});
	//删除博客请求
	function deleteInfo(bid) {
		var isdelete=window.confirm("确定要删除？");
		if(isdelete){
			let url="blog/deleteBlogByBid/"+bid;
			$.get(url,function (res) {
				if(res.status==200){
					Dreamer.success(res.msg,2000);
					getPageInfoBlog(1);
				}else {
					Dreamer.error(res.msg);
				}
			},"json");
		}
	}
	//发送请求请求列表数据
	function getPageInfoBlog(pageNum){
		$.ajax({
			url:"blog/getPageInfoBlog",
			data:{"pageNum":pageNum},
			type:"get",
			dataType:"json",
			success:function(res){
				Dreamer.success("请求成功，请大哥等待数据");
				console.log(res);
				//渲染请求体
				let tbody="";
				res.list.forEach(function(blog,index){
					tbody+=`
					<tr align="center">
						<td>\${blog.btitle}</td>
						<td>\${blog.btype.typename}</td>
						<td>\${blog.user.truename}</td>
						<td>\${blog.date}</td>
						<td>
						<a href="javascript:deleteInfo(\${blog.bid})">删除 </a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="blog_detail.jsp?bid=\${blog.bid}&truename=\${blog.user.truename}&email=\${blog.user.email}">博客详情</a>
						</td>
					</tr>
					`;
				});
				$("#tbody").html(tbody);
				//渲染分页
				let tfoot="";
				let tfootStart="";
				if (res.pageNum==1){
					tfootStart=`
						<a href="javascript:void(0)" style="color: black">首页</a>
						<a href="javascript:void(0)" style="color: black">上一页</a>
					`;
				}else {
					tfootStart=`
						<a href="javascript:getPageInfoBlog(1)" style="color: blue">首页</a>
						<a href="javascript:getPageInfoBlog(\${res.pageNum-1})" style="color: blue">上一页</a>
					`;
				}
				//中间值渲染
				let tfootMid="";
				res.navigatepageNums.forEach(value=>{
					if(value==res.pageNum){
						tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoBlog(\${value})" style="color: red">[\${value}]<a>`;
					}else {
						tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoBlog(\${value})" style="color: blue">[\${value}]<a>`;
					}
				});
				let tfootEnd="";
				if(res.pageNum==res.pages){
					tfootEnd=`
						&nbsp;&nbsp;<a href="javascript:void(0)" style="color: black">下一页</a>
						&nbsp;&nbsp;<a href="javascript:void(0)" style="color: black">尾页</a>
					`;
				}else {
					tfootEnd=`
						&nbsp;&nbsp;<a href="javascript:getPageInfoBlog(\${res.pageNum+1})" style="color: blue">下一页</a>
						&nbsp;&nbsp;<a href="javascript:getPageInfoBlog(\${res.pages})" style="color: blue">尾页</a>
					`;
				}
				//渲染分页
				tfoot=`\${tfootStart}||\${tfootMid}||\${tfootEnd}||总条数：\${res.total}||总页数：\${res.pages}`;
				$("#tfoot").html(tfoot);
			},
			error:function (error) {
				Dreamer.error("请求失败，大哥你程序出错啦");
			}
		});
	}
</script>
<body>
	<form class="form-inline definewidth m20" action="#" method="get">
	<a href="documentAdd.jsp">发布博客</a>

	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr align="center">
				<th>博客标题</th>
				<th>博客类别</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>管理菜单</th>
			</tr>
		</thead>
		<tbody id="tbody">
		   <%--存放行数据--%>

		</tbody>
		<tfoot id="tfoot">
			<%--设置分页信息--%>
		</tfoot>

	</table>
</body>
</html>
