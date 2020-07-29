<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-29
  Time: 오전 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    opener.document.location.reload();
    window.opener = window.location.href;
    self.close();
</script>
</body>
</html>
