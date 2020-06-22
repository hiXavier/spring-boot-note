package com.xavier.note.service.impl;

import com.xavier.note.entity.User;
import com.xavier.note.mapper.one.UserMapper;
import com.xavier.note.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuyanfeng
 * @since 2020-04-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
