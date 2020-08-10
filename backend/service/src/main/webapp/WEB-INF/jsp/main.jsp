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
    <title>4조 관리자</title>
    <link rel="stylesheet" href="asset/css/loginstyle.css" />
</head>
<body>
<div class="wrap">
    <div class="form-wrap">
        <div class="managertitle">
            <h1>SAFE FARM</h1>
        </div>
        <div class="social-icons">
            <img src="asset/css/images/tree.png" />
            <img src="asset/css/images/pig.png" />
            <img src="asset/css/images/tree.png" />
            <img src="asset/css/images/pig.png" />
        </div>
        <form action="login" id="login" class="input-group" method="post">
            <input
                    type="text"
                    name="id"
                    class="input-field"
                    placeholder="Manager Id"
                    required
            />
            <input
                    type="password"
                    name="password"
                    class="input-field"
                    placeholder="Enter Password"
                    required
            />
            <button
                    class="submit"
                    style="margin-top: 70px;"
                    href="memberlist.jsp"
            >
                Login
            </button>
        </form>
        <div class="companyname">
            4jo_company abcdefg
        </div>
    </div>
</div>
</body>
</html>