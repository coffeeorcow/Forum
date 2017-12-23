package com.forum.entity;

public class Board {
    private Long boardId;  // 模块id
    private String boardName;  // 模块名称
    private int boardCount;  // 模块内的发表数
    private String boardDescription;  // 模块描述

    public Board(){}

    public Board(String boardName) {
        this.boardName = boardName;
    }

    public Board(String boardName, String boardDescription) {
        this.boardName = boardName;
        this.boardDescription = boardDescription;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public void setBoardCount(int boardCount) {
        this.boardCount = boardCount;
    }

    public String getBoardDescription() {
        return boardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        this.boardDescription = boardDescription;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", boardCount=" + boardCount +
                ", boardDescription='" + boardDescription + '\'' +
                '}';
    }
}
