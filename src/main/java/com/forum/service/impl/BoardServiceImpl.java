package com.forum.service.impl;

import com.forum.dao.BoardDao;
import com.forum.dto.BoardInfo;
import com.forum.entity.Board;
import com.forum.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    public void addBoard(String boardName, String boardDescription) {
        if (boardName!=null){
            if (!boardName.trim().equals("")){
                boardDao.addBoard(boardName, boardDescription);
            }
        }
    }

    public List<Board> queryAllBoard() {
        return boardDao.queryPageOfBoard(1,30);
    }

    public List<BoardInfo> queryPageBoard() {
        List<Board> list = boardDao.queryPageOfBoard(1, 4);
        List<BoardInfo> boardList = new ArrayList<BoardInfo>();
        for (Board board : list) {
            BoardInfo boardInfo = new BoardInfo();
            boardInfo.setBoard(board);
            boardInfo.setCount(boardDao.queryNum(board.getBoardId()));
            boardList.add(boardInfo);
        }
        return boardList;
    }

    public List<BoardInfo> queryBoardByName(String boardName) {
        List<Board> list = boardDao.queryByName(boardName);
        List<BoardInfo> boardList = new ArrayList<BoardInfo>();
        for (Board board : list) {
            BoardInfo boardInfo = new BoardInfo();
            boardInfo.setBoard(board);
            boardInfo.setCount(boardDao.queryNum(board.getBoardId()));
            boardList.add(boardInfo);
        }
        return boardList;
    }


    public void deleteBoard(Long boarId){
        boardDao.deleteBoard(boarId);
    }

    public void updateBoard(Board board) {
        boardDao.updateBoard(board.getBoardId(), board.getBoardName(), board.getBoardDescription());
    }
}
