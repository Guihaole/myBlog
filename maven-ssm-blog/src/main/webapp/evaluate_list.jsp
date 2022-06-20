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
    //文档加载函数
    $(function(){
        getPageInfoEvaluate(1,"");
        $("#queryBtn").click(function () {
            $("#menuname").val($("#menuname").val().replaceAll(" ",""));
            let menuname = $("#menuname").val();
            getPageInfoEvaluate(1,menuname);
        });
    });
    //请求列表数据
    function getPageInfoEvaluate(pageNum,uname) {
        $.ajax({
           url:"evaluate/getPageInfoEvaluate",
           type:"get",
           data:{
               "pageNum":pageNum,
               "uname":uname
           },
           dataType:"json",
           success:function (res) {
               Dreamer.success("请求成功");
               console.log(res);
               let tbody="";
               res.list.forEach(evaluate=>{
                   tbody+=`
                       <tr>
                            <td>\${evaluate.blog.bcontent}</td>
                            <td><a href="user_detail.jsp">\${evaluate.user.truename}</a></td>
                            <td>\${evaluate.blog.btitle}</td>
                            <td>\${evaluate.etime}</td>
                            <td><button type="button"  id="deletecomment" onclick="deleteEvaluate(\${evaluate.eid},\${uname})">删除</button></td>
                       </tr>
                   `;
               });
               //添加tbody块的数据
               $("#tbody").html(tbody);
               //拼接tfoot块的数据
               let tfoot="";
               let tfootStart="";
               if(res.pageNum==1){
                   //首页
                   tfootStart=`
                       <a href="javascript:void (0)" style="color: black">首页</a>
                       <a href="javascript:void (0)" style="color: black">上一页</a>
               `;
               }else {
                   tfootStart=`
                        <a href="javascript:getPageInfoEvaluate(\${1},'\${uname}')" style="color: blue">首页</a>
                       <a href="javascript:getPageInfoEvaluate (\${res.pageNum-1},'\${uname}')" style="color: blue">上一页</a>
                   `;
               };
               let tfootMid="";
               res.navigatepageNums.forEach(value=>{
                   if(value==res.pageNum){
                       tfootMid+=`
                       &nbsp; &nbsp;<a href="javascript:getPageInfoEvaluate(\${value},'\${uname}')" style="color: red">[\${value}]</a>
                       `;
                   }else {
                       tfootMid += `
                        &nbsp;&nbsp;<a href="javascript:getPageInfoEvaluate(\${value},'\${uname}')" style="color: blue">\${value}</a>
                        `;
                   }
               });
               let tfootEnd="";
               if(res.pageNum==res.pages){
                   tfootEnd=`
                       <a href="javascript:void (0)" style="color: black">下一页</a>
                       <a href="javascript:void (0)" style="color: black">尾页</a>
                   `;
               }else {
                   tfootEnd=`
                       <a href="javascript:getPageInfoEvaluate(\${res.pageNum+1},'\${uname}')" style="color: blue">下一页</a>
                       <a href="javascript:getPageInfoEvaluate (\${res.pages},'\${uname}')" style="color: blue">尾页</a>
                   `;
               }
               tfoot=`
                    \${tfootStart}||\${tfootMid}||\${tfootEnd}||总页数：\${res.pages}||总条数：\${res.total}
               `;
               $("#tfoot").html(tfoot);
           },
           error:function (error) {
                Dreamer.error("请求失败");
           }
        });
    };
    //删除评论函数
    function deleteEvaluate(eid,uname) {
        var isdelete=window.confirm("确定要删除？");
        if(isdelete){
            let url="evaluate/deleteEvaluateByEid/"+eid;
            $.get(url,function (res) {
                if(res.status==200){
                    Dreamer.success(res.msg,2000);
                    getPageInfoEvaluate(1,uname);
                }else {
                    Dreamer.error(res.msg);
                }
            },"json");
        }
    }
</script>
<body>
<form class="form-inline definewidth m20" action="#" method="get">
     <font color="#777777"><strong>查询评价：</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="button" class="btn btn-primary queryBtn" id="queryBtn">查询评价</button>&nbsp;&nbsp;

</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>评价内容</th>
        <th>评价人</th>
        <th>博客标题</th>
        <th>评价时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
    <tfoot id="tfoot" id="tfoot">
    </tfoot>
</table>

</body>
</html>
