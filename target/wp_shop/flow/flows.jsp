<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getServletContext().getContextPath();
%>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户流水信息管理系统</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户流水信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label for="exampleInputName2">业务</label>
                <input type="text" name="content" value="${condition.content[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">选择查询的月数</label>
                <input type="date" name="startTime" value="${condition.date[0]}" class="form-control" id="exampleInputName3" >
            </div>

            <%-- <div class="form-group">
                 <label for="exampleInputEmail2">终止时间</label>
                 <input type="datetime-local" name="endTime" value="${condition.date[0]}" class="form-control" id="exampleInputEmail2"  >
             </div>--%>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <table>
        <thead>
        <tr>
            <th>流水id</th>
            <th>业务单号</th>
            <th>用户名</th>
            <th>金额</th>
            <th>业务内容</th>
            <th>银行卡号</th>
            <th>当前状态</th>
            <th>创建时间</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${flows}" var="flow">
            <tr>
                <td>${flow.flowId}</td>
                <td>${flow.flowOrderNumber}</td>
                <td>${flow.flowUserName}</td>
                <td>${flow.flowMoney}</td>
                <td>${flow.flowType}</td>
                <td>${flow.flowBankNumber}</td>
                <td>${flow.flowStatus}</td>
                <td>${flow.flowCreateTime}</td>
                <td>
                    <div class="btn-group">
                        <button class="btn">操作</button>
                        <button data-toggle="dropdown" class="btn dropdown-toggle">
                            <span class="caret"></span>
                        </button>

                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>
</body>
</html>
