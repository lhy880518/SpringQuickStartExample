<%@page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>���۵��</title>
</head>
<body>
<div style="text-align: center">
    <h1>�� ���</h1>
    <a href="logout.do" >Log-out</a>
    <hr>
    <form action="insertBoard.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">����</td>
                <td align="left"><input name="title" type="text"/></td>
            </tr>
            <tr>
                <td bgcolor="orange" >�ۼ���</td>
                <td align="left"><input name="writer" type="text"/></td>
            </tr>
            <tr>
                <td bgcolor="orange" >����</td>
                <td align="left"><textarea rows="10" cols="40" name="content"></textarea> </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="���� ���"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="getBoardList.jsp.jsp">�� ���</a>
</div>
</body>
</html>