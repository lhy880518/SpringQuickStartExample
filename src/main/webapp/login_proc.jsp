<%@page import="com.springbook.biz.user.impl.UserDAO" %>
<%@page import="com.springbook.biz.user.UserVO" %>
<%@page contentType="text/html; charset=EUC-KR" %>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    System.out.println(id+password);
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    if(user != null){
        response.sendRedirect("getBoardList.jsp");
    }else{
        response.sendRedirect("login.jsp");
    }
%>