package com.aaa.project.dao.api;

import com.aaa.project.entity.User;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 21:16
 * @description: Exercise
 * @Version 1.0.0
 */
public interface UserDao {
    User selectUidByLoginAccount(String loginAccount, String encodedLoginPassword);
}
