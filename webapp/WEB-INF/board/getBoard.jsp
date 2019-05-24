<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR" %>
<%
    BoardVO board = (BoardVO) session.getAttribute("board");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>�� ��</title>
</head>
<body>
<div style="text-align: center">
    <h1>�� ��</h1>
    <a href="logout.do" >Log-out</a>
    <hr>
    <form action="updateBoard.do" method="post">
        <input name="seq" type="hidden" value="${board.seq}"/>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">����</td>
                <td align="left"><input name="title" type="text" value="${board.title}"/></td>
            </tr>
            <tr>
                <td bgcolor="orange" >�ۼ���</td>
                <td align="left">${board.writer}</td>
            </tr>
            <tr>
                <td bgcolor="orange" >����</td>
                <td align="left"><textarea rows="10" cols="40" name="content">${board.content}</textarea> </td>
            </tr>
            <tr>
                <td bgcolor="orange" >�����</td>
                <td align="left">${board.regDate}</td>
            </tr>
            <tr>
                <td bgcolor="orange" >��ȸ��</td>
                <td align="left">${board.cnt}</td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="�� ����"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="../../insertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
    <a href="deleteBoard.do?seq=${board.seq}">�� ����</a>&nbsp;&nbsp;&nbsp;
    <a href="getBoardList.do">�� ���</a>
</div>
</body>
</html>