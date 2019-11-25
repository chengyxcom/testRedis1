package cyx.redis1.service.impl;

import cyx.redis1.mapper.UserMapper;
import cyx.redis1.pojo.User;
import cyx.redis1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Integer insert(User user) {
        user.setDate(new Date());
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    @Cacheable(value = "users")
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

    @Override
    @Transactional
    @Cacheable(key = "#uid", value = "user")
    public User findUserById(Integer uid) {
        User user = userMapper.findUserById(uid);
        return user;
    }
}
