package com.forum.entity;

import java.util.Date;

public class Reply {
    private Long replyId;
    private Long itemId;
    private Long userId;
    private String replyContent;
    private Date replyTime;

    public Reply(){

    }

    public Reply(Long itemId, Long userId, String replyContent) {
        this.itemId = itemId;
        this.userId = userId;
        this.replyContent = replyContent;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyCreateTime() {
        return replyTime;
    }

    public void setReplyCreateTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }
}

