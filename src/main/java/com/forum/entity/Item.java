package com.forum.entity;

import java.util.Date;

public class Item {
    private Long itemId;
    private Long boardId;
    private Long userId;
    private String itemTitle;
    private String itemContent;
    private int itemState;  // 0禁止  1激活
    private Date itemCreateTime;

    public Item(){}

    public Item(Long boardId, Long userId, String itemTitle) {
        this.boardId = boardId;
        this.userId = userId;
        this.itemTitle = itemTitle;
    }

    public Item(Long boardId, Long userId, String itemTitle, String itemContent) {
        this.boardId = boardId;
        this.userId = userId;
        this.itemTitle = itemTitle;
        this.itemContent = itemContent;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public int getItemState() {
        return itemState;
    }

    public void setItemState(int itemState) {
        this.itemState = itemState;
    }

    public Date getItemCreateTime() {
        return itemCreateTime;
    }

    public void setItemCreateTime(Date itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", boardId=" + boardId +
                ", userId=" + userId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemContent='" + itemContent + '\'' +
                ", itemState=" + itemState +
                ", itemCreateTime=" + itemCreateTime +
                '}';
    }
}
