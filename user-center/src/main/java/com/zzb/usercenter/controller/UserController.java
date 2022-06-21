package com.zzb.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzb.usercenter.model.domain.User;
import com.zzb.usercenter.model.domain.request.UserLoginRequest;
import com.zzb.usercenter.model.domain.request.UserRegisterRequest;
import com.zzb.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.zzb.usercenter.constant.UserConstant.ADMIN_ROLDE;
import static com.zzb.usercenter.constant.UserConstant.User_LOGIN_STATE;

/**
 * @author Oxidaner
 * @date 2022/6/19 - 06 - 19 - 11:58
 * 用户接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAllEmpty(userAccount, userPassword, checkPassword)) {
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAllEmpty(userAccount, userPassword)) {
            return null;
        }
        return userService.userLogin(userAccount, userPassword, request);
    }

    @GetMapping("/search")
    public List<User> searchUsers(String username, HttpServletRequest request) {
        // 仅管理员可查询
        if(!isAdmin(request)) {
            return new ArrayList<>();
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if(StringUtils.isNoneBlank(username)){
            //默认模糊查询
            userQueryWrapper.like("username",username);
        }
        List<User> userlist = userService.list(userQueryWrapper);
        return userlist.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
    }

    @PostMapping("/delete")
    public boolean DeleteUsers(@RequestBody long id, HttpServletRequest request) {
        // 仅管理员可查询
        if (!isAdmin(request)) {
            return false;
        }
        if (id <= 0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 是否为管理员
     * */
    private boolean isAdmin(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(User_LOGIN_STATE);
        User user = (User) userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLDE) {
            return false;
        }
        return true;
    }


}
