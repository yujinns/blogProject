package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<User> getUsersByPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

    int getTotalUserCount();
}
