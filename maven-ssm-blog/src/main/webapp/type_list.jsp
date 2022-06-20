<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <style type="text/css">
        body {
            font-size: 20px;
            padding-bottom: 40px;
            background-color: #e9e7ef;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media ( max-width: 980px) {
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
        flushPage(${param.pageNum});
    });
    //刷新页面的方法
    function flushPage(pageNum) {
        if(pageNum==undefined){
            getPageInfoBtypeList(1);
        }else {
            getPageInfoBtypeList(pageNum);
        }
    }
    //请求信息类别的数据
    function getPageInfoBtypeList(pageNum) {
        $("#pageNum").val(pageNum);
        $.ajax({
            url:"btype/getPageInfoBtypeList",
            type:"get",
            dataType:"json",
            data:{
             "pageNum":pageNum
            },
            success:function (res) {
                console.log(res);
                //拼接tbody
                let tbody="";
                res.list.forEach(function (data) {
                    let tbodyStart="";
                    let tbodyEnd="";
                    let tbodyMid="";
                    tbodyStart=`
                        <tr>
                            <td>\${data.typename}</td>
                            <td>\${data.typedes}</td>
                            <td><select>
                    `;
                    data.btypeList.forEach(type=>{
                        tbodyMid+=`
                            <option value="\${type.typename}">\${type.typename}</option>
                        `;
                    });
                    tbodyEnd=`
                        </select></td>
                        <td>
                           <button type="submit"><a href="subtype_list.jsp?typeId=\${data.typeid}">管理小类</a></button>
                        </td>
                        <td>
                           <button type="submit"><a href="type_update.jsp?typeId=\${data.typeid}&pageNum=\${pageNum}">修改</a></button>
                        </td>
                        <td>
                           <button type="submit" typeId="\${data.typeid}" onclick="deleteType(\${data.typeid})">删除</button>
                        </td>
                        </tr>
                    `;
                    tbody+=`
                          \${tbodyStart} \${tbodyMid} \${tbodyEnd}
                    `;
                });
                //选染tbody
                $("#tbody").html(tbody);

                //渲染分页
                let tfootStart="";
                if(res.pageNum==1){
                    tfootStart=`
                        <a href="javascript:void(0)" style="color: black">首页</a>
                        <a href="javascript:void(0)" style="color: black">上一页</a>
                    `;
                }else{
                    tfootStart=`
                        <a href="javascript:getPageInfoBtypeList(1)" style="color: blue">首页</a>
                        <a href="javascript:getPageInfoBtypeList(\${res.pageNum-1})" style="color: blue">上一页</a>
                    `;
                }

                let tfootMid="";
                res.navigatepageNums.forEach(value=>{
                    if(value==res.pageNum){
                        tfootMid+=`
                          &nbsp; &nbsp;<a href="javascript:getPageInfoBtypeList(\${value})" style="color: mediumvioletred">[\${value}]</a>
                        `;
                    }else{
                        tfootMid+=`
                          &nbsp; &nbsp; <a href="javascript:getPageInfoBtypeList(\${value})" style="color: darkslateblue">\${value}</a>
                        `;
                    }
                });
                //后面
                let tfootEnd="";
                if(res.pageNum==res.pages){
                    tfootEnd=`
                        <a href="javascript:void(0)" style="color: black">下一页</a>
                        <a href="javascript:void(0)" style="color: black">尾页</a>
                    `;
                }else{
                    tfootEnd=`
                        <a href="javascript:getPageInfoBtypeList(\${res.pageNum+1})" style="color: blue">下一页</a>
                        <a href="javascript:getPageInfoBtypeList(\${res.pages})" style="color: blue">尾页</a>
                    `;
                }

                let tfoot=`
                    \${tfootStart}||\${tfootMid}||\${tfootEnd}||总条数：\${res.total}||总页数：\${res.pages}
                `;
                $("#tfoot").html(tfoot)
            },
            error:function (error) {
                Dreamer.error("数据请求出错啦，大哥你代码有bug");
            }
        });
    }
    //请求删除博客的大类和小类
    function deleteType(typeid){
        var isdelete=window.confirm("你真的要删除这条博客？");
        if(isdelete){
            let url="btype/deleteBtypeBigByTypeId/"+typeid;
            $.get(url,function (res) {
                if(res.status=="200"){
                    Dreamer.success(res.msg,2000);
                    // let pageNum=$("#pageNum").val();
                    // getPageInfoBtypeList(pageNum);
                    $(`button[typeId=\${typeid}]`).parents("tr").remove();
                }else {
                    Dreamer.error(res.msg,2000);
                }
            },"json");
        }
    }
</script>
<body>
<form class="form-inline definewidth m20" action="#" method="get">
    <font color="#777777"><strong>大类信息：</strong></font>
    <input type="hidden" id="pageNum"/>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>大类名称</th>
        <th>类别描述</th>
        <th>查看小类</th>
        <th>小类管理</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
    <tfoot id="tfoot">

    </tfoot>
</table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" id="addnew">
    <a href="type_add.jsp">添加大类</a>
</button>
</body>
</html>
