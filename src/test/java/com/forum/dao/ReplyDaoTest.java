package com.forum.dao;

import com.forum.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ReplyDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReplyDao replyDao;

    @Test
    public void addReply() throws Exception {
        Long itemId = 2L;
        Long userId = 1L;
        String itemContent = "oracle 超级无敌难用！！！";
        replyDao.addReply(itemId, userId, itemContent);
    }

    @Test
    public void deleteReply() throws Exception {
        Long replyId = 2L;
        replyDao.deleteReply(replyId);
    }

    @Test
    public void queryReplyByItemId() throws Exception {
        Long itemId = 2L;
        List<Reply> list = replyDao.queryReplyByItemId(itemId, 1, 5);
        logger.info("list={}", list);
    }

    @Test
    public void queryReplyByUserId() throws Exception {
        Long userId = 1L;
        List<Reply> list = replyDao.queryReplyByUserId(userId, 1, 5);
        logger.info("list={}", list);
    }

    @Test
    public void updateReply() throws Exception {
        Long itemId = 2L;
        String replyContent = "oracle 超级无敌难用！！！, 真的不骗你。";
        replyDao.updateReply(itemId, replyContent);
    }

}