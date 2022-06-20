<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquerypicture.js"></script>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <%--提示消息插件--%>
    <script src="js/Dream-Msg/lib/dream-msg.min.js"></script>
    <style type="text/css">
        body {
            font-size: 20px;
            padding-bottom: 40px;
            background-color: #e9e7ef;
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
</head>
<script>
    $(function () {
        alert(${param.typeid})
        $("#typePid").val(${param.typeid});
        $("#saveBtn").click(function () {
            let typePid = $("#typePid").val();
            alert(typePid);
            let typename = $("#typename").val();
            let typedes = $("#typedes").val();
            $.ajax({
                url: "btype/addTypeSmall",
                data: {
                    typePid: typePid,
                    typename: typename,
                    typedes: typedes
                },
                type: "post",
                dataType: "json",
                success: function (res) {
                    if (res.status = "200") {
                        Dreamer.success(res.msg, 2000);
                    } else {
                        Dreamer.error(res.msg, 2000)
                    }
                },
                error: function (error) {
                    Dreamer.error("程序出错了");
                }
            });
        });
    });
</script>
<body><br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<font color="#777777"><strong>添加小类：</strong></font>
<form action="#" method="post" class="definewidth m20" id="typeForm2">
    <table style="margin-left:10px;margin-top:3px;">
        <%--页面传递的typeid 充当typePid--%>
        <input type="hidden" id="typePid" value=""/>
        <tr>
            <td>小类名称：</td>
            <td><input type="text" name="typename" id="typename" style="width:400px;" placeholder='请输入小类名称'/></td>
        </tr>

        <tr>
            <td>介绍：</td>
            <td><input type="text" name="typedes" id="typedes" style="height: 100px;width:400px;"
                       placeholder='请输入小类详情'/></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button style="margin-left:5px;" type="button" class="btn btn-primary" id="saveBtn">
                    保&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp存
                </button>
                &nbsp;&nbsp
                <button type="button" class="btn btn-success" name="backid" id="backid">
                    <a href="type_list.jsp"> 返回列表</a>
                </button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>


