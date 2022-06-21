package com.zzb.usercenter.service;
import java.util.Date;

import com.zzb.usercenter.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author A
 * @date 2022/5/3 - 05 - 03 - 19:05
 * com.zzb.usercenter.service
 */

/**
 * 用户服务测试
 *
 * @author zsb
 * */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("oxidaner");
        user.setUserAccount("123");
        user.setAvatarUrl("http://qiniu.oxidaner.top/img/favicon.ico");
        user.setGender(0);
        user.setUserPassword("123456");
        user.setPhone("18622412360");
        user.setEmail("111@163.com");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "zsbznb";
        String password = "lele321584";
        String checkPassword = "lele321584";
        long result = userService.userRegister(userAccount, password, checkPassword);
        Assertions.assertEquals(-1,result);
//        System.out.println(result);
    }
}