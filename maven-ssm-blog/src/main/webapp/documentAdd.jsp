<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery2.js"></script>
    <script type="text/javascript" src="js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquerypicture.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <script type="application/javascript">

        var ue = UE.getEditor('editor');

        function commit(){
            $("#form3").submit();
        }
    </script>
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
        selectBtypeList();
        $("#oneTypeId").change(function () {
            var oneTypeId=$("#oneTypeId").val();
            selectBtypeList(oneTypeId);
        });
        $("#subBtn").click(function(){
           var formData=$("#formId").serialize();
           alert(formData);
           $.ajax({
               url:"blog/addBlog",
               data:formData,
               dataType:"json",
               type:"post",
               success:function(res){
                   if(res.status=="200"){
                       Dreamer.success(res.msg,1500);
                       window.setTimeout(function(){
                           window.location.href="blog_list.jsp";
                       },1500);
                   }else if(res.status="202"){
                       Dreamer.error(res.msg,1500);
                   }else{
                       Dreamer.error(res.msg,1500);
                       window.setTimeout(function(){
                          window.open("login.jsp","_top");
                       },1500);
                   }
               },
               error:function (error) {
                   Dreamer.error("大哥你的程序出错了");
               }
           });
        });
    });

    //请求你的类型信息  不传查询一级分类，传查询二级分类
    function selectBtypeList(bid) {
        if(bid==undefined||bid==""){
            bid=0;
        }
        $.ajax({
            url:"btype/selectBtypeList",
            data:{
                "bid":bid
            },
            dataType:"json",
            type:"get",
            success:function(res){
                console.log(res);
                if(bid==0){
                    bigBtype(res);
                }else {
                    smallByte(res);
                }
            },
            error:function (error) {
                Dreamer.error("大哥请求出错了，请看你程序");
            }
        });
    }
    function bigBtype(res) {
        let oneBody="";
        res.forEach(function (bt) {
            oneBody+=`
             <option value="\${bt.typeid}">\${bt.typename}</option>
            `;
        });
        $("#oneTypeId").html(oneBody);
    }
    function smallByte(res) {
        let twoBody="";
        res.forEach(function (bt) {
            twoBody+=`
             <option value="\${bt.typeid}">\${bt.typename}</option>
            `;
        });
        $("#twoTypeId").html(twoBody);
    }
</script>
<body>
<form action="javascript:void(0);" method="post" id="formId" class="definewidth m20" enctype="multipart/form-data">
<table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
    <tr>
        <td width="10%" class="tableleft">类别</td>
        <td>
            <select name="bigTypeId" id="oneTypeId">
                <option value="0">==请选择大类==</option>
            </select>
            <select name="typeFk" id="twoTypeId">
                <option value="0">==请选择小类==</option>
            </select>
        </td>
    </tr>


    <tr>
        <td class="tableleft">博客标题</td>
        <td><input type="text" name="btitle"/></td>
    </tr>
    <tr>
        <td class="tableleft">博客内容</td>
        <td>
            <script id="editor" name="bcontent" type="text/plain" style="width:1024px;height:300px;"></script>
        </td>
    </tr>

    <tr>
        <td class="tableleft"></td>
        <td>
            <button style="margin-left:5px;"type="button" id="subBtn" class="btn btn-primary" type="button"  >保存</button> &nbsp;
<%--            &nbsp;<input type="submit" value="提交"/>--%>
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>

</body>
</html>

