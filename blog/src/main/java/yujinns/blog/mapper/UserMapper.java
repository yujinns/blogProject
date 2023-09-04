package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yujinns.blog.DTO.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    void insertUser(User user);

    void deleteUserById(String id);

    void updateUser(User user);

    User selectUserById(String id);

    List<User> getAllUsers();
}
