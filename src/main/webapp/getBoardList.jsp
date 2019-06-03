<%@page contentType="text/html; charset=EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>글목록</title>
</head>
<body>
<div style="text-align: center">
<h1>글목록</h1>
    <h3>${userName}님 환영합니다...<a href="logout.do">Log-Out</a></h3>

    <form action="getBoardList.do" method="post">
        <table border="1" cellspacing="0" cellpadding="0" width="700">
            <tr>
                <td align="right">
                    <select name="searchCondition">
                        <c:forEach items="${conditionMap}" var="option">
                            <option value="${option.value}" <c:if test="${vo.searchCondition eq option.value}">selected</c:if> >${option.key}</option>
                        </c:forEach>
                    </select>
                    <input name="searchKeyword" type="text" value="${vo.searchKeyword}"/>
                    <input type="submit" value="검색"/>
                </td>
            </tr>
        </table>
    </form>

    <table border="1" cellspacing="0" cellpadding="0" width="700">
        <tr>
            <th bgcolor="orange" width="100">번호</th>
            <th bgcolor="orange" width="200">제목</th>
            <th bgcolor="orange" width="150">작성자</th>
            <th bgcolor="orange" width="150">등록일</th>
            <th bgcolor="orange" width="100">조회수</th>
        </tr>

    <c:forEach items="${boardList }" var="board">
    <tr>
        <td>${board.seq}</td>
        <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/></td>
        <td>${board.cnt}</td>
    </tr>
    </c:forEach>

    </table>
    <br/>
    <a href="insertBoard.jsp">새글 등록</a>
</div>
</body>
</html>