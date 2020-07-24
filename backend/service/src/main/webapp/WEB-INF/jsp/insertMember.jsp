<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-24
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="memberHeader.jsp"%>
</head>
<body>
    <form action="insertMember" method="post">
        아이디 : <input type="text" name="member_id"/><br/>
        이름 : <input type="text" name="member_name"/><br/>
        비밀번호 : <input type="text" name="member_password"/><br/>
        이메일 : <input type="text" name="member_email"/><br/>
        휴대폰 번호 : <input type="text" name="member_phone"/><br/>
        <input type="submit" value="가입">
    </form>

</body>
</html>
