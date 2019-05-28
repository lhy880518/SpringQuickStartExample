<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR" %>
<%
    String seq = request.getParameter("seq");

    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(vo);

    response.sendRedirect("getBoardList.jsp");
%>