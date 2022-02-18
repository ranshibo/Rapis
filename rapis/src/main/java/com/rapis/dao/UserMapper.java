package com.rapis.dao;

import com.rapis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Mapper
public interface UserMapper {
    int insertUser(User user);

    User getUserByName(String name);
}
