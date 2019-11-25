package cyx.redis1.service;

import cyx.redis1.pojo.User;

import java.util.List;

public interface UserService {
    Integer insert(User user);
    List<User> findAll();
    User findUserById(Integer uid);
}
