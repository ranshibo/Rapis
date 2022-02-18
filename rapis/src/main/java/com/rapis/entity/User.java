package com.rapis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Data
public class User {
    private int Id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int telephone;
    private int type;
    private int status;
    private String headerUrl;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
