package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardDAOJPA{

    @PersistenceContext
    private EntityManager em;

    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo){
        System.out.println("===> BoardDAOJPA insertBoard() 기능 처리");
        em.persist(vo);
    }

    // update
    public void updateBoard(BoardVO vo){
        System.out.println("===> BoardDAOJPA updateBoard() 기능 처리");
        em.merge(vo);
    }

    // delete
    public void deleteBoard(BoardVO vo){
        System.out.println("===> BoardDAOJPA deleteBoard() 기능 처리");
        em.remove(em.find(BoardVO.class, vo.getSeq()));
    }

    // get
    public BoardVO getBoard(BoardVO vo){
        System.out.println("===> BoardDAOJPA getBoard() 기능 처리");
        return em.find(BoardVO.class, vo.getSeq());
    }

    // getList
    public List<BoardVO> getBoardList(BoardVO vo){
        System.out.println("===> BoardDAOJPA getBoardList() 기능 처리");
        return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
    }
}
