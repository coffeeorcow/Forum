package com.forum.dto;

import com.forum.entity.Item;


/**
 * item 相关信息
 */
public class ItemInfo {
    private Item item;
    private String userName;
    private int replyCount;
    private String boardName;

    public ItemInfo() {
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "item=" + item +
                ", userName='" + userName + '\'' +
                ", replyCount=" + replyCount +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
