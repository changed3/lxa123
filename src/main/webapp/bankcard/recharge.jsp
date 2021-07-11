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
        <div class="goback"><a href="Index.html"><img src="./img/fh.png"></a></div>
        <h1>零钱充值</h1>
        <div class="wallet-more">.....</div>
    </div>
    <form action="<%=path%>/bankcard/recharge" method="post">
    <div class="tixian-box">
        <div class="tobank">
            <span class="dzyh">到帐银行卡</span>
            <span class="yhk">建设银行(8888)</span>
            <span class="dz">2小时内到帐</span>
        </div>
        <div class="t-moneys">
            <span class="txje">充值金额</span>
            <span class="rmb">￥</span>
            <label for="getmoneys"></label><input type="text" id="getmoneys" class="t-input" name="money">
            <input type="hidden" value="${user.id}" name="id">
            <input type="hidden" value="${user.userName}" name="username">
            <span class="kyye">当前零钱余额：25546.60元，<a href="javascript:;" id="getall">全部提现</a></span>
            <input id="getout" type="submit" value="充值">
        </div>
    </div>
    </form>
</div>
<script>
    window.onload=function()
    {
        var okyMOneys=25546.6;//模拟可用余额,实际使用的时候从数据库返回或其它的操作。
        var oGetAll=document.getElementById("getall");
        var oGetMoneys=document.getElementById("getmoneys");
        var oGetOut=document.getElementById("getout");
        var oKyye=document.getElementsByClassName("kyye")[0];



        oGetMoneys.oninput=function()//监听用户的输入给出相应提示。
        {
            if(oGetMoneys.value=="")
            {
                oGetOut.style.opacity=0.4;
                oKyye.innerHTML="当前零钱余额：25546.60元，<a href='javascript:;'' id='getall'>全部提现</a>"
            }
            else if(parseFloat(oGetMoneys.value)>okyMOneys)
            {
                oGetOut.style.opacity=0.4;
                oKyye.innerHTML="<font color=red>输入金额超过零钱余额</font>"
            }
            else
            {
                var paroGetMoneys=parseFloat(oGetMoneys.value);
                var sxf=paroGetMoneys*0.001;
                var sjdz=paroGetMoneys-sxf;
                //oGetMoneys.value=sjdz.toFixed(2);
                oKyye.innerHTML="额外扣除￥"+sxf.toFixed(2)+"手续费（费率0.1%）";
                oGetOut.style.opacity=1;
                //这里就可以进行与后台交互的操作比如ajax操作等。
            }
        };



        //全部提现
        oGetAll.onclick=function()
        {
            var parGetMoneys=parseFloat(oGetMoneys.value);//格式化成数字
            var sjdz=okyMOneys-(okyMOneys*0.001);//手费0.1%
            var sxf=okyMOneys*0.001;
            oGetMoneys.value=sjdz.toFixed(2);
            oKyye.innerHTML="额外扣除￥"+sxf.toFixed(2)+"手续费（费率0.1%）";
            //alert("a");
        };
    };
</script>
</body>
</html>
