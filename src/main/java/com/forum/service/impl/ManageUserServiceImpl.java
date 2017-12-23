package com.forum.service.impl;

import com.forum.dao.UserDao;
import com.forum.dto.UserInfo;
import com.forum.dto.UserRegisterInfo;
import com.forum.entity.User;
import com.forum.service.ManageUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return 正确登录返回userinfo，否则返回null
     */
    public UserInfo userLogin(String userName, String password) {
        UserInfo userInfo = new UserInfo();
        User user = userDao.queryUserByName(userName);
        logger.info("user={}", user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                userInfo.setUserId(user.getUserId());
                userInfo.setUserName(user.getUserName());
                userInfo.setUserType(user.getUserType());
                userDao.updateUserLoginTime(user.getUserId());
                logger.info("user={}", user);
                return userInfo;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * 用户注册
     *
     * @param userInfo
     * @return 成功注册ture，失败返回false
     */
    public boolean userRegister(UserRegisterInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        User user = userDao.queryUserByName(userInfo.getUserName());
        if (user != null) {
            // 用户名已存在
            return false;
        }
        userDao.addUser(userInfo.getUserName(), userInfo.getPassword(), userInfo.getUserEmail());
        return true;
    }

    public User queryInfoById(Long userId) {
        User user = userDao.queryUserById(userId);
        return user;
    }

    public List<User> queryPageUser(int offset) {
        return userDao.queryPageOfUser(offset, 10);  // 一页返回10个用户信息
    }

    /**
     * 修改用户基本信息
     *
     * @param userId
     * @param userName
     * @param password
     * @param userEmail
     */
    public void updateInfo(Long userId, String userName, String password, String userEmail) {
        userDao.updateUser(userId, userName, password, userEmail);
    }

    public List<User> queryByName(String userName) {
        return userDao.queryUserAboutName(userName);
    }

    public void lock(Long userId) {
        userDao.lockUser(userId, 0);
    }

    public void active(Long userId) {
        userDao.lockUser(userId, 1);
    }

    public void beAdmin(Long userId) {
        userDao.updateUserType(userId, 1);
    }

    public void beUser(Long userId) {
        userDao.updateUserType(userId, 0);
    }
}
