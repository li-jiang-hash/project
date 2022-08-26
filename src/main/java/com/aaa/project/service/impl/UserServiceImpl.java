package com.aaa.project.service.impl;

import com.aaa.project.dao.api.UserDao;
import com.aaa.project.dao.impl.UserDaoImpl;
import com.aaa.project.entity.User;
import com.aaa.project.exception.LoginFailedException;
import com.aaa.project.service.api.UserService;
import com.aaa.project.util.ImperialCourtConst;
import com.aaa.project.util.MD5Util;
import com.aaa.project.util.MD5UtilTest;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 21:08
 * @description: Exercise
 * @Version 1.0.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User getUidByLoginAccount(String loginAccount, String loginPassword) {


        String encodedLoginPassword = MD5Util.encode(loginPassword);
//        String encodedLoginPassword = MD5UtilTest.encode(loginPassword).toUpperCase();
        System.out.println(encodedLoginPassword);
        User user = userDao.selectUidByLoginAccount(loginAccount,encodedLoginPassword);
        if(user !=null){
            System.out.println("登录成功");
            return user;
        }else {
            System.out.println("登陆失败");
            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
