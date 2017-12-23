package com.forum.dto;

import com.forum.entity.Board;

public class BoardInfo {
    private Board board;
    private int count;

    public BoardInfo(){}

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
