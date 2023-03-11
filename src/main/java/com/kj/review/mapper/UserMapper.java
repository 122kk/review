package com.kj.review.mapper;

import com.kj.review.Entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author kj
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-03-03 23:16:30
* @Entity com.kj.review.Entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




