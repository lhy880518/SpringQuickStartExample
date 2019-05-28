package com.springbook.view.user;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController{

    @RequestMapping("/logout.do")
    public String  handleRequest(HttpSession session) throws Exception {
        System.out.println("로그아웃 처리");

        session.invalidate();
        return "login.jsp";
    }
}
