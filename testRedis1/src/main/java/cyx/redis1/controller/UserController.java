package cyx.redis1.controller;

import cyx.redis1.pojo.User;
import cyx.redis1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public boolean insert(User user){
        Integer count = userService.insert(user);
        if(count!=null){
            return true;
        }
        return false;
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/findUserById")
    public User findUserById(Integer uid){
        return userService.findUserById(uid);
    }
}
