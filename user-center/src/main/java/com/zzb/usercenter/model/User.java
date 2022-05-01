package com.zzb.usercenter.model;

import lombok.Data;

/**
 * @author A
 * @date 2022/3/21 - 03 - 21 - 14:43
 * com.zzb.usercenter.model
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
