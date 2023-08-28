package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yujinns.blog.DTO.User;

@Mapper
@Repository
public interface UserMapper {

    void insertUser(User user);

    void deleteUserById(String id);

    User selectUserById(String id);
}
