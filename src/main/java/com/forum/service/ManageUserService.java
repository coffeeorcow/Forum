package com.forum.service;

import com.forum.dto.UserInfo;
import com.forum.dto.UserRegisterInfo;
import com.forum.entity.User;

import java.util.List;

public interface ManageUserService {
    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return 存在则返回用户, 不存在则返回空值
     */
    UserInfo userLogin(String userName, String password);

    /**
     * 用户注册
     *
     * @param userInfo
     * @return 成功返回ture， 失败返回false
     */
    boolean userRegister(UserRegisterInfo userInfo);

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    User queryInfoById(Long userId);

    /**
     * 查询一页用户
     * @param offset
     * @return
     */
    List<User> queryPageUser(int offset);

    /**
     * 修改用户信息
     *
     * @param userId
     * @param userName
     * @param password
     * @param userEmail
     */
    void updateInfo(Long userId, String userName, String password, String userEmail);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    List<User> queryByName(String userName);

    /**
     * 封锁用户
     * @param userId
     */
    void lock(Long userId);

    /**
     * 激活用户
     * @param userId
     */
    void active(Long userId);

    /**
     * 设置为管理员
     * @param userId
     */
    void beAdmin(Long userId);

    /**
     * 设置为普通用户
     * @param userId
     */
    void beUser(Long userId);

}
