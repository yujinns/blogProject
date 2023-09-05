package yujinns.bloguser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yujinns.bloguser.dto.UserDto;
import yujinns.bloguser.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public void insertUser(UserDto userDto) {
        userMapper.insertUser(userDto);
    }
}

