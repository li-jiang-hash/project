package com.aaa.project.service.api;

import com.aaa.project.entity.User;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 21:07
 * @description: Exercise
 * @Version 1.0.0
 */
public interface UserService {
    User getUidByLoginAccount(String loginAccount, String loginPassword);
}
