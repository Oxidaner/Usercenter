package com.zzb.usercenter;

import com.zzb.usercenter.mapper.UserMapper;
import com.zzb.usercenter.model.User;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


//@RunWith(SpringRunner.class)
//@SpringBootTest

@SpringBootTest(classes = {UserCenterApplication.class})
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        //断言: 预期
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
