package com.forum.dao;

import com.forum.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * reply 相关操作
 */
public interface ReplyDao {
    /**
     *  添加回复
     * @param itemId
     * @param userId
     * @param replyContent
     * @return
     */
    int addReply(@Param("itemId") Long itemId, @Param("userId") Long userId, @Param("replyContent") String replyContent);

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    int deleteReply(Long replyId);

    /**
     * 根据itemId 查询回复
     * 支持分页查询
     * @param itemId
     * @return
     */
    List<Reply> queryReplyByItemId(@Param("itemId") Long itemId,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);

    /**
     * 根据用户id查询回复
     * 支持分页查询
     * @param userId
     * @return
     */
    List<Reply> queryReplyByUserId(@Param("userId") Long userId,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);

    /**
     * 查询某个item的回复数
     * @param itemId
     * @return
     */
    int queryReplyCount(Long itemId);

    /**
     * 更新回复
     * @Param itemId
     * @param replyContent
     * @return
     */
    int updateReply(@Param("replyId") Long replyId, @Param("replyContent") String replyContent);

}
