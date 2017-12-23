package com.forum.dao;

import com.forum.entity.Item;
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
public class ItemDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemDao itemDao;

    @Test
    public void addItem() throws Exception {
        Long boardId = 2L;
        Long userId = 4L;
        String itemTitle = "oracle数据库的架构详解";
        String itemContent = "1.blablabal....\n" +"2.blablabla...\n";
        itemDao.addItem(boardId,userId, itemTitle, itemContent);
    }

    @Test
    public void deleteItem() throws Exception {
        Long itemId = 4L;
        itemDao.deleteItem(itemId);
    }

    @Test
    public void queryItemByBoardId() throws Exception {
        Long boardId = 2L;
        List<Item> list = itemDao.queryItemByBoardId(boardId);
        logger.info("item={}", list);
    }

    @Test
    public void queryItemByUserName() throws Exception {
        String userName = "张";
        List<Item> list = itemDao.queryItemByUserName(userName);
        logger.info("list={}", list);
    }

    @Test
    public void queryPageOfItem() throws Exception {
        List<Item> list = itemDao.queryPageOfItem(1, 5);
        logger.info("list={}", list);
    }

    @Test
    public void updateItem() throws Exception {
        Long itemId = 2L;
        String itemTitle = "Oracle基本使用介绍";
        String itemContent = "1.使用sqlplus\n" +
                "2.blablabal...\n" +
                "3.balbalbal....\n";
        itemDao.updateItem(itemId, itemTitle, itemContent);
    }

}