package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
//public class BoardDAOSpring extends JdbcDaoSupport {
public class BoardDAOSpring{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // SQL 명령어들
//    private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq)+1, 0) from board), ?,?,?)";
    private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_GET = "select *From board where seq=?";
    private final String BOARD_LIST = "select *from board order by seq desc";

//    @Autowired
//    public void setSuperDataSource(DataSource dataSource){
//        super.setDataSource(dataSource);
//    }

    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo){
        System.out.println("===> SPRING JDBC로 insertBoard() 기능 처리");
//        getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//        jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
        jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    // update
    public void updateBoard(BoardVO vo){
        System.out.println("===> SPRING JDBC로 updateBoard() 기능 처리");
//        getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
        jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    // delete
    public void deleteBoard(BoardVO vo){
        System.out.println("===> SPRING JDBC로 deleteBoard() 기능 처리");
//        getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
        jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
    }

    // get
    public BoardVO getBoard(BoardVO vo){
        System.out.println("===> SPRING JDBC로 getBoard() 기능 처리");
        Object[] args = {vo.getSeq()};
//        return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
        return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    // getList
    public List<BoardVO> getBoardList(BoardVO vo){
        System.out.println("===> SPRING JDBC로 getBoardList() 기능 처리");
//        return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
        return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
    }

}
