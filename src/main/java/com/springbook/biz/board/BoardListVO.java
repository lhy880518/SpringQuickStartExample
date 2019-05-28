package com.springbook.biz.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
    @XmlElement(name = "board")
    private List<BoardVO> boardList;

    public List<BoardVO> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<BoardVO> boardList) {
        this.boardList = boardList;
    }
}
