package com.springbook.view.board;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
/**SessionAttributes
 * Model에 "board"라는 이름으로 저장되는 데이터가 있다면 그 데이터를 세션에도 자동으로 저장하라는 설정이다.
 */
@SessionAttributes("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @RequestMapping("/dataTransform.do")
//    @ResponseBody
//    public List<BoardVO> dataTransform(BoardVO vo){
//        vo.setSearchCondition("TITLE");
//        vo.setSearchKeyword("");
//        List<BoardVO> boardList = boardService.getBoardList(vo);
//        return boardList;
//    }
    @RequestMapping("/dataTransform.do")
    @ResponseBody
    public BoardListVO dataTransform(BoardVO vo){
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardList = boardService.getBoardList(vo);
        BoardListVO boardListVO = new BoardListVO();
        boardListVO.setBoardList(boardList);
        return boardListVO;
    }

    // 검색 조건 목록 설정
    @ModelAttribute("conditionMap")
    public Map<String, String> searchConditionMap(){
        Map<String, String> conditionMap = new HashMap<String, String>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) throws IOException {
        System.out.println("글 등록 처리");

        MultipartFile uploadFile = vo.getUploadFile();
        if(!uploadFile.isEmpty()){
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("/Users/ben/Downloads/test1/"+fileName));
        }

        boardService.insertBoard(vo);

        return "getBoardList.do";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(
            @ModelAttribute("board") BoardVO vo) {
        System.out.println("글 수정 처리");
        System.out.println("번호 : "+vo.getSeq());
        System.out.println("제목 : "+vo.getTitle());
        System.out.println("작성자 : "+vo.getWriter());
        System.out.println("내용 : "+vo.getContent());
        System.out.println("등록일 : "+vo.getRegDate());
        System.out.println("조회수 : "+vo.getCnt());

        boardService.updateBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("/deleteBoard.do")
    public String  deleteBoard(BoardVO vo) {
        System.out.println("글 삭제 처리");

        boardService.deleteBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model) {
        System.out.println("글 상세 조회 처리");

        model.addAttribute("board", boardService.getBoard(vo));
        return "getBoard.jsp";
    }

    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, Model model) {
        System.out.println("글 목록 검색 처리");
        if(vo.getSearchCondition() == null){
            vo.setSearchCondition("TITLE");
        }
        if(vo.getSearchKeyword() == null){
            vo.setSearchKeyword("");
        }

        model.addAttribute("boardList", boardService.getBoardList(vo));
        model.addAttribute("vo", vo);
        return "getBoardList.jsp";
    }
}
