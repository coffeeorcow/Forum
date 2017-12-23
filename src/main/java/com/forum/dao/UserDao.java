package com.forum.dao;

import com.forum.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户相关操作
 */
public interface UserDao {
    /**
     * 添加用户
     * @param userName 用户名
     * @param password 密码
     * @param userEmail email
     * @return 成功数
     */
    int addUser(@Param("userName") String userName, @Param("password") String password, @Param("userEmail") String userEmail);

    /**
     * 查询所有用户
     * @return 所有用户信息
     */
     List<User> queryAllUser();

    /**
     * 分页查询用户
     * @param offset  页偏移量
     * @param limit  每页的条数
     * @return 一页用户信息
     */
     List<User> queryPageOfUser(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据姓名查找用户
     * @return 用户信息
     */
     User queryUserByName(String userName);

    /**
     * 根据姓名模糊查找用户
     * @param userName
     * @return
     */
     List<User> queryUserAboutName(String userName);

    /**
     * 根据用户号查询user
     * @return user对象
     */
     User queryUserById(Long userId);

    /**
     * 删除用户
     * @param userId 用户id
     * @return 成功数
     */
     int deleteUser(Long userId);

    /**
     *  封锁用户
     *  0 封锁 1 激活
     * @param userId 用户id
     * @param userState 用户状态
     * @return 成功数
     */
     int lockUser(@Param("userId") Long userId, @Param("userState") int userState);

    /**
     *  更改用户权限
     *  0 普通用户
     *  1 管理员用户
     * @param userId 用户id
     * @param userType 用户类型
     * @return 成功数
     */
     int updateUserType(@Param("userId") Long userId, @Param("userType") int userType);

    /**
     * 更新用户信息
     * @param userId 用户id
     * @param userName 用户名
     * @param password 密码
     * @param userEmail email
     * @return 成功数
     */
     int updateUser(@Param("userId") Long userId, @Param("userName") String userName, @Param("password") String password, @Param("userEmail") String userEmail);

    /**
     * 更新用户最近登录时间
     * @param userId 用户id
     * @return 成功数
     */
     int updateUserLoginTime(@Param("userId") Long userId);
}
