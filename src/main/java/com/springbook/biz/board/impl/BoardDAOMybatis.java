package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAOMybatis  extends SqlSessionDaoSupport {

    @Autowired
    private SqlSessionTemplate mybatis;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo){
        System.out.println("===> Mybatis insertBoard() 기능 처리");
//        getSqlSession().insert("Board.insertBoard", vo);
        mybatis.insert("Board.insertBoard", vo);
    }

    // update
    public void updateBoard(BoardVO vo){
        System.out.println("===> Mybatis updateBoard() 기능 처리");
//        getSqlSession().update("Board.updateBoard", vo);
        mybatis.update("Board.updateBoard", vo);
    }

    // delete
    public void deleteBoard(BoardVO vo){
        System.out.println("===> Mybatis deleteBoard() 기능 처리");
//        getSqlSession().delete("Board.deleteBoard", vo);
        mybatis.delete("Board.deleteBoard", vo);
    }

    // get
    public BoardVO getBoard(BoardVO vo){
        System.out.println("===> Mybatis getBoard() 기능 처리");
//        return getSqlSession().selectOne("BoardDAO.getBoard",vo);
        return mybatis.selectOne("BoardDAO.getBoard",vo);
    }

    // getList
    public List<BoardVO> getBoardList(BoardVO vo){
        System.out.println("===> Mybatis getBoardList() 기능 처리");
//        return getSqlSession().selectList("BoardDAO.getBoardList",vo);
//        if(vo.getSearchCondition().equals("TITLE")){
//            return mybatis.selectList("BoardDAO.getBoardList_T",vo);
//        }else if(vo.getSearchCondition().equals("CONTENT")){
//            return mybatis.selectList("BoardDAO.getBoardList_C",vo);
//        }
//        return null;
        return mybatis.selectList("BoardDAO.getBoardList",vo);
    }
}
