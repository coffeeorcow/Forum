package com.forum.service;

import com.forum.dto.ReplyInfo;
import com.forum.entity.Reply;

import java.util.List;

/**
 * 评论相关操作
 */
public interface ReplyService {
    /**
     * 添加评论
     * @param userId 用户id
     * @param itemId itemmId
     * @param replyContent 回复内容
     */
    void addReply(Long userId, Long itemId, String replyContent);

    /**
     * 撤销回复
     * @param replyId 回复id
     */
    void deleteReply(Long replyId);

    /**
     * 根据itemId 分页查询评论
     * @param itemId itemId
     * @param pageNum 第几页
     * @return 回复信息列表
     */
    List<ReplyInfo> queryPageByItemId(Long itemId, int pageNum);

    /**
     * 根据userId 分页查询评论
     * @param userId
     * @param pageNum
     * @return
     */
    List<ReplyInfo> queryPageByUserId(Long userId, int pageNum);

    /**
     * 修改评论信息
     * @param reply
     */
    void updateReply(Reply reply);
}
