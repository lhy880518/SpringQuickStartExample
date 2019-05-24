<%@page contentType="text/html; charset=EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>�۸��</title>
</head>
<body>
<div style="text-align: center">
<h1>�۸��</h1>
    <h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout.do">Log-Out</a></h3>

    <form action="getBoardList.jsp" method="post">
        <table border="1" cellspacing="0" cellpadding="0" width="700">
            <tr>
                <td align="right">
                    <select name="searchCondition">
                        <option value="TITLE">����</option>
                        <option value="CONTENT">����</option>
                    </select>
                    <input name="searchKeyword" type="text"/>
                    <input type="submit" value="�˻�"/>
                </td>
            </tr>
        </table>
    </form>

    <table border="1" cellspacing="0" cellpadding="0" width="700">
        <tr>
            <th bgcolor="orange" width="100">��ȣ</th>
            <th bgcolor="orange" width="200">����</th>
            <th bgcolor="orange" width="150">�ۼ���</th>
            <th bgcolor="orange" width="150">�����</th>
            <th bgcolor="orange" width="100">��ȸ��</th>
        </tr>


    <c:forEach items="${boardList}" var="board">
    <tr>
        <td>${board.seq}</td>
        <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td>${board.regDate}</td>
        <td>${board.cnt}</td>
    </tr>
    </c:forEach>

    </table>
    <br/>
    <a href="../../insertBoard.jsp">���� ���</a>
</div>
</body>
</html>