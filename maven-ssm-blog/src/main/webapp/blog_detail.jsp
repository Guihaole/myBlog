<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/showdate.js"></script>
	<script src="js/jquery.min.js?v=2.1.4"></script>
    <style type="text/css">
        body {font-size: 20px;
             padding-bottom: 40px;
             background-color:#e9e7ef;
             font-size:17px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
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
	<script>
		$(function () {
			var bid=${param.bid};
			getBlogByBid(bid);
			getPageInfoEvaluateByBid(1,bid);
		});
		//根据bid请求博客记录
		function getBlogByBid(bid) {
			var url="blog/getBlogByBid/"+bid;
			$.get(url,function (res) {
				$("#content").html(res.bcontent);
				$("#time").html(res.date);
			},"json");
		}
		//根据bid请求所有的评论信息
		function getPageInfoEvaluateByBid(pageNum,bid){
			var url="evaluate/getPageInfoEvaluateByBid";
			$.ajax({
				url:url,
				type:"get",
				data:{
					"pageNum":pageNum,
					"bid":bid
				},
				dataType:"json",
				success:function (res) {
					console.log(res);
					let tbody="";
					res.list.forEach(function (evaluate) {
						tbody+=`
							<tr>
							<td>\${evaluate.econtent}</td>
							<td>\${evaluate.etime}</td>
							<td><button type="button" onclick="deleteComment(\${evaluate.eid},\${bid})" id="deletecomment">删除</button></td>
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
						<a href="javascript:getPageInfoEvaluateByBid(1,\${bid})" style="color: blue">首页</a>
						<a href="javascript:getPageInfoEvaluateByBid(\${res.pageNum-1},\${bid})" style="color: blue">上一页</a>
					`;
					}
					//中间值渲染
					let tfootMid="";
					res.navigatepageNums.forEach(value=>{
						if(value==res.pageNum){
							tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoEvaluateByBid(\${value},\${bid})" style="color: red">[\${value}]<a>`;
						}else {
							tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoEvaluateByBid(\${value},\${bid})" style="color: blue">[\${value}]<a>`;
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
						&nbsp;&nbsp;<a href="javascript:getPageInfoEvaluateByBid(\${res.pageNum+1},\${bid})" style="color: blue">下一页</a>
						&nbsp;&nbsp;<a href="javascript:getPageInfoEvaluateByBid(\${res.pages},\${bid})" style="color: blue">尾页</a>
					`;
					}
					//渲染分页
					tfoot=`\${tfootStart}||\${tfootMid}||\${tfootEnd}||总条数：\${res.total}||总页数：\${res.pages}`;
					$("#tfoot").html(tfoot);
				},
				error:function (error) {
					Dreamer.error("请求错误");
				}
			});
		}
		//删除评论的方法
		function deleteComment(eid,bid) {
			var isdelete=window.confirm("确定要删除？");
			if(isdelete){
				let url="evaluate/deleteEvaluateByEid/"+eid;
				$.get(url,function (res) {
					if(res.status==200){
						Dreamer.success(res.msg,2000);
						getPageInfoEvaluateByBid(1,bid);
					}else {
						Dreamer.error(res.msg);
					}
				},"json");
			}
		}
	</script>
</head>
<h3><strong>博客信息：</strong></h3>
      <table class="table table-condensed">
               <tr>
	              <td width="18%" height="30" align="center">博主名称：</td>
	              <td id="uname" width="82%" class="word_grey">
					 <%--博主名称--%>${param.truename}
				  </td>
	            </tr>
	            <tr>
	              <td height="28" align="center">邮箱</td>
	              <td height="28" id="email">${param.email}</td>
	            </tr>
				  <tr>
					  <td height="28" align="center">发布内容：</td>
					  <td height="28" id="content">的设计费看就看的房间</td>
				  </tr>
	            <tr>
	              <td height="28" align="center">发布时间：</td>
	              <td height="28" id="time" >2022-11-15 12:33:23</td>
	            </tr>
	  </table>

<h3><strong>全部评价内容：</strong></h3>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>评价内容</th>
			<th>评价时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
	<tfoot id="tfoot">

	</tfoot>
</table>
</body>

</html>
