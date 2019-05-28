//package com.springbook.view.common;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice("com.springbook.view")
//public class CommonExceptionHandler {
//
//    /**
//     * ExceptionHandler사용을위해 presentation-layer.xml에서 꼭 선언해주어야 한다.
//     * <mvc:annotation-driven></mvc:annotation-driven>
//     *
//     */
//    @ExceptionHandler(ArithmeticException.class)
//    public ModelAndView handleArithmeticException(Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.setViewName("/common/arithmeticError.jsp");
//        return mav;
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ModelAndView handleNullPointerException(Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.setViewName("/common/nullPointerError.jsp");
//        return mav;
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.setViewName("/common/error.jsp");
//        return mav;
//    }
//}
