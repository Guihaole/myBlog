<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <%--<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.sorted.js"></script>--%>
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
	<script>
		$(function () {
			getSelectUserByUid();
		});
		function getSelectUserByUid() {
			var uid=${param.uid};
			var url=`user/selectUser/\${uid}`;
			var type="json";
			$.get(url,function (res) {
				console.log(res);
				$("#uname").html(res.uname);
				$("#truename").html(res.truename);
				$("#utype").html(res.utype==1?"管理员":"普通用户");
				$("#email").html(res.email);
				$("#utime").html(res.utime);
			},type);
		}
	</script>
</head>
<h3><strong>基本信息：</strong></h3>
   <table class="table table-condensed">
               <tr>
	              <td width="18%" height="30" align="center">用 户 名：</td>
	              <td width="82%" class="word_grey" id="uname"></td>
	            </tr>
				<tr>
	              <td width="18%" height="30" align="center">真实姓名：</td>
	              <td width="82%" class="word_grey" id="truename"></td>
	            </tr>
	            <tr>
	              <td height="28" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	              <td height="28">******</td>
	            </tr>
				<tr>
	              <td height="28" align="center">用户类型：</td>
	              <td height="28" id="utype"></td>
	            </tr>
	            <tr>
	              <td height="28" align="center">E-mail：</td>
	              <td height="28" id="email"></td>
	            </tr>

	            <tr>
	              <td height="28" align="center">创建时间：</td>
	              <td height="28" id="utime"></td>
	            </tr>
	        </table>


</body>
</html>
