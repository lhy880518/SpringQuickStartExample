<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR" %>
<%
    request.setCharacterEncoding("EUC-KR");
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setWriter(writer);
    vo.setContent(content);

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.insertBoard(vo);

    response.sendRedirect("getBoardList.jsp");
%>