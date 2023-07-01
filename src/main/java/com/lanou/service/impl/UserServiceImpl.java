package com.lanou.service.impl;

import com.lanou.entity.User;
import com.lanou.mapper.UserMapper;
import com.lanou.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段小威
 * @since 2023-05-08
 */
@Service
@MapperScan("com.lanou.mapper")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
