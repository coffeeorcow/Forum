package com.forum.dao;

import com.forum.entity.User;
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
public class UserDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Test
    public void RegisterUser() throws Exception {
//        int res = userDao.addUser("wjy", "123456", "123456@qq.com");
//        int res = userDao.addUser("张显宗", "123456", "123456@qmail.com");
        String name = "wjy";
        String password = "123456";
        String userEmail = "123456@gmail.com";
        User user = userDao.queryUserByName(name);
        if (user == null) {
            userDao.addUser(name,password, userEmail);
            System.out.println("添加成功！");
        } else{
            System.out.println("添加失败！");
        }
    }

    @Test
    public void queryAllUser() throws Exception {
        List<User> list = userDao.queryAllUser();
        logger.info("list={}", list);
    }

    @Test
    public void queryUserByName() throws Exception{
        User user = userDao.queryUserByName("张");
        logger.info("user={}", user);
    }

    @Test
    public void deleteUser() throws Exception {
        int res = userDao.deleteUser(123L);
        if (res > 0) {
            System.out.println(" 删除成功！");
        } else {
            System.out.println(" 删除失败！");
        }
    }

    @Test
    public void lockUser() throws Exception {
//        int res = userDao.lockUser(2L, 0);
        int res = userDao.lockUser(2L, 1);
        if (res > 0) {
//            System.out.println(" 成功封锁用户");
            System.out.println(" 成功激活用户");
        } else {
            System.out.println(" 更改失败！");
        }
    }

    @Test
    public void updateUserType() throws Exception {
        int res = userDao.updateUserType(2L, 1);
        if (res > 0) {
            System.out.println(" 成功升级为管理员");
        } else {
            System.out.println(" 权限更改失败！");
        }
    }

    @Test
    public void updateUser() throws Exception {
        Long userId = 4L;
        String userName = "张梦岳";
        String password = "123456";
        String userEmail = "123456@qq.com";
        int res = userDao.updateUser(userId, userName, password, userEmail);
        if (res > 0 ) {
            System.out.println("信息变更成功！");
        } else {
            System.out.println("信息变更失败！");
        }
    }

    @Test
    public void updateUserLoginTime() throws Exception {
        Long userId = 4L;
        userDao.updateUserLoginTime(userId);
    }

    @Test
    public void queryPageOfUser() throws Exception{
        List<User> list = userDao.queryPageOfUser(1, 5);
        logger.info("list={}", list);
    }
}