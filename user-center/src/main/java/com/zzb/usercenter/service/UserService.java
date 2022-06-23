package com.zzb.usercenter.service;

import com.zzb.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author oxidaner
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-05-03 18:59:29
*/
public interface UserService extends IService<User> {



    /**
     * 用户注册
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     *  用户登录
     * @param userAccount 用户胡账户
     * @param userPassword 用户密码
     * @return 脱敏后用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户登出
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

}
