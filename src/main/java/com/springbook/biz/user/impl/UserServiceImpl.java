package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    public UserServiceImpl(){
        System.out.println("UserServiceImpl 생성");
    }

    @Autowired
    private UserDAO userDAO;

    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }
}
