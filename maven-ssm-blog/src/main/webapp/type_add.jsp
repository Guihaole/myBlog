<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="js/jquerypicture.js"></script>
    <script src="js/jquery.min.js?v=2.1.4"></script>

    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
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
</head>
<script>
    $(function(){
        //添加大类信息
        $("#saveBtn").click(function(){
            let typename=$("#typename").val();
            let typedes=$("#typedes").val();
            $.ajax({
               url:"btype/addBTypeBig",
               data:{
                   "typename":typename,
                   "typedes":typedes
               },
               method:"post",
               dataType:"json",
               success:function (res) {
                   if(res.status==200){
                       Dreamer.success(res.msg);
                       window.location.href="type_list.jsp";
                   }
               },
               error:function (error) {
                    Dreamer.error(res.msg);
               }
            });
        });
    });

</script>
<body>
<br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<font color="#777777"><strong>添加大类：</strong></font>
<form id="typeForm" action="#" method="post" class="definewidth m20" >
<table style="margin-left:10px;margin-top:3px;">
    <tr>
         <td>大类名称：</td>
		 <td><input type="text" id="typename" name="typename" style="width:400px;" placeholder='请输入大类名称'/></td>
    </tr>
	<tr>
         <td>介绍：</td>
		 <td><input type="text" id="typedes" name="typedes" style="height: 100px;width:400px;" placeholder='请输入大类详情'/></td>
    </tr>

    <tr>
        <td></td>
       <td>
            <button style="margin-left:5px;"type="button" class="btn btn-primary" id="saveBtn"  >
                保&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp存
            </button> &nbsp;&nbsp;
           <button type="button" class="btn btn-success" name="backid" id="backid">
               <a href="type_list.jsp"> 返回列表</a>
           </button>
        </td>
    </tr>
</table>
</form>

</body>
</html>


