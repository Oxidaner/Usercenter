package com.zzb.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Oxidaner
 * @date 2022/6/19 - 06 - 19 - 16:29
 * 用户登录请求体
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 防止序列化发生冲突
     */
    private static final long serialVersionUID = -7254922421072879410L;
    /**
     * 用户账户
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPassword;

}
