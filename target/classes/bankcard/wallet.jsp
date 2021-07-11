<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getServletContext().getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, target-densitydpi=device-dpi" name="viewport" >
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/weichat.css">
    <title>My Wallet</title>
</head>
<body>
<div class="wrap">
    <div class="top-bar">
        <div class="goback"><a href="Index.html"><img src="../img/fh.png"></a></div>
        <h1>零钱</h1>
        <div class="wallet-more">零钱明细</div>

    </div>
    <div class="wallet-content">
        <div class="wallet-box">
            <img src="../img/aq.png">
            <h2>我的零钱</h2>
            <h3>${wallet.walletMoney}</h3>
            <button class="in-int"><a href="<%=path%>/bankcard/Recharge?id=${wallet.id}">充值</a></button>
            <button class="out"><a href="<%=path%>/wallet/Withdraw?id=${wallet.id}">提现</a></button>
            <p>你有零钱理财资产，点击查看详情</p>
        </div>
    </div>
</div>
<div class="bottom">
    <p class="qs">常见问题</p>
    <p class="ser">本服务由财付通提供</p>
</div>
<script type="text/javascript">
    window.onload=function()
    {
        var getOut=document.getElementsByClassName("out")[0];
        var getIn=document.getElementsByClassName("in-int")[1];
        getOut.onclick=function()
        {
            window.location.href="withdrawal.jsp";
        };
        getIn.onclick=function()
        {
            window.location.href="recharge.jsp";
        };
    };
</script>
</body>
</html>
