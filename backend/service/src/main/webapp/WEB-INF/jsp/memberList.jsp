<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-22
  Time: 오전 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록</title>
    <%@ include file="memberHeader.jsp"%>
    <link rel="stylesheet" href="asset/css/liststyle.css" />
    <style>
         body{
            background-image: url("asset/css/images/green.jpg");
            height: 110%;
            width: 99%;
            background-position: center;
            background-size: cover;
            position: absolute;
        }
        h1 {
            text-align: center;
            margin-top: 2px;
            color: green;
        }
        .h_main{
            width: 350px;
            height: 50px;
            position: center;
            margin: 4% auto;
            overflow: hidden;
            background: #fafafa;
            border-radius: 2em;
            box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
        }
        .submit {
            margin-left: 1050px;
            background-color: #D2FFD2;
            border-radius: 1em;
            padding-top: 2px;
            padding-bottom: 2px;
            padding-right:4px;
            padding-left: 4px;

        }
        #graph{

        }
        .form01 {
            padding: 50px;
        }
        .form02 {
            padding: 50px;
        }

        table {
            width: 100%;
            border-top: 3px solid green;
            border-collapse: collapse;
        }
        tr,th{
            border-bottom: 1px solid #999999;
            text-align: center;
        }

        .left{
            width: 49%;
            float: left;
            margin-left: 10px;
            margin-top: 10px;
            box-sizing: border-box;
            background: #fafafa;
            border-radius: 2em;
        }
        .right{
            width: 47%;
            float: right;
            margin-top: 10px;
            margin-right: 30px;
            box-sizing: border-box;
            background: #fafafa;
            border-radius: 2em;
        }
        .table1{
            width: 100%;
        }
        .table2{
            width: 100%;
        }
    </style>
</head>
    <body>
        <div class = "main">
            <div class ="h_main">
                <h1>safe farm user list</h1>
            </div>

            <button class="submit">
                <a href="main">로그아웃</a>
            </button>

            <div class="left">
                <form class="form01">
                    <table class="table1">
                        <tr>
                            <th>ID</th>
                            <th>닉네임</th>
                            <th>Password</th>
                            <th>상세 정보(수정)</th>
                            <th>삭제</th>
                        </tr>

                        <c:forEach var="row" items="${result}">
                        <tr>
                            <td>${row.member_id}</td>
                            <td>${row.member_nickname}</td>
                            <td>${row.member_password}</td>
                            <td><a href="${path}/memberView?member_id=${row.member_id}">상세 정보</a></td>
                            <td><a href="${path}/deleteMember?member_id=${row.member_id}">삭 제</a></td>
                        </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>

            <div class="right">
                <form class="form02">
                    <table class="table2">
                        <tr>
                            <th>온도</th>
                            <th>습도</th>
                            <th>측정된 날짜 시간</th>
                        </tr>
                        <c:forEach var="row" items="${resultOndo}">
                            <tr>
                                <td>${row.temperature}℃</td>
                                <td>${row.humidity}%</td>
                                <td>${row.nowDatetime}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button id="graph">
                        <a href="http://192.168.0.100:8383/graph">그래프</a>
                    </button>
                </form>
            </div> <%-- 오른쪽 div 끝--%>

        </div>
    </body>
</html>
