package com.kj.review.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kj.review.Entity.User;
import com.kj.review.service.UserService;
import com.kj.review.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author kj
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-03-03 23:16:30
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




