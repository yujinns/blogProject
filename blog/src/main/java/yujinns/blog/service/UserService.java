package yujinns.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yujinns.blog.DTO.User;
import yujinns.blog.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

}
