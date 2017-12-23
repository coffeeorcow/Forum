package com.forum.service.impl;

import com.forum.dao.ItemDao;
import com.forum.dao.ReplyDao;
import com.forum.dao.UserDao;
import com.forum.dto.ReplyInfo;
import com.forum.entity.Reply;
import com.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    // 添加评论
    public void addReply(Long userId, Long itemId, String replyContent) {
        if (!replyContent.trim().equals("")){
            replyDao.addReply(itemId, userId, replyContent);
        }
    }

    // 删除评论
    public void deleteReply(Long replyId) {
        replyDao.deleteReply(replyId);
    }

    // 根据itemId 分页查询评论
    public List<ReplyInfo> queryPageByItemId(Long itemId, int pageNum) {
        // 暂定每页显示5个评论
        List<Reply> replyList = replyDao.queryReplyByItemId(itemId, pageNum, 5);
        List<ReplyInfo> replyInfoList = new ArrayList<ReplyInfo>();
        if (replyList!=null){
            if (replyList.size()>0){
                for (Reply reply : replyList) {
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.setReply(reply);
                    replyInfo.setUserName(userDao.queryUserById(reply.getUserId()).getUserName());
                    replyInfo.setItemTitle(itemDao.queryItemById(reply.getItemId()).getItemTitle());
                    replyInfoList.add(replyInfo);
                }
            }
        }
        return replyInfoList;
    }

    // 根据userId 分页查询评论
    public List<ReplyInfo> queryPageByUserId(Long userId, int pageNum) {
        List<Reply> replyList = replyDao.queryReplyByUserId(userId, pageNum, 9);
        List<ReplyInfo> replyInfoList = new ArrayList<ReplyInfo>();
        if (replyList!=null){
            if (replyList.size()>0){
                for (Reply reply : replyList) {
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.setReply(reply);
                    replyInfo.setUserName(userDao.queryUserById(reply.getUserId()).getUserName());
                    replyInfo.setItemTitle(itemDao.queryItemById(reply.getItemId()).getItemTitle());
                    replyInfoList.add(replyInfo);
                }
            }
        }
        return replyInfoList;
    }

    // 修改评论
    public void updateReply(Reply reply) {
        if (!reply.getReplyContent().trim().equals("")){
            replyDao.updateReply(reply.getReplyId(), reply.getReplyContent());
        }
    }
}
