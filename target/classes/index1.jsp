<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    String path = request.getServletContext().getContextPath();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, target-densitydpi=device-dpi"
          name="viewport">
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css" href="./css/weichat.css">
    <title>My Wallet</title>
</head>
<body>
<div class="wrap">
    <div class="top-bar">
        <div class="goback"><img src="./img/fh.png"></div>
        <h1>${login_success.userName}的钱包</h1>
        <div class="more"><img src="./img/more.png"></div>
        <div class="top-con">
            <div class="top-con-box">
                <img src="./img/shoufukuan.png">
                <h4>收付款</h4>
                </a>
            </div>
<%--            ${login_success.id}--%>
<%--            ${login_success.userName}--%>
            <div class="top-con-box">
                <a href="<%=path%>/bankcard/wallet">
                    <img src="./img/qianbao.png">
                    <h4>零钱</h4>
<%--                    <p>￥200.00</p>--%>
                </a>
            </div>
            <div class="top-con-box">
                <img src="./img/card.png">
                <h4>信用卡还款</h4>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="con-bar">
            <h5>腾讯服务</h5>
        </div>

        <div class="con-box">
            <img src="./img/shouji.png">
            <h5>手机充值</h5>
        </div>
        <div class="con-box">
            <img src="./img/shenghoujiaofei.png">
            <h5>生活缴费</h5>
        </div>
        <div class="con-box">
            <a href="<%=path%>/flow/selectAll?id=${login_success.id}">
                <img src="./img/zhangdan.png">
                <h5>个人账单</h5>
            </a>
        </div>
        <div class="con-box">
            <img src="./img/yiliao.png">
            <h5>医疗健康</h5>
        </div>
        <div class="con-box">
            <img src="./img/chengshi.png">
            <h5>城市服务</h5>
        </div>
        <div class="con-box">
            <img src="./img/huochepiao.png">
            <h5>火车票机票</h5>
        </div>
    </div>
</div>
</body>
</html>
