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
    $(function () {
        let typeid =${param.typeId};
        getPageInfoSmallByTypePid(1, typeid);
    });

    function getPageInfoSmallByTypePid(pageNum, typeid) {
        $("#pageNum").val(pageNum);
        $("#typePid").val(typeid);
        $.ajax({
            url: "btype/getPageInfoSmallByTypePid",
            data: {"pageNum":pageNum,"typeid":typeid},
            type: "get",
            dataType: "json",
            success: function (res) {
                Dreamer.success("数据请求成功");
                console.log(res);
                let tbody="";
               $(res.list).each(function (index,type) {
                    tbody+=`
                        <tr>
                            <td>\${type.typename}</td>
                            <td>\${type.typedes}</td>
                            <td>
                                <button type="submit" onclick="deleteSmallBtype(\${type.typeid})">删除</button>
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
						<a href="javascript:getPageInfoSmallByTypePid(1,\${typeid})" style="color: blue">首页</a>
						<a href="javascript:getPageInfoBlog(\${res.pageNum-1}, \${typeid})" style="color: blue">上一页</a>
					`;
                }
                //中间值渲染
                let tfootMid="";
                res.navigatepageNums.forEach(value=>{
                    if(value==res.pageNum){
                        tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoSmallByTypePid(\${value},\${typeid})" style="color: red">[\${value}]<a>`;
                    }else {
                        tfootMid+=`&nbsp;&nbsp;<a href="javascript:getPageInfoSmallByTypePid(\${value},\${typeid})" style="color: blue">[\${value}]<a>`;
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
						&nbsp;&nbsp;<a href="javascript:getPageInfoSmallByTypePid(\${res.pageNum+1},\${typeid})" style="color: blue">下一页</a>
						&nbsp;&nbsp;<a href="javascript:getPageInfoSmallByTypePid(\${res.pages},\${typeid})" style="color: blue">尾页</a>
					`;
                }
                //渲染分页
                tfoot=`\${tfootStart}||\${tfootMid}||\${tfootEnd}||总条数：\${res.total}||总页数：\${res.pages}`;
                $("#pagenationId").html(tfoot);
            },
            error: function (error) {
                Dreamer.error("大哥你的数据没过来");
            }
        });
    }
    //删除小类信息
    function deleteSmallBtype(typeid){
        alert(typeid)
        var isdelete=window.confirm("你真的要删除这条博客？");
        if(isdelete){
            let url="btype/deleteBtypeSmallByTypeId/"+typeid;
            $.get(url,function (res) {
                if(res.status=="200"){
                    Dreamer.success(res.msg,2000);
                    let pageNum=$("#pageNum").val();
                    let typePid=$("#typePid").val();
                    getPageInfoSmallByTypePid(pageNum,typePid);
                }else {
                    Dreamer.error(res.msg,2000);
                }
            },"json");
        }
    }
</script>
<body>
<form class="form-inline definewidth m20" action="#" method="get">
    <font color="#777777"><strong>小类信息：</strong></font>
    <input type="hidden" id="pageNum"/>
    <input type="hidden" id="typePid"/>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>小类名称</th>
        <th>介绍</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
    <tfoot>
        <tr>
            <td colspan="3" id="pagenationId">

            </td>
        </tr>
    </tfoot>
</table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" id="addnew">
    <a href="subtype_add.jsp?typeid=${param.typeId}">添加小类</a>
</button>
</body>

</html>
