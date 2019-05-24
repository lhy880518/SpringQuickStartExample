package com.springbook.biz.user.impl;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DAO data access object
@Repository("userDAO")
public class UserDAO {
    public UserDAO(){
        System.out.println("UserDAO 생성");
    }

    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL
    private final String USER_GET = "select *from users where id = ? and password = ?";

    //CRUD
    // 회원 get
    public UserVO getUser(UserVO vo){
        UserVO user = null;
        try{
            System.out.println("===> JDBC로 getUser기능 처리"+USER_GET);
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if(rs.next()){
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
}
