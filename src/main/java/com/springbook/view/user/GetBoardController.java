package com.springbook.view.user;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 처리");

        String seq = request.getParameter("seq");

        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(vo);

        HttpSession session = request.getSession();
        session.setAttribute("board", board);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("getBoard.do");
        return mav;
    }
}
