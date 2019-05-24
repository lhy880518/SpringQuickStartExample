<%@page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>새글등록</title>
</head>
<body>
<div style="text-align: center">
    <h1>글 등록</h1>
    <a href="logout.do" >Log-out</a>
    <hr>
    <form action="insertBoard.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input name="title" type="text"/></td>
            </tr>
            <tr>
                <td bgcolor="orange" >작성자</td>
                <td align="left"><input name="writer" type="text"/></td>
            </tr>
            <tr>
                <td bgcolor="orange" >내용</td>
                <td align="left"><textarea rows="10" cols="40" name="content"></textarea> </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="새글 등록"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="getBoardList.jsp.jsp">글 목록</a>
</div>
</body>
</html>