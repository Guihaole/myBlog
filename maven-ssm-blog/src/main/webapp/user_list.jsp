<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <script>
        $(function () {
            getPageInfo(1,"");
            $("#queryBtn").click(function () {
                $("#uname").val($("#uname").val().replaceAll(" ",""));//去空格
                var uname=$("#uname").val();
                $("#queryUname").val(uname);
                getPageInfo(1,uname);
            });
        });
        //发送分页请求
        function getPageInfo(pageNum,uname) {
            $("#pageNum").val(pageNum);
            let tbody="";
            let tfoot="";
            $.ajax({
                type:"get",
                data:{
                    "pageNum":pageNum,
                    "uName":uname
                },
                url:"user/selectUserPageInfo",
                dataType:"json",
                success:function (res) {
                    Dreamer.success("请求成功",1500);
                    console.log(res);
                    res.list.forEach(function (user,index) {
                        //拼接列表
                        tbody +=`
                            <tr>
                                <td><a href="user_detail.jsp?uid=\${user.uid}">\${user.uname}</a></td>
                                <td>\${user.truename}</td>
                                <td>\${user.email}</td>
                                <td>\${user.utime}</td>
                                <td>
                                        \${user.status==1? "<span style='color: red'>冻结</span>" : "<span style='color: #5cb85c'>未冻结</span>"}
                                </td>
                                <td>
                                    <button onclick="updateStatus(\${user.uid},\${user.status==1?2:1})">
                                        \${user.status==1?'解冻账号':'冻结账号'}
                                    </button>
                                </td>
                            </tr>
                        `;
                    });
                    $("#tbody").html(tbody);
                    //拼接分页查询
                    let tfootStart="";
                    if(res.pageNum!=1){
                        tfootStart+=`
                            <a href="javascript:getPageInfo(1,'\${uname}')" style="color: blue">首页</a>
                            <a href="javascript:getPageInfo(\${res.pageNum-1},'\${uname}')" style="color: blue">上一页</a>
                        `;
                    }else {
                        tfootStart+=`
                            <a href="javascript:void(0)" style="color: black">首页</a>
                            <a href="javascript:void(0)" style="color: black">上一页</a>
                        `;
                    }
                    //拼接中间字符串
                    let tfootMiddle="";
                    res.navigatepageNums.forEach(value => {
                        if(value==res.pageNum){
                            //是当前页
                            tfootMiddle+=`
                                &nbsp;&nbsp;<a href="javascript:getPageInfo(\${value},'\${uname}')" style="color: red">[\${value}]</a>
                            `;
                        }else {
                            tfootMiddle+=`
                                &nbsp;&nbsp;<a href="javascript:getPageInfo(\${value},'\${uname}')" style="color: blue">\${value}</a>
                            `;
                        }
                    });
                    let tfootEnd="";
                    if(res.pageNum!=res.pages){
                        tfootEnd+=`
                            <a href="javascript:getPageInfo(\${res.pageNum+1},'\${uname}')" style="color: blue">下一页</a>
                            <a href="javascript:getPageInfo(\${res.pages},'\${uname}')" style="color: blue">尾页</a>
                        `;
                    }else {
                        tfootEnd+=`
                             <a href="javascript:void(0)" style="color: black">下一页</a>
                            <a href="javascript:void(0)" style="color: black">尾页</a>
                        `;
                    }
                    tfoot=`\${tfootStart}|| \${tfootMiddle} ||\${tfootEnd}|| 总页数：\${res.pages} || 总条数：\${res.total}`;
                    $("#tfoot").html(tfoot);
                },
                error:function (error) {
                    Dreamer.error("请求失败");
                }
            });
        }
        function updateStatus(uid,status) {
            alert(uid+"------"+status);
            var pageNum=$("#pageNum").val();
            var queryUname=$("#queryUname").val();
            $.ajax({
                type: "get",
                data: {
                    "uid": uid,
                    "status": status
                },
                url: "user/updateUserStatusByUid",
                dataType: "json",
                success:function(res){
                    if(res.status=="200"){
                        //修改状态
                        Dreamer.success("success修改成功");
                        getPageInfo(pageNum,queryUname);
                    }else {
                        Dreamer.error("error修改失败");
                    }
                },
                error:function(error){
                    Dreamer.error(error);
                }

            });
        }
    </script>
</head>
<body>

<form id="form1" class="form-inline definewidth m20" action="#" method="get">
     <font color="#777777"><strong>用户名：</strong></font>
    <input type="hidden" name="pageNum" id="pageNum"/>
    <input type="hidden" name="queryUname" id="queryUname"/>
    <input type="text" name="uname" id="uname" class="abc input-default " placeholder="请填写用户名" value="">&nbsp;&nbsp;
    <button type="button" class="btn btn-primary queryBtn" id="queryBtn">查询</button>
</form>
<table id="usertable" class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>Email</th>
        <th>注册日期</th>
        <th>是否冻结</th>
        <th>账户冻结</th>
    </tr>
    </thead>
    <tbody id="tbody">
    <%--填写用户列表数据--%>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    <tfoot id="tfoot">
    <tr>

        <td colspan="5" id="pagenationId">

        </td>
    </tr>
    </tfoot>
</table>

</body>
</html>
