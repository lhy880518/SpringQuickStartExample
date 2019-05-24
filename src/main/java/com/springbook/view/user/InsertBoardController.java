package com.springbook.view.user;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertBoardController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 등록 처리");

        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setWriter(writer);
        vo.setContent(content);

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}
