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
    <script>
        $(document).ready(function () {
            $("btnUpdate").click(function () {
                if(confirm("수정 하시겠습니까?")){
                    document.form02.action = "${path}/memberList";
                    document.form02.submit();
                }
            });

        });
        $(document).ready(function () {
            $("btnDelete").click(function () {
                if(confirm("삭제 하시겠습니까?")){
                    document.form02.action = "${path}/deleteMember";
                    document.form02.submit();
                }
            });

        });
    </script>
</head>
<body>
    <h2>회원 정보 상세 페이지</h2>
    <form name="form02" method="post" action="/updateMember">
        <table border="1" width="400px">
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
                <td colspan="2" align="center">
                    <input type="submit" value="수정" id="btnUpdate" >
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
