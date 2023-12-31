package yujinns.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yujinns.blog.DTO.User;
import yujinns.blog.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {


    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void insertUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.insertUser(user);
    }

    public boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void deleteUserById(String id) { userMapper.deleteUserById(id); }

    public void updateUser(User user) { userMapper.updateUser(user);}

    public User selectUserById(String id) { return userMapper.selectUserById(id); }

    public List<User> getAllUsers() { return userMapper.getAllUsers(); }

    public List<User> getUsersByPage(int page, int pageSize) {
        int startRow = (page - 1) * pageSize + 1;
        int endRow = startRow + pageSize - 1;

        return userMapper.getUsersByPage(startRow, endRow);
    }

    public int getTotalUserCount() {
        return userMapper.getTotalUserCount();
    }

    public void changePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.changePassword(user);
    }

    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

}
