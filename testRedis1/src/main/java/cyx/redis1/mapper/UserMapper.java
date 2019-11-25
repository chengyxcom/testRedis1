package cyx.redis1.mapper;

import cyx.redis1.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer insert(User user);
    List<User> findAll();
    User findUserById(Integer uid);
}
