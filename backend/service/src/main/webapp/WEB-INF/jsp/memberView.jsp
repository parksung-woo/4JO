<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-23
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>회원정보 상세</title>
    <%@ include file="memberHeader.jsp"%>
    <style>
        body{
            background-image: url("asset/css/images/green.jpg");
            height: 95%;
            width: 99%;
            background-position: center;
            background-size: cover;
            position: absolute;
        }
        .boby{
            width: 380px;
            height: 480px;
            position: relative;
            margin: 6% auto;
            background: #fafafa;
            padding: 5px;
            overflow: hidden;
            border-radius: 2em;
            box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
        }
        .form_body{
            width: 400px;
            height: 500px;
        }
        h2{
            text-align: center;
            color: green;
        }
        table {
            width: 100%;
            margin-top: 50px;
            border-top: 3px solid green;
            border-collapse: collapse;
        }
        tr,th{
            border-bottom: 1px solid #999999;
            text-align: center;
        }
        tr{
            margin-bottom: 100px;
        }
        #back{
            margin-right: 10px;
        }
        img{
            margin-top: 10px;
            margin-left: 42px;
            width: 300px;
            height: 250px;
            border-radius: 10px;

        }
    </style>
</head>
<body>
<div class ="boby">
    <h2>회원 정보 상세 페이지</h2>
    <form class="form_body" name="form02" method="post" action="/updateMember">
        <table>
            <tr>
                <td>아이디</td>
                <td><input name="member_id" value="${list.member_id}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="member_password" value="${list.member_password}"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input name="member_nickname" value="${list.member_nickname}"></td>
            </tr>
            <tr>
                <td colspan="5" align="center">
                    <input type="submit" value="이전" id="back" href="memberlist.jsp" >
                    <input type="submit" value="수정" id="btnUpdate" >
                </td>
            </tr>
        </table>
        <div>
            <img src="./asset/css/images/pp.png"/>
        </div>
    </form>
</div>
</body>
</html>
