package com.aaa.project.dao.impl;

import com.aaa.project.dao.BaseDao;
import com.aaa.project.dao.api.UserDao;
import com.aaa.project.entity.User;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 19:29
 * @description: Exercise
 * @Version 1.0.0
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    String sql ="select user_id userId,user_name userName,login_account loginAccount,login_password loginPassword from project_user where user_id=?";

    @Override
    public User selectUidByLoginAccount(String loginAccount, String encodedLoginPassword) {
        String sql ="select user_id userId," +
                "user_name userName," +
                "login_account loginAccount," +
                "login_password loginPassword from project_user " +
                "where login_account=? and login_password=?";
        System.out.println("执行力");
        return super.getSingleBean(sql,User.class,loginAccount,encodedLoginPassword);
    }
}
