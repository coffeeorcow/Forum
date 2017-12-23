package com.forum.dto;

import com.forum.entity.Reply;

public class ReplyInfo {
    private Reply reply;
    private String userName;
    private String itemTitle;

    public ReplyInfo(){

    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "reply=" + reply +
                ", userName='" + userName + '\'' +
                '}';
    }
}
