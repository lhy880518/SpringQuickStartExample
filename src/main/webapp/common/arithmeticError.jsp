<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2019-05-28
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>기본 에러 화면</title>
</head>
<body bgcolor="#8a2be2" text="#ffe4c4">
<table width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" bgcolor="orange"><b>기본 에러 화면 입니다.</b></td>
    </tr>
</table>
<br/>
<table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="center">
            <br/><br/><br/><br/><br/>
            Message : ${exception.message}
            <br/><br/><br/><br/><br/>
        </td>
    </tr>
</table>
</body>
</html>
