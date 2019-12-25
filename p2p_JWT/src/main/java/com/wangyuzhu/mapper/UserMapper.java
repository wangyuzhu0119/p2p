package com.wangyuzhu.mapper;


import com.wangyuzhu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);

}
