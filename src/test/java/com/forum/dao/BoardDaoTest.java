package com.forum.dao;

import com.forum.entity.Board;
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
public class BoardDaoTest {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardDao boardDao;

    @Test
    public void addBoard() throws Exception {
        String boardName = "Spring";
        String boardDescription = null;
        int res = boardDao.addBoard(boardName, boardDescription);
        if (res > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    @Test
    public void deleteBoard() throws Exception {
        Long boardId = 4L;
        int res = boardDao.deleteBoard(4L);
        if (res > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void queryPageOfBoard() throws Exception {
        List<Board> list = boardDao.queryPageOfBoard(1, 5);
        logger.info("list={}",list);
    }

    @Test
    public void queryByName() throws Exception {
        List<Board> board = boardDao.queryByName("Ora");
        logger.info("board={}", board);
    }

    @Test
    public void updateBoard() throws Exception {
        Long boardId = 2L;
        String boardName = "Oracle";
        String boardDescription = "一种应用广泛的关系型数据库,但收费很高";
        boardDao.updateBoard(boardId, boardName, boardDescription);
    }

}