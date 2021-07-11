<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getServletContext().getContextPath();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <style>
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }
        body{
            margin: auto 50px;
            height: 80%;
            background: url("./img/background.png")top no-repeat ;
            width: 100%;
            height: 100%;
            background-size: 100%;
            padding-top: 300px;
        }
        .rg_layout{
            width: 100px;
            height: 500px;
            /*让div水平居中*/
            margin: auto;
        }

        .rg_left{
            /*border: 1px solid red;*/
            float: left;
            margin: 15px;
        }
        .rg_left > p:first-child{
            color:#FFD026;
            font-size: 20px;
        }

        .rg_left > p:last-child{
            color:#A6A6A6;
            font-size: 20px;

        }


        .rg_center{
            float: left;
            top: 10px;
            /*  position: absolute;
              filter: alpha(opacity=10)*/
            /* border: 1px solid red;*/

        }

        .rg_right > p:first-child{
            font-size: 15px;

        }
        .rg_right p a {
            color:pink;
        }

        .td_left{
            width: 100px;
            text-align: right;
            height: 45px;
        }
        .td_right{
            padding-left: 50px ;
        }

        #username,#password{
            width: 251px;
            height: 50px;
            border: 1px solid #A6A6A6 ;
            /*设置边框圆角*/
            border-radius: 5px;
            padding-left: 10px;
        }

        #btn_sub{
            width: 150px;
            height: 40px;
            background-color: #FFD026;
            border: 1px solid #FFD026 ;
        }

        #td_sub{
            padding-left: 150px;
        }

    </style>
</head>
<body>
<div class="rg_layout">
    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="<%=path%>/user/login" id="form" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right">
                            <input type="text" name="userName" id="username" placeholder="请输入用户名">
                            <span id="s_username" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right">
                            <input type="password" name="userPassword" id="password" placeholder="请输入密码">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" id="td_sub"><input type="submit" id="btn_sub" value="登录"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
