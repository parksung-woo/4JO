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
    <title>Test</title>
    <%@ include file="memberHeader.jsp"%>
</head>
    <body>
        <form name="form01">
            <table border="1" width="700px">
                <tr>
                    <th>ID</th>
                    <th>이름</th>
                    <th>Password</th>
                    <th>이메일</th>
                    <th>전화 번호</th>
                    <th>상세 정보(수정)</th>
                    <th>삭제</th>
                </tr>
                <c:forEach var="row" items="${result}">
                <tr>
                    <td>${row.member_id}</td>
                    <td>${row.member_name}</td>
                    <td>${row.member_password}</td>
                    <td>${row.member_email}</td>
                    <td>${row.member_phone}</td>
                    <td><a href="${path}/memberView?member_id=${row.member_id}">상세 정보</a></td>
                    <td><a href="${path}/deleteMember?member_id=${row.member_id}">삭 제</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
